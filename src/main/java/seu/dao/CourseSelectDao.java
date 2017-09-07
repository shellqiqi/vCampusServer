package seu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import seu.domain.CourseSelect;

@Repository
public class CourseSelectDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCourseSelect(final CourseSelect courseSelect){
        final String sql = "INSERT INTO CourseSelect(StudentID, CourseID, Grade) VALUES(?,?)";
        Object[] params = new Object[]{CourseSelect.getStudentId(),CourseSelect.getCourseId(),CourseSelect.getGrade()};
        return jdbcTemplate.update(sql,params);
    }
    public int insertCourseSelect(final int studentID, final int courseID,final int grade){
        final String sql = "INSERT INTO CourseSelect(StudentID, CourseID, Grade) VALUES(?,?)";
        Object[] params = new Object[]{studentID,courseID,grade};
        return jdbcTemplate.update(sql,params);
    }
    public int deleteCourseSelectByCourseSelectID(final int courseSelectID){
        final String sql = "DELETE FROM CourseSelect Where CourseSelectID = ?";
        Object[] params = new Object[]{courseSelectID};
        return jdbcTemplate.update(sql,params);
    }

    public int updateStudentIDByCourseSelectID(final int courseSelectID,final int studentID){
        final String sql = "UPDATE CourseSelect SET StudentID = ? WHERE CourseSelectID = ?";
        Object[] params = new Object[]{studentID,courseSelectID};
        return jdbcTemplate.update(sql,params);
    }
    public int updateTeacherIDByCourseSelectID(final int courseSelectID,final int teacherID){
        final String sql = "UPDATE CourseSelect SET TeacherID = ? WHERE CourseSelectID = ?";
        Object[] params = new Object[]{teacherID,courseSelectID};
        return jdbcTemplate.update(sql,params);
    }
    public int updateGradeByCourseSelectID(final int courseSelectID,final int grade){
        final String sql = "UPDATE CourseSelect SET Grade = ? WHERE CourseSelectID = ?";
        Object[] params = new Object[]{grade,courseSelectID};
        return jdbcTemplate.update(sql,params);
    }
    public int queryStudentIDByCourseSelectID(final int courseSelectID){
        final String sql = "SELECT StudentID FROM CourseSelect WHERE CourseSelectID = ?";
        Object[] params = new Object[]{courseSelectID};
        jdbcTemplate.queryForObject(sql,params);
    }
    public int queryGradeByCourseSelectID(final int courseSelectID){
        final String sql = "SELECT Grade FROM CourseSelect WHERE CourseSelectID = ?";
        Object[] params = new Object[]{courseSelectID};
        jdbcTemplate.queryForObject(sql,params);
    }
    public int queryTeacherIDByCourseSelectID(final int courseSelectID){
        final String sql = "SELECT TeacherID FROM CourseSelect WHERE CourseSelectID = ?";
        Object[] params = new Object[]{courseSelectID};
        jdbcTemplate.queryForObject(sql,params);
    }
}
