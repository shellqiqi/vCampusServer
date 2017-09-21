package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.StudentDao;
import seu.domain.Student;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    /**
     *设置学生DAO
     * @param studentDao 学生DAO
     */
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     *学生登陆
     * @param studentId 登陆学生的ID
     * @param passwd 密码
     * @return 登陆成功返回1，不成功返回0，异常返回-1
     */
    public int login(int studentId, String passwd) {
        try {
            Student student = studentDao.queryStudentByStudentID(studentId);
            if (student.getPassword().equals(passwd)) return 1;
            else return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     *学生登出
     * @return 返回“Logout"
     */
    public String logout() {
        return "Logout";
    }

    /**
     *插入新学生
     * @param student 输入学生对象
     * @return 插入成功返回1，不成功返回0，异常返回-1
     */
    public int insertStudent(Student student) {
        try {
            return studentDao.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *删除新学生
     * @param studentId 学生ID
     * @return 删除成功返回1，不成功返回0，异常返回-1
     */
    public int deleteStudent(int studentId) {
        try {
            return studentDao.deleteStudentByStudentID(studentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     *更新学生密码
     * @param studentID 学生ID
     * @param passwd 学生的新密码
     * @return 更新密码成功返回1，不成功返回0，异常返回-1
     */
    public int updateStudentPassword(int studentID, String passwd) {
        try {
            return studentDao.updatePasswordByStudentID(studentID, passwd);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     *通过学生对象更新学生信息
     * @param student 学生对象
     * @return 更新学生信息成功返回1，不成功返回0，异常返回-1
     */
    public int updateStudent(Student student) {
        try {
            return studentDao.updateStudentByStudentID(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *通过学生ID查找学生
     * @param id 目标学生ID
     * @return  查询成功返回学生对象，否则返回null
     */
    public Student queryStudentByStudentId(int id) {
        try {
            return studentDao.queryStudentByStudentID(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过班级ID查找学生
     * @param classID 班级ID
     * @return 该班级下所有学生的List
     */
    public List<Student> queryStudentByClassId(int classID) {
        try {
            return studentDao.queryStudentByClassID(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过宿舍ID找学生
     * @param dormitoryID 宿舍的ID
     * @return 该宿舍下所有学生的list
     */
    public List<Student> queryStudentByDormitoryId(int dormitoryID) {
        try {
            return studentDao.queryStudentByDormitoryId(dormitoryID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过课程找学生
     * @param courseID 课程ID
     * @return 选择该课程的所有学生的List
     */
    public List<Student> queryStudentByCourseId(int courseID) {
        try {
            return studentDao.queryStudentByCourseId(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过借书找学生
     * @param bookID 图书的ID
     * @return 借走该图书的学生的对象
     */
    public Student queryStudentByBookId(int bookID) {
        try {
            return studentDao.queryStudentByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *查找所有学生
     * @return 返回所有学生的List
     */
    public List<Student> queryAllStudent() {
        try {
            return studentDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
