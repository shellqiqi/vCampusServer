package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.ClassDao;
import seu.dao.StudentDao;
import seu.domain.Class;
import seu.domain.Student;

@Service
public class SchoolRollService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClassDao classDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

   //学生添加个人基本信息
    public int addSchoolRoll(Student student){
        if(studentDao.queryStudentByStudentID(student.getStudentId()) == student)
            return 0;
        else
            return studentDao.insertStudent(student);
    }

    //学生添加个人班级信息
    public int addStudentClass(Class cla){
        return classDao.insertClass(cla);
    }

    //学生修改个人基本信息
    public int changeStudentNameByStudentId(Student student){
        return studentDao.updateStudentNameByStudentID(student.getStudentId(), student.getStudentName());
    }

    public int changeClassIdByStudentId(Student student){
        return studentDao.updateClassIDByStudentID(student.getStudentId(), student.getClassId());
    }

    public int changeDormitoryIdByStudentId(Student student){
        return studentDao.updateDormitoryIDByStudentID(student.getStudentId(), student.getDormitoryId());
    }

    public int changeBalanceByStudentId(Student student){
        return studentDao.updateBalanceByStudentID(student.getStudentId(), student.getBalance());
    }

    public int changePasswordByStudentId(Student student){
        return studentDao.updatePasswordByStudentID(student.getStudentId(), student.getPassword());
    }

    //学生更改学生班级信息
    public int changeClassByClassId(Class cla){
        return classDao.updateClassById(cla.getClassId(), cla);
    }

   //学生通过学号查询个人学籍信息
    public Student getStudentRollByStudentId(int studentId){
        return studentDao.queryStudentByStudentID(studentId);
    }

    //学生通过学号查询个人班级信息
    public Class getClassByStudentId(int id){
        return classDao.queryClassByStudentId(id);
    }

    //学生通过班级号查询班级信息
    public Class getClassByClassId(int id){
        return classDao.queryClassById(id);
    }
}
