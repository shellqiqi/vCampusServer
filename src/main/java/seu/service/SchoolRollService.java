package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.StudentDao;
import seu.domain.Student;

import java.util.List;
@Service
public class SchoolRollService {
    @Autowired
    StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //添加学生信息
    public int addSchoolRoll(Student student){
        if(studentDao.queryStudenetByStudentID(student.getStudentId()) == student)
            return 0;
        else
            return studentDao.insertStudent(student);
    }

    public int addStudentRoll(int studentId, String studentName, int classId, int dormitoryId, int balance, String password){
        if(studentDao.queryStudentByStudentID(studentId).getStudentId() == studentId)
            return 0;
        else
            return studentDao.insertStudent(studentId, studentName, classId, dormitoryId, balance, password);
    }

    //删除学生学籍信息
    public int deleteSchoolRollById(int id){
        return studentDao.deleteStudentByID(id);
    }

    public int changeStudentNameByStudentId(int id, String name){
        return studentDao.updateStudentNameByStudentID(id, name);
    }

    public int changeClassIdByStudentId(int studentId, int classId){
        return studentDao.updateClassIDByStudentID(studentId, classId);
    }

    public int changeDormitoryIdByStudentId(int studentId, int dormitoryId){
        return studentDao.updateDormitoryIDByStudentID(studentId, dormitoryId);
    }

    public int changeBalanceByStudentId(int studentId, int balance){
        return studentDao.updateBalanceByStudentID();
    }

    public int changePasswordByStudentId(int studentId, String password){
        return studentDao.updatePasswordByStudentID(studentId, password);
    }

    public Student getStudentRollByStudentId(int studentId){
        return studentDao.queryStudentByStudentID(studentId);
    }

    public List<Student> getStudentRollByClassId(int classId){
        return studentDao.queryStudentByClassID(classId);
    }

    public List<Student> getStudentRollByCourseId(int courseId){
        return studentDao.queryStudentByCourseId(courseId);
    }

    public List<Student> getStudentRollByBookId(int bookId){
        return studentDao.queryStudentByBookId(bookId);
    }

    public List<Student> getStudentByDormitoryId(int dormitoryId){
        return studentDao.queryStudentByDormitoryId(dormitoryId);
    }

    public List<Student> getSchoolRollAll(){
        return studentDao.queryAll();
    }
}
