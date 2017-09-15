package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.domain.Admin;

import java.util.List;

@Service
public class AdminService {

    private AdminDao adminDao;

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public int login(int adminID, String password) {
        try {
            Admin admin = adminDao.queryAdminById(adminID);
            if (admin.getPassword().equals(password)) return 1;
            else return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String logout() {
        return "Logout";
    }

    public int insertAdmin(Admin admin) {
        try {
            return adminDao.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteAdmin(int adminID) {
        try {
            return adminDao.deleteAdminById(adminID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateAdminPassword(int adminID, String passwd) {
        try {
            return adminDao.updateAdminPasswordById(adminID, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateAdmin(Admin admin) {
        try {
            return adminDao.updateAdminByAdminID(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Admin queryAdminByAdminId(int adminID) {
        try {
            return adminDao.queryAdminById(adminID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Admin> queryAll() {
        try {
            return adminDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
