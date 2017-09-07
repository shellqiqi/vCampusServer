package seu.dao;
import seu.domain.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(final Library book)
    {
        final String sql = "INSERT INTO book(name,Id) VALUES(book.getBookName(),book.getBookId())";
        Object[] params = new Object[] {book.getBookName(), book.getBookId()};
        jdbcTemplate.update(sql, params);

    }

    public void deleteLibraryById(final int id)
    {
        final String sql = "DELETE FROM Library WHERE Id = ?";
        Object[] params = new Object[] {id};
        jdbcTemplate.update(sql, params);
    }

    public void deleteLibraryByName(final String name)
    {
        final String sql = "DELETE FROM Library WHERE Name = ?";
        Object[] params = new Object[] {name};
        jdbcTemplate.update(sql, params);
    }

    public void updateBookNameById(final int id, final String name)
    {
        final String sql = "UPDATE Book SET Name = ? WHERE Id = ?";
        Object[] params =new Object[] {name, id};
        jdbcTemplate.update(sql, params);
    }


    @SuppressWarnings("unchecked")
    public List<Library> queryStudentBookById(final int id)
    {
        final String sql = "SELECT The Book Condition Of Student Whoes Id = ?";
        Object[] params = new Object[] {id};
        Library stu = new Library();
        return (List<Library>)jdbcTemplate.query(sql, params, new RowMapper()
        {
            public Library mapRow(ResultSet rs, int rowNum) throws SQLException{
                return new Library(rs.getInt("studentId"),rs.getInt("bookId"),rs.getString("bookName"), rs.getDate("period"), rs.getDate("returnDate"));
            }
        });
    }



}
