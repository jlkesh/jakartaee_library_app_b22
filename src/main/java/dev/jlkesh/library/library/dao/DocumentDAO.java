package dev.jlkesh.library.library.dao;

import dev.jlkesh.library.library.domains.Document;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentDAO extends DAO<Document, Integer> {
    public static DocumentDAO instance;

    private final String INSERT_DOCUMENT = """
            insert into library1.document ( 
            generatedFileName,
            originalFileName,
            mimeType,
            filePath,
            fileSize,
            extension) values (?,?,?,?,?,?);""";
    private final String SELECT_BY_NEW_NAME = """
                            select * from library1.document t where t.generatedFileName = ?;
            """;

    @Override
    public void save(Document document) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(INSERT_DOCUMENT)) {
            pr.setString(1, document.getGeneratedFileName());
            pr.setString(2, document.getOriginalFileName());
            pr.setString(3, document.getMimeType());
            pr.setString(4, document.getFilePath());
            pr.setLong(5, document.getFileSize());
            pr.setString(6, document.getExtension());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean get(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Document document) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    public Document findByGeneratedName(@NonNull String filename) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(SELECT_BY_NEW_NAME)) {
            pr.setString(1, filename);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()) {
                return Document.builder()
                        .id(resultSet.getInt("id"))
                        .generatedFileName(resultSet.getString("generatedFileName"))
                        .originalFileName(resultSet.getString("originalFileName"))
                        .mimeType(resultSet.getString("mimeType"))
                        .filePath(resultSet.getString("filePath"))
                        .extension(resultSet.getString("extension"))
                        .fileSize(resultSet.getLong("fileSize"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DocumentDAO getInstance() {
        if (instance == null) {
            synchronized (DocumentDAO.class) {
                if (instance == null) {
                    instance = new DocumentDAO();
                }
            }
        }
        return instance;
    }
}
