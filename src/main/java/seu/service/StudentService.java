package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.StudentDao;
import seu.domain.Student;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

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

    public String logout() {
        return "Logout";
    }

    public int insertStudent(Student student) {
        try {
            return studentDao.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteStudent(int studentId) {
        try {
            return studentDao.deleteStudentByStudentID(studentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int updateStudentPassword(int studentID, String passwd) {
        try {
            return studentDao.updatePasswordByStudentID(studentID, passwd);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int updateStudent(Student student) {
        try {
            return studentDao.updateStudentByStudentID(student);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Student queryStudentByStudentId(int id) {
        try {
            return studentDao.queryStudentByStudentID(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> queryStudentByClassId(int classID) {
        try {
            return studentDao.queryStudentByClassID(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> queryStudentByDormitoryId(int dormitoryID) {
        try {
            return studentDao.queryStudentByDormitoryId(dormitoryID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> queryStudentByCourseId(int courseID) {
        try {
            return studentDao.queryStudentByCourseId(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student queryStudentByBookId(int bookID) {
        try {
            return studentDao.queryStudentByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> queryAllStudent() {
        try {
            return studentDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
