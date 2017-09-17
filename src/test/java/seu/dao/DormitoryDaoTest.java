package seu.dao;

import org.junit.Test;
import seu.config.ApplicationContextConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import seu.domain.Dormitory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class DormitoryDaoTest {

    @Autowired
    DormitoryDao dormitoryDaoItem;

    @Test
    public void insertDormitoryTest() throws Exception {
        queryAllTest();
        Dormitory dor = new Dormitory(6,66);
        System.out.println(dormitoryDaoItem.insertDormitory(dor));
        queryAllTest();
    }

    @Test
    public void insertDormitoryTest1() throws Exception {
        queryAllTest();
        int id = 7 ; int score = 7;
        System.out.println(dormitoryDaoItem.insertDormitory(id,score));
        queryAllTest();
    }

    @Test
    public void deleteDormitoryByIDTest() throws Exception {
        queryAllTest();
        System.out.println(dormitoryDaoItem.deleteDormitoryByID(7));
        queryAllTest();
    }

    @Test
    public void updateScoreByIDTest() throws Exception {
        queryAllTest();
        System.out.println(dormitoryDaoItem.updateScoreByID(1,11));
        queryAllTest();
    }

    @Test
    public void queryScoreByDormitoryIDTest() throws Exception {
        System.out.println(dormitoryDaoItem.queryScoreByDormitoryID(3));
    }

    @Test
    public void queryDormitoryByStudentIdTest() throws Exception {
        System.out.println(dormitoryDaoItem.queryDormitoryByStudentId(2));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(dormitoryDaoItem.queryAll());
    }

}