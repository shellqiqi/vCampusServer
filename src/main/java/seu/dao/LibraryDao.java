package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LibraryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(final Library book) {
        final String sql = "INSERT INTO book(name,Id) VALUES(?,?)";
        Object[] params = new Object[]{book.getBookName(), book.getBookId()};
        jdbcTemplate.update(sql, params);
    }

    public void deleteLibraryById(final int id) {
        final String sql = "DELETE FROM Library WHERE Id = ?";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(sql, params);
    }

    public void deleteLibraryByName(final String name) {
        final String sql = "DELETE FROM Library WHERE Name = ?";
        Object[] params = new Object[]{name};
        jdbcTemplate.update(sql, params);
    }

    public void updateBookNameById(final int id, final String name) {
        final String sql = "UPDATE Book SET Name = ? WHERE Id = ?";
        Object[] params = new Object[]{name, id};
        jdbcTemplate.update(sql, params);
    }


    @SuppressWarnings("unchecked")
    public List<Library> queryStudentBookById(final int id) {
        final String sql = "SELECT The Book Condition Of Student WHERE Id = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.query(sql, params, new LibraryMapper());
    }

    public List<Library> queryAll() {
        final String sql = "SELECT * FROM Library";
        return jdbcTemplate.query(sql, new LibraryMapper());
    }

    private static final class LibraryMapper implements RowMapper<Library> {
        @Override
        public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Library(
                    rs.getInt("bookId"),
                    rs.getString("bookName"),
                    rs.getInt("studentId"),
                    rs.getDate("period"),
                    rs.getDate("returnDate")
            );
        }
    }
}
