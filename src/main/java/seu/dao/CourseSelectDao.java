package seu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.CourseSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CourseSelectDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCourseSelect(final CourseSelect courseSelect){
        final String sql = "INSERT INTO CourseSelect(StudentID, CourseID, Grade) VALUES(?,?,?)";
        Object[] params = new Object[]{courseSelect.getStudentId(),courseSelect.getCourseId(),courseSelect.getGrade()};
        return jdbcTemplate.update(sql,params);
    }
    public int insertCourseSelect(final int studentID, final int courseID ){
        final String sql = "INSERT INTO CourseSelect(StudentID, CourseID) VALUES(?,?)";
        Object[] params = new Object[]{studentID,courseID};
        return jdbcTemplate.update(sql,params);
    }
    public int deleteCourseSelectByCourseIDAndStudentID(final int studentID ,final int courseID){
        final String sql = "DELETE FROM CourseSelect Where (CourseID = ? AND StudentID = ?)";
        Object[] params = new Object[]{courseID,studentID};
        return jdbcTemplate.update(sql,params);
    }

    public int updateGradeByCourseIDAndStudentID(final int studentID,final int courseID,final int grade){
        final String sql = "UPDATE CourseSelect SET Grade = ? WHERE CourseID = ? And StudentID=?";
        Object[] params = new Object[]{grade,courseID,studentID};
        return jdbcTemplate.update(sql,params);
    }

    public int queryGradeByCourseIDAndStudentID( final int studentID,final int courseID){
        final String sql = "SELECT Grade FROM CourseSelect WHERE CourseID = ? And StudentID =?";
        Object[] params = new Object[]{courseID,studentID};
        return jdbcTemplate.queryForObject(sql,params,int.class);
    }

    public List<CourseSelect> queryAll() {
        final String sql = "SELECT * FROM CourseSelect";
        return jdbcTemplate.query(sql, new CourseSelectMapper());
    }

    private static final class CourseSelectMapper implements RowMapper<CourseSelect> {
        @Override
        public CourseSelect mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CourseSelect(
                    rs.getInt("CourseSelectID"),
                    rs.getInt("StudentID"),
                    rs.getInt("CourseID"),
                    rs.getInt("Grade")
            );
        }
    }

}
