package dev.jlkesh.library.library.dao;

import dev.jlkesh.library.library.domains.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDAO extends DAO<Book, Integer> {
    public static final String INSERT_QUERY = """
            insert into library1.books (
                        title,
                        author,
                        category,
                        page,
                        publisher,
                        published_at,
                        cover_id,
                        document_id
            ) values ();""";
    private static BookDAO instance;


    @Override
    protected void save(Book book) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(INSERT_QUERY)) {
            pr.setString(1, book.getTitle());
            pr.setString(2, book.getAuthor());
            pr.setString(3, book.getCategory());
            pr.setInt(4, book.getPages());
            pr.setString(5, book.getPublisher());
            pr.setString(6, book.getPublishedAt().toString());
            pr.setInt(7, book.getCoverId());
            pr.setInt(8, book.getDocumentId());
            pr.execute();
        } catch (SQLException e) {}
    }

    @Override
    protected boolean get(Integer integer) {
        return false;
    }

    @Override
    protected boolean update(Book book) {
        return false;
    }

    @Override
    protected boolean delete(Integer integer) {
        return false;
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            synchronized (BookDAO.class) {
                if (instance == null) {
                    instance = new BookDAO();
                }
            }
        }
        return instance;
    }
}
