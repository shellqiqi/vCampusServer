package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CourseDao;
import seu.domain.Course;

import java.util.List;

@Service
public class CourseService {

    private CourseDao courseDao;

    /**
     * 设置课程DAO
     * @param courseDao 课程DAO
     */
    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    /**
     * 增加课程
     * @param course 课程对象
     * @return 增加课程成功返回1，不成功返回0，异常返回-1
     */
    public int insertCourse(Course course) {
        try {
            return courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 删除课程
     * @param courseID 课程ID
     * @return 删除成功返回1，不成功返回0，异常返回-1
     */
    public int deleteCourse(int courseID) {
        try {
            return courseDao.deleteCourseByCourseId(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 更新课程通过课程对象
     * @param course 课程对象
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updateCourse(Course course) {
        try {
            return courseDao.updateCourseByCourseId(course.getCourseId(), course);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 通过课程ID查找课程
     * @param courseID 课程ID
     * @return 课程对象
     */
    public Course queryCourseByCourseId(int courseID) {
        try {
            return courseDao.queryCourseByCourseID(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过学生ID查找课程
     * @param studentID 学生ID
     * @return 返回学生所有的课程，异常返回null
     */
    public List<Course> queryCourseByStudentId(int studentID) {
        try {
            return courseDao.queryCourseByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过教师ID查找课程
     * @param teacherID 教师ID
     * @return 返回所有课程的List，异常返回null
     */
    public List<Course> queryCourseByTeacherId(int teacherID) {
        try {
            return courseDao.queryCourseByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有课程
     * @return 所有课程的List
     */
    public List<Course> queryAll() {
        try {
            return courseDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
