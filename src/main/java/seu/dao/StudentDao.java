package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import seu.domain.Student;
import seu.domain.Dormitory;
@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //学生不拥有增加或删除表中某一行的权限
    //学生拥有修改数据和查询数据的权限
    // 有一个问题 student表中的dormitoryID是外键，无法在Student表中修改，只能在Dormitory表中修改


   //修改数据
    public void updateStudentNameByID(final int id,  final String name) {
        final String sql = "UPDATE Student SET StudentName = ? WHERE StudentID = ?";
        Object[] params = new Object[] {name, id};
        jdbcTemplate.update(sql, params);
    }

    public void updateClassIDByID(final int id, final int classId) {
        final String sql = "UPDATE Student SET ClassID = ? WHERE StudentID = ?";
        Object[] params = new Object[] {classId, id};
        jdbcTemplate.update(sql, params);
    }

  /* public void updateDormitoryIDByID(final int id, final int studentId) {
        final String sql = "UPDATE  Student SET DormitoryID = ? WHERE StudentID = ?";
        Object[] params = new Object[] {studentId, id};
        jdbcTemplate.update(sql, params);
    }*/

    public void updateBalanceByID(final int id, final int balance) {
        final String sql = "UPDATE Student SET Balance = ? WHERE StudentID = ?";
        Object[] params = new Object[] {balance, id};
        jdbcTemplate.update(sql, params);
    }






    //查询信息
    public String queryStudentNameByID(final int id) {
        final String sql = "SELECT StudentName FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public int queryClassIDByID(final int id) {
        final String sql = "SELECT ClassID FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    public int queryDormitoryIDByID(final int id) {
        final String sql = "SELECT DormitoryID FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    public int queryBalanceByID(final int id) {
        final String sql = "SELECT Balance FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    //查询不在Student表中的数据
   /* public void queryCourseNameByID(final int id) {
        final String sql = "SELECT CourseID FROM CourseSelect LEFT JOIN Student ON CourseSelect.StudentID=Student.StudentID   WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        int a;
        a= jdbcTemplate.queryForObject(sql, params, int.class);

        final String sq = "SELECT CourseName FROM CourseSelect LEFT JOIN Course ON CourseSelect.CourseID=Course.CourseID   WHERE CourseID = ?";
        Object[] param = new Object[] {a};


    }*/

    @SuppressWarnings("unchecked")
    public List<Student> queryUserByID(final int id) {
        final String sql = "SELECT * FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return (List<Student>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt("StudentID"), rs.getString("StudentName"),rs.getInt("ClassID"),rs.getInt("DormitoryID"),rs.getInt("Balance"));
            }
        });
    }
}






