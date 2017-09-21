package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.ClassDao;
import seu.domain.Class;

import java.util.List;

@Service
public class ClassService {

    private ClassDao classDao;

    /**
     *设置班级DAO
     * @param classDao 输入classDAO
     */
    @Autowired
    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    /**
     *新建班级
     * @param clss 输入班级对象
     * @return 插入成功返回1，不成功返回0，异常返回-1
     */
    public int insertClass(Class clss) {
        try {
            return classDao.insertClass(clss);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *删除班级
     * @param classID 输入班级ID
     * @return 删除成功返回1，不成功返回0，异常返回-1
     */
    public int deleteClass(int classID) {
        try {
            return classDao.deleteClassById(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *更新班级
     * @param clss 输入班级对象，为避免class保留字命名clss
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updateClass(Class clss) {
        try {
            return classDao.updateClassById(clss);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *通过班级ID找班级
     * @param classID 输入班级ID
     * @return 查询成功返回CLASS对象，不成功或异常返回null
     */
    public Class queryClassByClassId(int classID) {
        try {
            return classDao.queryClassById(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过学生ID找班级
     * @param studentID 输入学生ID
     * @return 查询成功返回CLASS对象，不成功或异常返回null
     */
    public Class queryClassByStudentId(int studentID) {
        try {
            return classDao.queryClassByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过教师ID找班级
     * @param teacherID 输入教师ID
     * @return 查询成功返回CLASS对象的LIST，不成功或异常返回null
     */
    public List<Class> queryClassByTeacherId(int teacherID) {
        try {
            return classDao.queryClassByTeacherId(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *查找所有班级
     * @return 返回所有班级的对象
     */
    public List<Class> queryAll() {
        try {
            return classDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
