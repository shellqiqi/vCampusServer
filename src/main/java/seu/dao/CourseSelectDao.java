package seu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.CourseSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public int insertCourseSelect(final int studentID, final int courseID,final int grade){
        final String sql = "INSERT INTO CourseSelect(StudentID, CourseID, Grade) VALUES(?,?,?)";
        Object[] params = new Object[]{studentID,courseID,grade};
        return jdbcTemplate.update(sql,params);
    }
    public int deleteCourseSelectByCourseIDAndStudentID(final int courseID ,final int studentID){
        final String sql = "DELETE FROM CourseSelect Where CourseSelectID = ? And StudentID = ?";
        Object[] params = new Object[]{courseID,studentID};
        return jdbcTemplate.update(sql,params);
    }

    @Deprecated
    public int updateStudentIDByCourseID(final int CourseID,final int studentID){
        final String sql = "UPDATE CourseSelect SET StudentID = ? WHERE CourseID = ?";
        Object[] params = new Object[]{studentID,CourseID};
        return jdbcTemplate.update(sql,params);
    }
    @Deprecated
    public int updateTeacherIDByCourseSelectID(final int courseSelectID,final int teacherID){
        final String sql = "UPDATE CourseSelect SET TeacherID = ? WHERE CourseSelectID = ?";
        Object[] params = new Object[]{teacherID,courseSelectID};
        return jdbcTemplate.update(sql,params);
    }

    public int updateGradeByCourseIDAndStudentID(final int courseID,final int studentID,final int grade){
        final String sql = "UPDATE CourseSelect SET Grade = ? WHERE CourseID = ? And StudentID=?";
        Object[] params = new Object[]{grade,courseID,studentID};
        return jdbcTemplate.update(sql,params);
    }

    public List<Integer> queryStudentIDByCourseID(final int courseID){
        final String sql = "SELECT * FROM CourseSelect WHERE CourseSelect.CourseID = ?";

        Object[] params = new Object[]{courseID};
        List<CourseSelect> courseSelects = jdbcTemplate.query(sql,params,new CourseSelectMapper());
        ArrayList<Integer> StudentIDList = new ArrayList<>();
        for (CourseSelect cs:courseSelects){
            StudentIDList.add(cs.getStudentId());
        }
        return StudentIDList;
    }
    public int queryGradeByCourseIDAndStudentID(final int courseID, final int studentID){
        final String sql = "SELECT Grade FROM CourseSelect WHERE CourseSelectID = ? And StudentID =?";
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
