package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.ClassDao;
import seu.domain.Class;

import java.util.List;

@Service
public class ClassService {

    private ClassDao classDao;

    @Autowired
    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    public int insertClass(Class clss) {
        try {
            return classDao.insertClass(clss);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteClass(int classID) {
        try {
            return classDao.deleteClassById(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateClass(Class clss) {
        try {
            return classDao.updateClassById(clss);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Class queryClassByClassId(int classID) {
        try {
            return classDao.queryClassById(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Class queryClassByStudentId(int studentID) {
        try {
            return classDao.queryClassByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Class> queryClassByTeacherId(int teacherID) {
        try {
            return classDao.queryClassByTeacherId(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Class> queryAll() {
        try {
            return classDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
