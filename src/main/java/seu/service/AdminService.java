package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.AdminDao;
import seu.domain.Admin;

import java.util.List;

@Service
public class AdminService {

    private AdminDao adminDao;

    /**
     *设置管理员DAO
     * @param adminDao 输入ADMIN的DAO
     */
    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    /**
     *管理员登陆
     * @param adminID 管理员ID
     * @param password 管理员密码
     * @return 登陆成功返回1，不成功返回0，异常返回-1
     */
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

    /**
     *登出
     * @return “logout”
     */
    public String logout() {
        return "Logout";
    }

    /**
     *新建管理员
     * @param admin 管理员对象
     * @return 插入成功返回1，失败返回-1
     */
    public int insertAdmin(Admin admin) {
        try {
            return adminDao.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *删除管理员
     * @param adminID 管理员ID
     * @return 删除成功返回1，删除对象不存在返回0，异常返回-1
     */
    public int deleteAdmin(int adminID) {
        try {
            return adminDao.deleteAdminById(adminID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *更新管理员密码
     * @param adminID 管理员ID
     * @param passwd 管理员的新密码
     * @return 修改成功返回1，不成功返回0，异常返回-1
     */
    public int updateAdminPassword(int adminID, String passwd) {
        try {
            return adminDao.updateAdminPasswordById(adminID, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *更新管理员信息
     * @param admin 管理员对象
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updateAdmin(Admin admin) {
        try {
            return adminDao.updateAdminByAdminID(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *通过管理员ID查找管理员
     * @param adminID 管理员ID
     * @return 查询成功返回1，不成功返回0，异常返回-1
     */
    public Admin queryAdminByAdminId(int adminID) {
        try {
            return adminDao.queryAdminById(adminID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *返回所有管理员的List
     * @return 查询成功返回管理员LIST，异常返回null
     */
    public List<Admin> queryAll() {
        try {
            return adminDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
