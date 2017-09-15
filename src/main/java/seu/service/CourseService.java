package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CourseDao;
import seu.domain.Course;

import java.util.List;

@Service
public class CourseService {

    private CourseDao courseDao;

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public int insertCourse(Course course) {
        try {
            return courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteCourse(int courseID) {
        try {
            return courseDao.deleteCourseByCourseId(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateCourse(Course course) {
        try {
            return courseDao.updateCourseByCourseId(course.getCourseId(), course);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Course queryCourseByCourseId(int courseID) {
        try {
            return courseDao.queryCourseByCourseID(courseID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> queryCourseByStudentId(int studentID) {
        try {
            return courseDao.queryCourseByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> queryCourseByTeacherId(int teacherID) {
        try {
            return courseDao.queryCourseByTeacherID(teacherID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> queryAll() {
        try {
            return courseDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
