package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

@Repository
public class LibraryDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //管理员增加图书
    public int insertBook(final Library book) {
        final String sql = "INSERT INTO Library(BookId,BookName,studentId,startDate) VALUES(?,?,?,?)";
        Object[] params = new Object[]{book.getBookId(),book.getBookName(),book.getStudentId(),book.getStartDate() };
        return jdbcTemplate.update(sql, params);
    }
    //管理员增加图书
    public int insertBook(final int bookId,final String bookName ){
        final String sql = "INSERT INTO Library(BookId,BookName,startDate) VALUES(?,?,?)";
        Object[] params = new Object[]{bookId,bookName, null };
        return jdbcTemplate.update(sql, params);
    }

    public int deleteBookByBookId(final int id) {
        final String sql = "DELETE FROM Library WHERE BookId = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.update(sql, params);
    }
    //学生借书
    public int updateBookByBookId(final int bookId, final int studentId,final Date date){
        final String sql = "UPDATE Library SET StudentID = ? , StartDate = ? WHERE BookId = ?";
        Object[] params = new Object[]{studentId,date,bookId};
        return jdbcTemplate.update(sql, params);
    }
    //学生还书
    public int updateBookByBookId(final int bookId){
        final String sql = "UPDATE Library SET StudentID = ? , StartDate = ? WHERE BookId = ?";
        Object[] params = new Object[]{null,null,bookId};
        return jdbcTemplate.update(sql, params);
    }

    public Library queryBookByBookId(final int id) {
        final String sql = "SELECT * FROM Library WHERE BookId = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject(sql, params, new LibraryMapper());
    }

    public List<Library> queryBooksByStudentId(final int studentId){
        final String sql = "SELECT * FROM Library WHERE StudentID = ?";
        Object[] params = new Object[]{studentId};
        return jdbcTemplate.query(sql, params, new LibraryMapper());
    }
    public List<Library> queryBooksByBookName(final String bookName){
        final String sql = "SELECT * FROM Library WHERE BookName = ?";
        Object[] params = new Object[]{bookName};
        return jdbcTemplate.query(sql, params, new LibraryMapper());
    }
    public List<Library> queryAllBorrowedBook(){
        final String sql = "SELECT * FROM Library WHERE not StudentID = ?";
        Object[] params = new Object[]{ 0 };
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
                    rs.getDate("startDate")
            );
        }
    }
}
