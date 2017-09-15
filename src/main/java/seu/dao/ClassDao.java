package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClassDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertClass(final Class clas) {
        final String sql = "INSERT INTO Class(ClassID,ClassName,Major,ClassSize,TeacherID) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {clas.getClassId(), clas.getClassName(), clas.getMajor(), clas.getClassSize(), clas.getTeacherId()};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteClassById(final int id) {
        final String sql = "DELETE FROM Class WHERE ClassID=?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateClassById(final Class clas) {
        final String sql = "UPDATE Class SET ClassName=?,Major=?,ClassSize=?,TeacherID=? WHERE ClassID=?";
        Object[] params = new Object[] { clas.getClassName(), clas.getMajor(), clas.getClassSize(), clas.getTeacherId(), clas.getClassId()};
        return jdbcTemplate.update(sql, params);
    }

    public List<Class> queryClassByTeacherId(final int id) {
        final String sql = "SELECT * FROM Class WHERE Class.TeacherId=?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.query(sql, params, new ClassMapper());
    }

    public Class queryClassByStudentId(final int id) {
        final String sql = "SELECT * FROM Class INNER JOIN Student ON Student.ClassId=Class.ClassId WHERE Student.StudentId=?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, new ClassMapper());
    }

    public Class queryClassById(final int id) {
        final String sql = "SELECT * FROM Class WHERE ClassID=?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params ,new ClassMapper());
    }

    public List<Class> queryAll() {
        final String sql = "SELECT * FROM Class";
        return jdbcTemplate.query(sql, new ClassMapper());
    }

    private static final class ClassMapper implements RowMapper<Class> {
        @Override
        public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Class(
                    rs.getInt("ClassID"),
                    rs.getString("ClassName"),
                    rs.getString("Major"),
                    rs.getInt("ClassSize"),
                    rs.getInt("TeacherID")
            );
        }
    }
}
