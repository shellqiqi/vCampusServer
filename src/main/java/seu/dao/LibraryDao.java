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

    public int insertBook(final Library book) {
        final String sql = "INSERT INTO Library(BookName,BookId) VALUES(?,?)";
        Object[] params = new Object[]{book.getBookName(), book.getBookId()};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteBookById(final int id) {
        final String sql = "DELETE FROM Library WHERE BookId = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteBookByName(final String name) {
        final String sql = "DELETE FROM Library WHERE BookName = ?";
        Object[] params = new Object[]{name};
        return jdbcTemplate.update(sql, params);
    }

    public int updateBookById(final int bookId, final int studentId){
        final String sql = "UPDATE Library SET StudentID = ? WHERE BookId = ?";
        Object[] params = new Object[]{studentId,bookId};
        return jdbcTemplate.update(sql, params);
    }

    public int updateBookNameById(final int id, final String name) {
        final String sql = "UPDATE Library SET Name = ? WHERE BookId = ?";
        Object[] params = new Object[]{name, id};
        return jdbcTemplate.update(sql, params);
    }


    @SuppressWarnings("unchecked")
    public Library queryBookById(final int id) {
        final String sql = "SELECT * FROM Library WHERE BookId = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject(sql, params, new LibraryMapper());
    }

    public List<Library> queryBooksByStudentId(final int studentId){
        final String sql = "SELECT * FROM Library WHERE StudentID = ?";
        Object[] params = new Object[]{studentId};
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
