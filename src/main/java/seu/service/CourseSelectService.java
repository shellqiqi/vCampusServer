package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CourseSelectDao;
import seu.domain.CourseSelect;

import java.util.List;
@Service
public class CourseSelectService {
    @Autowired
    CourseSelectDao courseSelectDao;

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

    //这个地方我很不确定怎么写，我的目的是判断搜出的分数不存在，但是不会写
    public int insertCourseSelect(int studentID, int courseID ) {
        if(courseSelectDao.queryGradeByCourseIDAndStudentID(studentID,courseID) == 0)
            return 0;
        else
            return courseSelectDao.insertCourseSelect(studentID, courseID);
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
    public List<CourseSelect> getAll() {
        return courseSelectDao.queryAll();
    }
}
