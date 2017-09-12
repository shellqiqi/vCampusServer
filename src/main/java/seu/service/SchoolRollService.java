package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.ClassDao;
import seu.domain.Class;
import seu.dao.StudentDao;
import seu.domain.Student;


import java.util.List;
@Service
public class SchoolRollService {
    @Autowired
    StudentDao studentDao;
    ClassDao classDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //添加学生基本信息
    public int addSchoolRoll(Student student){
        if(studentDao.queryStudentByStudentID(student.getStudentId()) == student)
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

    //添加学生班级信息
    public int addStudentClass(Class cla){
        return classDao.insertClass(cla);
    }

    //删除学生基本信息
    public int deleteSchoolRollById(int id){
        return studentDao.deleteStudentByStudentID(id);
    }

    //删除学生班级信息
    public int deleteClassByClassId(int id){
        return classDao.deleteClassById(id);

    }
    //更改学生基本信息
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
        return studentDao.updateBalanceByStudentID(studentId, balance);
    }

    public int changePasswordByStudentId(int studentId, String password){
        return studentDao.updatePasswordByStudentID(studentId, password);
    }

    //更改学生班级信息
    public int changeClassByClassId(int id, Class cla){
        return classDao.updateClassById(id, cla);
    }

    //获取学生信息
    public Student getStudentRollByStudentId(int studentId){
        return studentDao.queryStudentByStudentID(studentId);
    }

    public List<Student> getStudentRollByClassId(int classId){
        return studentDao.queryStudentByClassID(classId);
    }

    public List<Student> getStudentRollByCourseId(int courseId){
        return studentDao.queryStudentByCourseId(courseId);
    }

    public Student getStudentRollByBookId(int bookId){
        return studentDao.queryStudentByBookId(bookId);
    }

    public List<Student> getStudentByDormitoryId(int dormitoryId){
        return studentDao.queryStudentByDormitoryId(dormitoryId);
    }

    public List<Student> getSchoolRollAll(){
        return studentDao.queryAll();
    }

    //获取学生班级信息
    public List<Class> getClassByTeacherId(int id){
        return classDao.queryClassByTeacherId(id);
    }

    public Class getClassByStudentId(int id){
        return classDao.queryClassByStudentId(id);
    }

    public Class getClassByClassId(int id){
        return classDao.queryClassById(id);
    }

    public List<Class> getClassAll(){
        return classDao.queryAll();
    }
}
