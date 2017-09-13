package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private int adminId;
    private String password;

    public Admin(){super();}

    public Admin(int Id, String passwd ){
        this.adminId = Id;
        this.password = passwd;
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
        return "Admin{" +
                "adminId=" + adminId +
                ", password='" + password + '\'' +
                '}';
    }
}
