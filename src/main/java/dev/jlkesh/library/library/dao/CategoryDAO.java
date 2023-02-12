package dev.jlkesh.library.library.dao;

import dev.jlkesh.library.library.domains.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDAO extends DAO<Category, Integer> {

    @Override
    protected Category get(Integer integer) {
        DataSource dataSource = new DataSourceWrapper();
        return null;
    }

    public static final String FIND_ALL_QUERY = "select * from library1.category";
    public static final String UPDATE_CATEGORY_QUERY = """
            update library1.category set name = ? where id = ?;""";
    public static final String TOTAL_COUNT = "select count(0) from library1.category;";
    public static final String INSERT_CATEGORY_QUERY = """
            insert into library1.category (name) values (?) returning id;""";
    private static CategoryDAO instance;

    public static CategoryDAO getInstance() {
        if (instance == null) {
            synchronized (CategoryDAO.class) {
                if (instance == null) {
                    instance = new CategoryDAO();
                }
            }
        }
        return instance;
    }

    public Category save(Category category) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(INSERT_CATEGORY_QUERY)) {
            pS.setString(1, category.getName());
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                category.setId(rs.getInt(" id"));
                return category;
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Category> findAll() {
        List<Category> students = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(FIND_ALL_QUERY)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                students.add(Category.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Category findById(long categoryId) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("select * from library1.category t where t.id = ?;")) {
            pr.setLong(1, categoryId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) return Category.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("delete from library1.category t where t.id = ?;")) {
            pr.setInt(1, id);
            pr.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(@NonNull Category category) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(UPDATE_CATEGORY_QUERY)) {
            pr.setString(1, category.getName());
            pr.setInt(2, category.getId());
            pr.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected boolean delete(Integer integer) {
        return false;
    }

    public long totalCount() {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(TOTAL_COUNT)) {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
