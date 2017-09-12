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
    @Autowired
    CourseSelectDao courseSelectDao;
    CourseDao courseDao;

    public CourseSelectDao getCourseSelect() {
        return courseSelectDao;
    }

    public void setCourseSelect(CourseSelectDao courseSelect) {
        this.courseSelectDao = courseSelect;
    }

    //添加选课
    public int insertCourseSelect(CourseSelect courseSelect) {
        if(courseSelectDao.queryGradeByCourseIDAndStudentID(courseSelect.getCourseId(),courseSelect.getStudentId()) == courseSelect.getGrade())
            return 0;
        else
            return courseSelectDao.insertCourseSelect(courseSelect);
    }

    //删除所选课程
    public int deleteCourseSelectByCourseIDAndStudentID( int studentID ,  int courseID) {
        return courseSelectDao.deleteCourseSelectByCourseIDAndStudentID(studentID, courseID);
    }

    //更新选课信息
    public int updateGradeByCourseIDAndStudentID( int studentID,  int courseID,  int grade) {
        return courseSelectDao.updateGradeByCourseIDAndStudentID(studentID, courseID, grade);
    }

    //获取成绩
    public int queryGradeByCourseIDAndStudentID(  int studentID,  int courseID) {
        return courseSelectDao.queryGradeByCourseIDAndStudentID(studentID, courseID);
    }

    //获取学生的id，选课id，课程id和成绩
    public List<CourseSelect> getCourseSelectAll() {
        return courseSelectDao.queryAll();
    }


    public int insertCourse(Course course) {
        if(courseDao.queryCourseByCourseID(course.getCourseId()) == course)
            return 0;
        else
            return courseDao.insertCourse(course);
    }

    //删除课程
    public int deleteCourseByCourseId(Course course) {
        if(courseDao.queryCourseByCourseID(course.getCourseId()) == course)
            return courseDao.deleteCourseByCourseId(course.getCourseId());
        else
            return 0;

    }

    //更新课程
    public int updateCourseByCourseId(Course course) {
        if(courseDao.queryCourseByCourseID(course.getCourseId()) == course)
            return courseDao.updateCourseByCourseId(course.getCourseId(),course);
        else

            return 0;
    }

    //通过学生id查询课程
    public List<Course> queryCourseByStudentId(int id) {
        return courseDao.queryCourseByStudentId(id);
    }

    //通过教师id查询课程
    public List<Course> queryCourseByTeacherID(int id) {
        return courseDao.queryCourseByTeacherID(id);
    }

    //获取教师任教的这门课程的全部信息
    public List<Course> getCourseAll() {
       return courseDao.queryAll();
   }
}
