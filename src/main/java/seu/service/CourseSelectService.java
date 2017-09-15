package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CourseDao;
import seu.dao.CourseSelectDao;
import seu.domain.Course;
import seu.domain.CourseSelect;

import java.util.List;

@Service
public class CourseSelectService {

    private CourseDao courseDao;
    private CourseSelectDao courseSelectDao;

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setCourseSelect(CourseSelectDao courseSelect) {
        this.courseSelectDao = courseSelect;
    }

    //学生添加选课
    public int insertCourseSelect(final int studentID, final int courseID) {
        try {
            return courseSelectDao.insertCourseSelect(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生删除所选课程
    public int deleteCourseSelectByCourseIDAndStudentID(int studentID, int courseID) {
        try {
            return courseSelectDao.deleteCourseSelectByCourseIDAndStudentID(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生更新选课信息
    public int updateGradeByCourseIDAndStudentID(int studentID, int courseID, int grade) {
        try {
            return courseSelectDao.updateGradeByCourseIDAndStudentID(studentID, courseID, grade);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生获取成绩
    public int queryGradeByCourseIDAndStudentID(int studentID, int courseID) {
        try {
            return courseSelectDao.queryGradeByCourseIDAndStudentID(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生获取学生的id，选课id，课程id和成绩
    public List<CourseSelect> getCourseSelectAll() {
        try {
            return courseSelectDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //学生通过学生id查询课程
    public List<Course> queryCourseByStudentId(int studentID) {
        try {
            return courseDao.queryCourseByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //学生通过教师id查询课程
    public List<Course> queryCourseByTeacherID(int teacherID) {
        try {
            return courseDao.queryCourseByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取所有课程的全部信息
    public List<Course> getCourseAll() {
        try {
            return courseDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
