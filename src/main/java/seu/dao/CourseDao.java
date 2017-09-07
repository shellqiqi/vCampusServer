package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCourse(final Course course){
        final String sql = "INSERT INTO Course(courseId, courseName, credit, period, teacherId) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {course.getCourseId(), course.getCourseName(), course.getCredit(), course.getPeriod(), course.getTeacherId()};
        return jdbcTemplate.update(sql, params);
    }

    public int insertCourse(final int courseId, final String courseName, final int credit, final int period, final int teacherId) {
        final String sql = "INSERT INTO Course(CourseId,CourseName,Credit,Period,TeacherId) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {courseId,courseName,credit,period,teacherId};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteCourseByID(final int courseId){
        final String sql = "DELETE FROM Course WHERE CourseId = ?";
        Object[] params = new Object[] {courseId};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteCourseByName(final String name){
        final String sql = "DELETE FROM Course WHERE CourseName = ?";
        Object[] params = new Object[] {name};
        return jdbcTemplate.update(sql, params);
    }

    public int updateCourseByID(final Course course, final int id){
        final String sql = "UPDATE Course SET CourseName = ? ,Credit = ?,Period = ?,TeacherId = ? WHERE CourseId = ?";
        Object[] params = new Object[] {course. getCourseName(), course.getCredit(), course.getPeriod(), course.getTeacherId(), id};
        return jdbcTemplate.update(sql, params);
    }

    public String queryCourseNameByID(final int courseID){
        final String sql = "SELECT CourseName FROM Course WHERE CourseId = ?";
        Object[] params = new Object[] {courseID};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public List<Course> queryCourseByStudentId(final int id){
        final String sql = "SELECT * FROM Course INNER JOIN CourseSelect ON CourseSelect.CourseId=Course.CourseId WHERE CourseSelect.StudentId=?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.query(sql, params, new CourseMapper());
    }

    public List<Course> queryCourseByID(final int id){
       final String sql = "SELECT *  FROM Course WHERE CourseId = ?";
       Object[] params = new Object[] {id};
       List course = jdbcTemplate.query(sql, params, new CourseMapper());
       return course;
    }

    public List<Course> queryAll(){
        final String sql = "SELECT * FROM Course";
        return jdbcTemplate.query(sql, new CourseMapper());
    }

    protected class CourseMapper implements RowMapper{
       public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
           Course course = new Course();
           course.setCourseId(rs.getInt("courseId"));
           course.setCourseName(rs.getString("courseName"));
           course.setCredit(rs.getInt("credit"));
           course.setPeriod(rs.getInt("period"));
           course.setTeacherId(rs.getInt("teacherId"));
           return course;
       }

    }
}

