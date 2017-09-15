package seu.service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Dormitory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class DormitoryServiceTest {
    @Autowired
    private DormitoryService dormitoryService;
    @Test
    public void queryScoreByDormitoryID() throws Exception {
        System.out.println(dormitoryService.queryScoreByDormitoryID(1));
    }

    @Test
    public void getDormitoryByStudentId() throws Exception {
        System.out.println(dormitoryService.getDormitoryByStudentId(1));
    }

    @Test
    public void getDormitoryAll() throws Exception {
        System.out.println(dormitoryService.getDormitoryAll());
    }

    @Test
    public void insertDormitory() throws Exception {
        Dormitory dormitory = new Dormitory();
        dormitory.setDormitoryId(11);
        dormitory.setScore(998);
        System.out.println(dormitoryService.insertDormitory(dormitory));
    }

    @Test
    public void deleteDormitoryByID() throws Exception {
        System.out.println(dormitoryService.deleteDormitoryByID(11));
    }

    @Test
    public void updateScoreByID() throws Exception {
        System.out.println(dormitoryService.updateScoreByID(5,5555));
    }

}