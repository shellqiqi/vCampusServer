package seu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Admin;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    public void loginTest() throws Exception {
        System.out.println(adminService.login(1,"pass111"));
    }

    @Test
    public void logoutTest() throws Exception {
    }

    @Test
    public void insertAdminTest() throws Exception {
        Admin admin = new Admin(5,"pass555");
        System.out.println(adminService.insertAdmin(admin));
    }

    @Test
    public void deleteAdminTest() throws Exception {
        System.out.println(adminService.deleteAdmin(5));
    }

    @Test
    public void updateAdminPasswordTest() throws Exception {
        System.out.println(adminService.updateAdminPassword(1,"password1"));
    }

    @Test
    public void updateAdminTest() throws Exception {
        Admin a = new Admin(1,"pass111");
        System.out.println(adminService.updateAdmin(a));
    }

    @Test
    public void queryAdminByAdminIdTest() throws Exception {
        System.out.println(adminService.queryAdminByAdminId(1));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(adminService.queryAll());
    }

}