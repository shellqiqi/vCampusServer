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
    public void setStudentUser(StudentDao studentUser){
        this.studentDao = studentUser;
    }

    public int login(int studentId, String passwd){
        try {
            Student student = studentDao.queryStudentByStudentID(studentId);
            if (student.getPassword() == passwd)
                return 1;
            else
                return 0;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    public void logout(){
        System.out.println("Logout");
    }

    public int insertStudent(Student student){
        try{
            return studentDao.insertStudent(student);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int deleteStudent(int studentId){
        try{
            return studentDao.deleteStudentByStudentID(studentId);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    public int updateStudentPasswd(Student student){
        try{
            return studentDao.updatePasswordByStudentID(student.getStudentId(),student.getPassword());
        }
        catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }


}
