package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private int AdminId;
    private String password;

    public Admin(){super();}

    public Admin(int Id, String passwd ){
        this.AdminId = Id;
        this.password = passwd;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
