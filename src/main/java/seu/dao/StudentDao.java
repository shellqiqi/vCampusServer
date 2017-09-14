package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import seu.domain.CourseSelect;
import seu.domain.Library;
import seu.domain.Student;
import seu.domain.Dormitory;
@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加学生成员
    public int insertStudent(final Student student) {
        final String sql = "INSERT INTO Student(StudentID,StudentName,ClassID,DormitoryID,Balance,Password) VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] {student.getStudentId(),student.getStudentName(),student.getClassId(),student.getDormitoryId(),student.getBalance(),student.getPassword()};
        return jdbcTemplate.update(sql, params);
    }

    public int insertStudent(final int StudentID,final String StudentName,final int ClassID,final int DormitoryID,final int Balance,final String Password) {
        final String sql =  "INSERT INTO Student( StudentID,StudentName,ClassID,DormitoryID,Balance,Password) VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] { StudentID, StudentName,ClassID,DormitoryID,Balance,Password};
        return jdbcTemplate.update(sql, params);
    }

    //删除学生成员
    public int deleteStudentByStudentID(final int studentId) {
        final String sql = "DELETE FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {studentId};
        return jdbcTemplate.update(sql, params);
    }

    public int updateStudentNameByStudentID(final int studentId,  final String name) {
        final String sql = "UPDATE Student SET StudentName = ? WHERE StudentID = ?";
        Object[] params = new Object[] {name, studentId};
        return jdbcTemplate.update(sql, params);
    }

    public int updateClassIDByStudentID(final int studentId, final int classId) {
        final String sql = "UPDATE Student SET ClassID = ? WHERE StudentID = ?";
        Object[] params = new Object[] {classId, studentId};
        return jdbcTemplate.update(sql, params);
    }

    public int updateDormitoryIDByStudentID(final int studentId, final int dormitoryId) {
        final String sql = "UPDATE  Student SET DormitoryID = ? WHERE StudentID = ?";
        Object[] params = new Object[] {dormitoryId,studentId};
        return jdbcTemplate.update(sql, params);
    }

    public int updateBalanceByStudentID(final int studentId, final int balance) {
        final String sql = "UPDATE Student SET Balance = ? WHERE StudentID = ?";
        Object[] params = new Object[] {balance, studentId};
        return jdbcTemplate.update(sql, params);
    }

    public int updatePasswordByStudentID(final int studentId, final String Password) {
        final String sql = "UPDATE Student SET Password = ? WHERE StudentID = ?";
        Object[] params = new Object[] {Password, studentId};
        return jdbcTemplate.update(sql, params);
    }


    public Student queryStudentByStudentID(final int StudentId) {
        final String sql = "SELECT * FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {StudentId};
        return jdbcTemplate.queryForObject(sql, params, new StudentMapper());
    }

    public List<Student> queryStudentByClassID(final int classId)
    {
        final String sql = "SELECT * FROM Student WHERE Student.ClassID = ?";
        Object[] params = new Object[] {classId};
        return jdbcTemplate.query(sql, params, new StudentMapper());
    }

    public List<Student> queryStudentByCourseId(final int courseId){
        final String sql = "SELECT * FROM Student INNER JOIN CourseSelect ON Student.StudentID=CourseSelect.StudentID "
                + "WHERE CourseSelect.CourseId = ?";
        Object[] params = new Object[] {courseId};
        return jdbcTemplate.query(sql, params, new StudentMapper());
    }

    public Student queryStudentByBookId(final int bookId){
        final String sql = "SELECT * FROM Student INNER JOIN Library ON Library.StudentId = Student.StudentId "
               + "WHERE Library.BookId = ?";
        Object[] params = new Object[] {bookId};
        return jdbcTemplate.queryForObject(sql, params, new StudentMapper());
    }

    public List<Student> queryStudentByDormitoryId(final int dormitoryId){
        final String sql = "SELECT * FROM Student WHERE Student.DormitoryId = ?";
        Object[] params = new Object[] {dormitoryId};
        return jdbcTemplate.query(sql, params, new StudentMapper());
    }

    public List<Student> queryAll()
    {
        final String sql = "SELECT * FROM Student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }

    private static final class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(
                    rs.getInt("StudentID"),
                    rs.getString("StudentName"),
                    rs.getInt("ClassID"),
                    rs.getInt("DormitoryID"),
                    rs.getInt("Balance"),
                    rs.getString("Password")
            );
        }
    }

}






