package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.dao.StudentDao;
import seu.dao.TeacherDao;
import seu.domain.Admin;
import seu.domain.Student;
import seu.domain.Teacher;
@Service
public class UserService {

    @Autowired
    AdminDao adminDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

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

    //学生注册
    public int addStudent(Student student){
        if(studentDao.queryStudentByStudentID(student.getStudentId()) == student)
            return 0;
        else
            return studentDao.insertStudent(student);
    }

    //教师注册
    public int addTeacher(Teacher teacher){
        if(teacherDao.queryTeacherByTeacherID(teacher.getTeacherId()) == teacher)
            return 0;
        else
            return teacherDao.insertTeacher(teacher);
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

    //管理员修改个人密码
    public int changeAdminPasswordById(Admin admin){
        return adminDao.updateAdminPasswordById(admin.getAdminId(), admin.getPassword());
    }

    //学生修改个人密码
    public int changeStudentPasswordByStudentId(Student student){
        return studentDao.updatePasswordByStudentID(student.getStudentId(), student.getPassword());
    }

    //教师修改个人密码
    public int changeTeacherPasswordByTeacherId(Teacher teacher){
        return teacherDao.updatePasswordByTeacherID(teacher.getTeacherId(), teacher.getPassword());
    }
}
