package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.domain.Admin;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    //登录
    public boolean SignIn(int id, String password){
        if((adminDao.queryAdminById(id).getAdminId() == id) && (adminDao.queryAdminById(id).getPassword() == password))
            return true;
        else
            return false;
    }

    //注册
    public int addAdmin(Admin admin) {
        if(adminDao.queryAdminById(admin.getAdminId()) == admin)
            return 0;
        else
            return adminDao.insertAdmin(admin);
    }

    public int addAdmin(int id, String password){
        if(adminDao.queryAdminById(id).getAdminId() == id)
            return 0;
        else
            return adminDao.insertAdmin(id, password);
    }

    //注销
    public int deleteAdminById(int id){
        return adminDao.deleteAdminById(id);
    }

    //修改密码
    public int changeAdminPasswordById(int id, String password){
        return adminDao.updateAdminPasswordById(id, password);
    }

    public Admin getAdminById(int id){
        return adminDao.queryAdminById(id);
    }

    public List<Admin> getAdmin(){
        return adminDao.queryAll();
    }
}
