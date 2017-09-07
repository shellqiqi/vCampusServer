package seu.dao;

import static org.junit.Assert.*;
import seu.config.ApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Created by Q on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class StudentDaoTest {

    @Autowired
    StudentDao studentDaoTest;

   @Test
   public void updateDormitoryIDByID() throws Exception {


       //studentDaoTest.updateDormitoryIDByID(16,0);
}}