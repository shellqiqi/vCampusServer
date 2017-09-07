package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import seu.domain.Student;
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
    //对学生成员的添加和修改在Teacher类里进行
    //添加教师成员
    //形参为对象
    public void addTeacher(final Teacher teacher) {
        final String sql = "INSERT INTO Teacher(TeacherID,TeacherName,TeacherPhoneNumber) VALUES(?,?,?)";
        Object[] params = new Object[] {teacher.getTeacherId(), teacher.getTeacherName(),teacher.getTeacherPhoneNumber()};
        jdbcTemplate.update(sql, params);
    }

    //形参为具体数据
    public void addTeacher(final int TeacherID,final String TeacherName,final int TeacherPhoneNumber) {
        final String sql =  "INSERT INTO Teacher( TeacherID,TeacherName, TeacherPhoneNumber) VALUES(?,?,?)";
        Object[] params = new Object[] { TeacherID, TeacherName,TeacherPhoneNumber};
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




    //添加学生成员
    public void addStudent(final Student student) {
        final String sql = "INSERT INTO Student(StudentID,StudentName,ClassID,DormitoryID,Balance) VALUES(?,?,?,?,?)";
        Object[] params = new Object[] {student.getStudentId(),student.getStudentName(),student.getClassId(),student.getDormitoryId(),student.getBalance()};
        jdbcTemplate.update(sql, params);
    }

    public void addStudentr(final int StudentID,final String StudentName,final int ClassID,final int DormitoryID,final int Balance) {
        final String sql =  "INSERT INTO Student( StudentID,StudentName, ClassID,DormitoryID,Balance) VALUES(?,?,?)";
        Object[] params = new Object[] { StudentID, StudentName,ClassID,DormitoryID,Balance};
        jdbcTemplate.update(sql, params);
    }

    //删除学生成员
    public void deleteStudentByID(final int id) {
        final String sql = "DELETE FROM Student WHERE StudentID = ?";
        Object[] params = new Object[] {id};
        jdbcTemplate.update(sql, params);
    }


    //查询全部
    @SuppressWarnings("unchecked")
    public List<Teacher> queryTeacherByID(final int id) {
        final String sql = "SELECT * FROM Teacher WHERE TeacherID = ?";
        Object[] params = new Object[]{id};
        return (List<Teacher>) jdbcTemplate.query(sql, params, new RowMapper() {
            public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Teacher(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("TeacherPhoneNumber"));
            }
        });


    }
}
