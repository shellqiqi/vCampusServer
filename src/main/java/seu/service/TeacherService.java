package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.TeacherDao;
import seu.domain.Teacher;

import java.util.List;

@Service
public class TeacherService {

    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public int login(int teacherId, String passwd) {
        try {
            Teacher teacher = teacherDao.queryTeacherByTeacherID(teacherId);
            if (teacher.getPassword().equals(passwd)) return 1;
            else return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void logout() {
        System.out.println("Logout");
    }

    public int insertTeacher(Teacher teacher) {
        try {
            return teacherDao.insertTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteTeacher(int teacherID) {
        try {
            return teacherDao.deleteTeacherByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateTeacherPassword(int teacherID, String passsword) {
        try {
            return teacherDao.updatePasswordByTeacherID(teacherID, passsword);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateTeacher(Teacher teacher) {
        try {
            teacherDao.updateTeacherNameByTeacherID(teacher.getTeacherId(), teacher.getTeacherName());
            teacherDao.updatePhoneNumberByTeacherID(teacher.getTeacherId(), teacher.getTeacherPhoneNumber());
            return teacherDao.updatePasswordByTeacherID(teacher.getTeacherId(), teacher.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Teacher queryTeacherByTeacherId(int teahcerID) {
        try {
            return teacherDao.queryTeacherByTeacherID(teahcerID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Teacher queryTeacherByClassId(int classID) {
        try {
            return teacherDao.queryTeacherByClassID(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Teacher queryTeacherByCourseId(int courseID) {
        try {
            return teacherDao.queryTeacherByCourseID(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Teacher> queryAllTeacher() {
        try {
            return teacherDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
