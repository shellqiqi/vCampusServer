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

    /**
     * 设置课程DAO
     * @param courseDao 课程DAO对象
     */
    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    /**
     * 设置选课DAO
     * @param courseSelect
     */
    @Autowired
    public void setCourseSelect(CourseSelectDao courseSelect) {
        this.courseSelectDao = courseSelect;
    }

    /**
     * 学生添加选课
     * @param studentID 学生ID
     * @param courseID 选课ID
     * @return 选课成功返回1，已经有学生选了这门课返回-2，失败返回0，选课异常返回-1
     */
    public int insertCourseSelect(final int studentID, final int courseID) {
        try {
            List<Course> studentCourses = courseDao.queryCourseByStudentId(studentID);
            Course course = courseDao.queryCourseByCourseID(courseID);
            if( studentCourses.contains(course) ){
                //该学生已经选了这门课
                return -2;
            }
            else
                return courseSelectDao.insertCourseSelect(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 学生删除所选课程
     * @param studentID 学生的ID
     * @param courseID 课程ID
     * @return 删除课程成功返回1，不成功返回0，异常返回-1
     */
    public int deleteCourseSelectByCourseIDAndStudentID(int studentID, int courseID) {
        try {
            return courseSelectDao.deleteCourseSelectByCourseIDAndStudentID(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 学生更新选课信息
     * @param studentID 学生ID
     * @param courseID 课程ID
     * @param grade 课程成绩
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updateGradeByCourseIDAndStudentID(int studentID, int courseID, int grade) {
        try {
            return courseSelectDao.updateGradeByCourseIDAndStudentID(studentID, courseID, grade);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 学生获取成绩
     * @param studentID 学生ID
     * @param courseID 课程ID
     * @return 查询成功成功返回成绩分数，异常返回-1
     */
    public int queryGradeByCourseIDAndStudentID(int studentID, int courseID) {
        try {
            return courseSelectDao.queryGradeByCourseIDAndStudentID(studentID, courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 学生获取学生的id，选课id，课程id和成绩
     * @return 返回所有选课信息
     */
    public List<CourseSelect> getCourseSelectAll() {
        try {
            return courseSelectDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 学生通过学生id查询课程
     * @param studentID 学生ID
     * @return 返回学生选的所有课程
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
     * 学生通过教师id查询课程
     * @param teacherID 教师ID
     * @return 返回教师的所有课程，异常返回null
     */
    public List<Course> queryCourseByTeacherID(int teacherID) {
        try {
            return courseDao.queryCourseByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取所有课程的全部信息
     * @return 返回所有课程，异常返回null
     */
    public List<Course> getCourseAll() {
        try {
            return courseDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
