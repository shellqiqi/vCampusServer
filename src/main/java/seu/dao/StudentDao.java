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
    public void addStudent(final Student student) {
        final String sql = "INSERT INTO Student(StudentID,StudentName,ClassID,DormitoryID,Balance,Password) VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] {student.getStudentId(),student.getStudentName(),student.getClassId(),student.getDormitoryId(),student.getBalance(),student.getPassword()};
        jdbcTemplate.update(sql, params);
    }

    public void addStudentr(final int StudentID,final String StudentName,final int ClassID,final int DormitoryID,final int Balance,final int Password) {
        final String sql =  "INSERT INTO Student( StudentID,StudentName, ClassID,DormitoryID,Balance,Password) VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] { StudentID, StudentName,ClassID,DormitoryID,Balance,Password};
        jdbcTemplate.update(sql, params);
    }

    //删除学生成员
    public void deleteStudentByID(final int id) {
        final String sql = "DELETE FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        jdbcTemplate.update(sql, params);
    }



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

    public void updateDormitoryIDByID(final int id, final int studentId) {
        final String sql = "UPDATE  Student SET DormitoryID = ? WHERE StudentID = ?";
        Object[] params = new Object[] {studentId, id};
        jdbcTemplate.update(sql, params);
    }

    public void updateBalanceByID(final int id, final int balance) {
        final String sql = "UPDATE Student SET Balance = ? WHERE StudentID = ?";
        Object[] params = new Object[] {balance, id};
        jdbcTemplate.update(sql, params);
    }

    public void updatePasswordByID(final int id, final int Password) {
        final String sql = "UPDATE Student SET Password = ? WHERE StudentID = ?";
        Object[] params = new Object[] {Password, id};
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

    public String queryPasswordByID(final int id) {
        final String sql = "SELECT Password FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public List<Student> queryAll()
    {
        final String sql = "SELECT * FROM Student ";
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




    //关联查询
    public int queryStudentIDByClassID(final int id)
    {
        final String sql = "SELECT StudentID FROM Student LEFT JOIN Class ON Student.ClassID=Class.ClassID   WHERE ClassID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    public int queryStudentIDByDormitoryID(final int id)
    {
        final String sql = "SELECT StudentID FROM Student LEFT JOIN Dormitory ON Student.DormitoryID=Dormitory.DormitoryID   WHERE DormitoryID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    @SuppressWarnings("unchecked")
    public List<Library> queryLibaryByStudentID(final int id)
    {
        final String sql = "SELECT * FROM Library  LEFT JOIN Student ON Library.StudentID=Student.StudentID WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return (List<Library>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Library(rs.getInt("BookID"), rs.getString("BookName"),rs.getInt("StudentID"),rs.getDate("Period"),rs.getDate("ReturnDate"));
            }
        });
        }

    @SuppressWarnings("unchecked")
    public List<CourseSelect> queryCourseSelectByStudentID(final int id)
    {
        final String sql = "SELECT * FROM CourseSelect  LEFT JOIN Student ON CourseSelect.StudentID=Student.StudentID WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return (List<CourseSelect>)jdbcTemplate.query(sql, params, new RowMapper() {
            public CourseSelect mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new CourseSelect(rs.getInt("CourseSelectID"), rs.getInt("StudentID"),rs.getInt("CourseID"),rs.getInt("Grade"));
            }
        });
    }




    @SuppressWarnings("unchecked")
    public List<Student> queryStudentByID(final int id) {
        final String sql = "SELECT * FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        return (List<Student>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt("StudentID"), rs.getString("StudentName"),rs.getInt("ClassID"),rs.getInt("DormitoryID"),rs.getInt("Balance"),rs.getString("Password"));
            }
        });
    }
}






