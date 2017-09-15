package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Admin implements Serializable {
    private int adminId;
    private String password;

    public Admin() {
        super();
    }

    public Admin(int adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", password='" + password + '\'' + '}';
    }
}
