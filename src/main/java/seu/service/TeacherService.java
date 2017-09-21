package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.TeacherDao;
import seu.domain.Teacher;

import java.util.List;

@Service
public class TeacherService {

    private TeacherDao teacherDao;

    /**
     *设置教师DAO
     * @param teacherDao 输入教师DAO
     */
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    /**
     *登入
     * @param teacherId 登陆教师的ID
     * @param passwd 教师的密码
     * @return 登陆成功返回1，不成功返回0，异常返回-1
     */
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

    /**
     * 登出
     */
    public void logout() {
        System.out.println("Logout");
    }

    /**
     * 新建教师
     * @param teacher 输入教师对象
     * @return 插入成功返回1，不成功返回0，异常返回-1
     */
    public int insertTeacher(Teacher teacher) {
        try {
            return teacherDao.insertTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 从数据库删除教师
     * @param teacherID 教师ID
     * @return 删除成功返回1，不成功返回0，异常返回-1
     */
    public int deleteTeacher(int teacherID) {
        try {
            return teacherDao.deleteTeacherByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 更新教师的密码
     * @param teacherID 教师ID
     * @param passsword 新密码
     * @return 更新密码成功返回1，不成功返回0，异常返回-1
     */
    public int updateTeacherPassword(int teacherID, String passsword) {
        try {
            return teacherDao.updatePasswordByTeacherID(teacherID, passsword);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 更新教师信息
     * @param teacher 新的教师对象
     * @return 更新教师信息成功返回1，不成功返回0，异常返回-1
     */
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

    /**
     * 查找教师
     * @param teahcerID 教师ID
     * @return 查找教师成功返回教师对象，失败返回null
     */
    public Teacher queryTeacherByTeacherId(int teahcerID) {
        try {
            return teacherDao.queryTeacherByTeacherID(teahcerID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过班级ID查找教师
     * @param classID 班级ID
     * @return 查找成功返回教师对象，否则返回null
     */
    public Teacher queryTeacherByClassId(int classID) {
        try {
            return teacherDao.queryTeacherByClassID(classID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过课程ID查找教学老师
     * @param courseID 课程ID
     * @return 查找成功返回教师对象，否则返回null
     */
    public Teacher queryTeacherByCourseId(int courseID) {
        try {
            return teacherDao.queryTeacherByCourseID(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有教师
     * @return 返回所有教师List
     */
    public List<Teacher> queryAllTeacher() {
        try {
            return teacherDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
