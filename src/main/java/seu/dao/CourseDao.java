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

    public void insertCourse(final Course course){
        final String sql = "INSERT INTO Course(courseId,courseName,credit,period,teacherId) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {course.getCourseId(),course.getCourseName(),course.getCredit(),course.getPeriod(),course.getTeacherId()};
        jdbcTemplate.update(sql,params);
    }
//杨楠删掉了冲突的部分
/*<<<<<<< HEAD
=======
    public void insertCourse(final int courseID,final String courseName, final int credit,final int period,final int teacherID) {
        final String sql = "INSERT INTO Course(courseId,courseName,credit,period,teacherId) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {courseID,courseName,credit,period,teacherID};
        jdbcTemplate.update(sql, params);
    }

>>>>>>> bcafc8b480059aaabd79e34ec2a38cff9f62b0c1*/
    public void deleteCourseByID(final int courseId){
        final String sql = "DELETE FROM Course WHERE courseId = ?";
        Object[] params = new Object[] {courseId};
        jdbcTemplate.update(sql,params);
    }

    public void deleteCourseByName(final String name){
        final String sql = "DELETE FROM Course WHERE courseName = ?";
        Object[] params = new Object[] {name};
        jdbcTemplate.update(sql,params);
    }

    public void updateCourseByID(final Course course){
        final String sql = "UPDATE Course SET courseName = ? ,credit = ?,period = ?,teacherId = ? WHERE courseId = ?";
        Object[] params = new Object[] {course.getCourseName(),course.getCredit(),course.getPeriod(),course.getTeacherId()};
        jdbcTemplate.update(sql,params);
    }

/*<<<<<<< HEAD
    public List<Course> queryCourseByID(final int courseID){
        final String sql = "SELECT * FROM Course WHERE courseId = ?";
        Object[] params = new Object[] {courseID};
        return (List<Course>)jdbcTemplate.query(sql,params,new RowMapper(){
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Course(rs.getInt("courseId"),rs.getString("courseName"),
                        rs.getInt("credit"),rs.getInt("period"),rs.getInt("teacherId"));
            }
        });

    }


=======
    public String queryCourseNameByID(final int courseID){
        final String sql = "SELECT courseName FROM Course WHERE courseId = ?";
        Object[] params = new Object[] {courseID};
        return jdbcTemplate.queryForObject(sql,params,String.class);
    }

   public List<Course> queryCourseByID(final int courseID){
       final String sql = "SELECT *  FROM Course WHERE courseId = ?";
       Object[] params = new Object[] {courseID};
       List course = jdbcTemplate.query(sql,params,new CourseMapper());
       return course;
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
>>>>>>> bcafc8b480059aaabd79e34ec2a38cff9f62b0c1*/
}

