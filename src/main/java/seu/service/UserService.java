package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.dao.StudentDao;
import seu.dao.TeacherDao;
import seu.domain.Admin;
import seu.domain.Student;
import seu.domain.Teacher;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private AdminDao adminDao;
    private StudentDao studentDao;
    private TeacherDao teacherDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    //管理员登录
     public boolean adminSignIn(int id, String password){
        if((adminDao.queryAdminById(id).getAdminId() == id) && (adminDao.queryAdminById(id).getPassword() == password))
            return true;
        else
            return false;
    }

    //学生登录
    public boolean studentSignIn(int id, String password){
       if((studentDao.queryStudentByStudentID(id).getStudentId() == id) && (studentDao.queryStudentByStudentID(id).getPassword() == password))
           return true;
       else
           return false;
    }

    //教师登录
    public boolean teacherSignIn(int id, String password){
        if((teacherDao.queryTeacherByTeacherID(id).getTeacherId() == id) && (teacherDao.queryTeacherByTeacherID(id).getPassword() == password))
            return true;
        else
            return false;
    }

    //管理员注册
    public int addAdmin(Admin admin) {
        if(adminDao.queryAdminById(admin.getAdminId()) == admin)
            return 0;
        else
            return adminDao.insertAdmin(admin);
    }

    public int addAdmin(int id, String password){
        if(adminDao.queryAdminById(id).getAdminId() == id)
            return 0;
        else
            return adminDao.insertAdmin(id, password);
    }

    //学生注册
    public int addStudent(Student student){
        if(studentDao.queryStudentByStudentID(student.getStudentId()) == student)
            return 0;
        else
            return studentDao.insertStudent(student);
    }

    public int addStudent(int id, String studentName, int classId, int dormitoryId, int balance, String password){
        if(studentDao.queryStudentByStudentID(id).getStudentId() == id)
            return 0;
        else
            return studentDao.insertStudent(id, studentName, classId, dormitoryId, balance, password);
    }

    //教师注册
    public int addTeacher(Teacher teacher){
        if(teacherDao.queryTeacherByTeacherID(teacher.getTeacherId()) == teacher)
            return 0;
        else
            return teacherDao.insertTeacher(teacher);
    }

    public int addTeacher(int id, String teacherName, int phoneNumber, String password){
        if(teacherDao.queryTeacherByTeacherID(id).getTeacherId() == id)
            return 0;
        else
            return teacherDao.insertTeacher(id, teacherName, phoneNumber, password);
    }

    //注销管理员账户
    public int deleteAdminById(int id){
        return adminDao.deleteAdminById(id);
    }

    //注销学生账户
    public int deleteStudentByStudentId(int id){
        return studentDao.deleteStudentByStudentID(id);
    }

    //注销老师账户
    public int deleteTeacherByTeacherId(int id){
        return teacherDao.deleteTeacherByTeacherID(id);
    }

    //修改管理员密码
    public int changeAdminPasswordById(int id, String password){
        return adminDao.updateAdminPasswordById(id, password);
    }

    //修改学生密码
    public int changeStudentPasswordByStudentId(int id, String password){
        return studentDao.updatePasswordByStudentID(id, password);
    }

    //修改教师密码
    public int changeTeacherPasswordByTeacherId(int id, String password){
        return teacherDao.updatePasswordByTeacherID(id, password);
    }

    //获取管理员信息
    public Admin getAdminById(int id){
        return adminDao.queryAdminById(id);
    }

    public List<Admin> getAdmin(){
        return adminDao.queryAll();
    }
 
}
