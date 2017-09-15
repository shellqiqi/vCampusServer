package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import seu.domain.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertTeacher(final Teacher teacher) {
        final String sql = "INSERT INTO Teacher(TeacherID,TeacherName,PhoneNumber,Password) VALUES(?,?,?,?)";
        Object[] params = new Object[] {teacher.getTeacherId(), teacher.getTeacherName(),teacher.getTeacherPhoneNumber(),teacher.getPassword()};
        return jdbcTemplate.update(sql, params);
    }

    public int insertTeacher(final int TeacherID,final String TeacherName,final int TeacherPhoneNumber,final String Password) {
        final String sql =  "INSERT INTO Teacher( TeacherID,TeacherName, PhoneNumber,Password) VALUES(?,?,?,?)";
        Object[] params = new Object[] { TeacherID, TeacherName,TeacherPhoneNumber,Password};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteTeacherByTeacherID(final int id) {
        final String sql = "DELETE FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateTeacherNameByTeacherID(final int id,  final String name) {
        final String sql = "UPDATE Teacher SET TeacherName = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {name, id};
        return jdbcTemplate.update(sql, params);
    }

    public int updatePhoneNumberByTeacherID(final int id,  final int number) {
        final String sql = "UPDATE Teacher SET PhoneNumber = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {number, id};
        return jdbcTemplate.update(sql, params);
    }

    public int updatePasswordByTeacherID(final int id,  final String Password) {
        final String sql = "UPDATE Teacher SET Password = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {Password, id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateTeacher(final Teacher teacher){
        final String sql = "UPDATE Teacher SET TeacherName = ?,PhoneNumber=?,Password=? WHERE TeacherID = ?";
        Object[] params = new Object[] {teacher.getTeacherName(),teacher.getTeacherPhoneNumber(),teacher.getPassword(),teacher.getTeacherId()};
        return jdbcTemplate.update(sql, params);
    }

    public Teacher queryTeacherByTeacherID(final int id) {
        final String sql = "SELECT * FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, new TeacherMapper());
    }

    public Teacher queryTeacherByClassID(final int classId){
        final String sql = "SELECT * FROM Teacher INNER JOIN Class ON Class.TeacherId = Teacher.TeacherId " +
                "WHERE Class.ClassID = ?";
        Object[] params = new Object[] {classId};
        return jdbcTemplate.queryForObject(sql, params, new TeacherMapper());
    }

    public Teacher queryTeacherByCourseID(final int courseId){
        final String sql = "SELECT * FROM Teacher INNER JOIN Course ON Course.TeacherId = Teacher.TeacherId " +
                "WHERE Course.CourseID = ?";
        Object[] params = new Object[] {courseId};
        return jdbcTemplate.queryForObject(sql, params, new TeacherMapper());
    }

    public List<Teacher> queryAll()
    {
        final String sql = "SELECT * FROM Teacher";
        return jdbcTemplate.query(sql, new TeacherMapper());
    }

    private static final class TeacherMapper implements RowMapper<Teacher> {
        @Override
        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Teacher(
                    rs.getInt("TeacherID"),
                    rs.getString("TeacherName"),
                    rs.getInt("PhoneNumber"),
                    rs.getString("Password")
            );
        }
    }

}
