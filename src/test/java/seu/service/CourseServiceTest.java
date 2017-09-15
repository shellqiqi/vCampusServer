package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Course;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @Test
    public void insertCourseTest() throws Exception {
        Course course = new Course(10,"c1",11,11,3);
        System.out.println(courseService.insertCourse(course));
    }

    @Test
    public void deleteCourseTest() throws Exception {
        System.out.println(courseService.deleteCourse(10));
    }

    @Test
    public void updateCourseTest() throws Exception {
        Course course = new Course(1,"Course101",11,11,2);
        System.out.println(courseService.updateCourse(course));
    }

    @Test
    public void queryCourseByCourseIdTest() throws Exception {
        System.out.println(courseService.queryCourseByCourseId(1));
    }

    @Test
    public void queryCourseByStudentIdTest() throws Exception {
        System.out.println(courseService.queryCourseByStudentId(1));
    }

    @Test
    public void queryCourseByTeacherIdTest() throws Exception {
        System.out.println(courseService.queryCourseByTeacherId(1));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(courseService.queryAll());
    }

}