package seu.service;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CourseSelectServiceTest {
    @Autowired
    private CourseSelectService courseSelectService;

    @Test
    public void insertCourseSelect() throws Exception {
        System.out.println(courseSelectService.insertCourseSelect(1,5));
    }

    @Test
    public void deleteCourseSelectByCourseIDAndStudentID() throws Exception {
        System.out.println(courseSelectService.deleteCourseSelectByCourseIDAndStudentID(1,5));
    }

    @Test
    public void updateGradeByCourseIDAndStudentID() throws Exception {
        System.out.println(courseSelectService.updateGradeByCourseIDAndStudentID(2,2,999));
    }

    @Test
    public void queryGradeByCourseIDAndStudentID() throws Exception {
        System.out.println(courseSelectService.queryGradeByCourseIDAndStudentID(2,2));
    }

    @Test
    public void getCourseSelectAll() throws Exception {
        System.out.println(courseSelectService.getCourseAll());
    }

    @Test
    public void queryCourseByStudentId() throws Exception {
        System.out.println(courseSelectService.queryCourseByStudentId(2));
    }

    @Test
    public void queryCourseByTeacherID() throws Exception {
        System.out.println(courseSelectService.queryCourseByTeacherID(2));
    }

    @Test
    public void getCourseAll() throws Exception {
        System.out.println(courseSelectService.getCourseAll());
    }

}