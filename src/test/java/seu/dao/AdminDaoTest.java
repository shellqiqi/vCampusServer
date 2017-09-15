package seu.dao;

import org.junit.Test;
import seu.config.ApplicationContextConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.domain.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class AdminDaoTest {

    @Autowired
    AdminDao adminDaoItem;

    @Test
    public void insertAdminTest() throws Exception {
        queryAllTest();
        Admin admin = new Admin(3,"3333");
        System.out.println(adminDaoItem.insertAdmin(admin));
        queryAllTest();
    }

    @Test
    public void insertAdminTest1() throws Exception {
        queryAllTest();
        System.out.println(adminDaoItem.insertAdmin(4,"4444"));
        queryAllTest();
    }

    @Test
    public void deleteAdminByIdTest() throws Exception {
        queryAllTest();
        System.out.println(adminDaoItem.deleteAdminById(4));
        queryAllTest();
    }

    @Test
    public void updateAdminPasswordByIdTest() throws Exception {
        queryAllTest();
        System.out.println(adminDaoItem.updateAdminPasswordById(2,"passwd2"));
        queryAllTest();
    }

    @Test
    public void updateAdminByAdminIDTest() throws Exception {
        Admin admin = new Admin(1,"Pass111");
        System.out.println(adminDaoItem.updateAdminByAdminID(admin));
    }

    @Test
    public void queryAdminByIdTest() throws Exception {
        System.out.println(adminDaoItem.queryAdminById(2));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(adminDaoItem.queryAll());
    }

}