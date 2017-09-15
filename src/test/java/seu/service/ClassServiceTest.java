package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Class;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class ClassServiceTest {
    @Autowired
    ClassService classService;

    @Test
    public void insertClass() throws Exception {
        Class clss = new Class(90151,"class one","Cs",35,4);
        System.out.println(classService.insertClass(clss));
    }

    @Test
    public void deleteClass() throws Exception {
        System.out.println(classService.deleteClass(90151));
    }

    @Test
    public void updateClass() throws Exception {
        Class clss = new Class(90151,"ss0","ss",11,2);
        System.out.println(classService.updateClass(clss));
    }

    @Test
    public void queryClassByClassId() throws Exception {
        System.out.println(classService.queryClassByClassId(90153));
    }

    @Test
    public void queryClassByStudentId() throws Exception {
        System.out.println(classService.queryClassByStudentId(4));
    }

    @Test
    public void queryClassByTeacherId() throws Exception {
        System.out.println(classService.queryClassByTeacherId(4));
    }

    @Test
    public void queryAll() throws Exception {
        System.out.println(classService.queryAll());
    }

}