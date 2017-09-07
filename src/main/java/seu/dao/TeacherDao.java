package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Course;
import seu.domain.Student;
import seu.domain.Class;
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

    //添加教师成员
    //形参为对象
    public void addTeacher(final Teacher teacher) {
        final String sql = "INSERT INTO Teacher(TeacherID,TeacherName,TeacherPhoneNumber,Password) VALUES(?,?,?,?)";
        Object[] params = new Object[] {teacher.getTeacherId(), teacher.getTeacherName(),teacher.getTeacherPhoneNumber(),teacher.getPassword()};
        jdbcTemplate.update(sql, params);
    }

    //形参为具体数据
    public void addTeacher(final int TeacherID,final String TeacherName,final int TeacherPhoneNumber,final String Password) {
        final String sql =  "INSERT INTO Teacher( TeacherID,TeacherName, TeacherPhoneNumber,Password) VALUES(?,?,?,?)";
        Object[] params = new Object[] { TeacherID, TeacherName,TeacherPhoneNumber,Password};
        jdbcTemplate.update(sql, params);
    }



    //删除教师成员
    public void deleteTeacherByID(final int id) {
        final String sql = "DELETE FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        jdbcTemplate.update(sql, params);
    }

    public void deleteTeacherByName(final String name) {
        final String sql = "DELETE FROM Teacher WHERE TeacherName = ?";
        Object[] params = new Object[] {name};
        jdbcTemplate.update(sql, params);
    }

    public void deleteTeacherByTeacherPhoneNumber(final int number) {
        final String sql = "DELETE FROM Teacher WHERE TeacherPhoneNumber = ?";
        Object[] params = new Object[] {number};
        jdbcTemplate.update(sql, params);
    }




    //修改
    public void updateTeacherNameByID(final int id,  final String name) {
        final String sql = "UPDATE Teacher SET TeacherName = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {name, id};
        jdbcTemplate.update(sql, params);
    }

    public void updateTeacherPhoneNumberByID(final int id,  final int number) {
        final String sql = "UPDATE Teacher SET TeacherPhoneNumber = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {number, id};
        jdbcTemplate.update(sql, params);
    }

    public void updatePasswordByID(final int id,  final String Password) {
        final String sql = "UPDATE Teacher SET Password = ? WHERE TeacherID = ?";
        Object[] params = new Object[] {Password, id};
        jdbcTemplate.update(sql, params);
    }

    //查询
    public String queryTeacherNameByID(final int id) {
        final String sql = "SELECT TeacherName FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public int queryTeacherPhoneNumberByID(final int id) {
        final String sql = "SELECT TeacherPhoneNumber FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    public String queryPasswordberByID(final int id) {
        final String sql = "SELECT Password FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
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
                    rs.getString("TeacherPhoneNumber"),
                    rs.getString("Password")
            );
        }
    }












    //查询Class表和Course表的内容
    @SuppressWarnings("unchecked")
    public List<Class> queryClassByTeacherID(final int id)
    {
        final String sql = "SELECT * FROM Class  LEFT JOIN Teacher ON Teacher.TeacherID=Class.TeacherID WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return (List<Class>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Class(rs.getInt("ClassID"), rs.getString("ClassName"),rs.getString("Major"),rs.getInt("ClassSize"),rs.getInt("TeacherID"));
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<Course> queryCourseByTeacherID(final int id)
    {
        final String sql = "SELECT * FROM Course  LEFT JOIN Teacher ON Teacher.TeacherID=Course.TeacherID WHERE TeacherID = ?";
        Object[] params = new Object[] {id};
        return (List<Course>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Course(rs.getInt("CourseID"), rs.getString("CourseName"),rs.getInt("Credit"),rs.getInt("Period"),rs.getInt("TeacherID"));
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<Teacher> queryTeacherByID(final int id) {
        final String sql = "SELECT * FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[]{id};
        return (List<Teacher>) jdbcTemplate.query(sql, params, new RowMapper() {
            public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Teacher(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("TeacherPhoneNumber"),rs.getString("Password"));
            }
        });


    }

}
