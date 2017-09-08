package seu.service;

import seu.dao.DormitoryDao;
import seu.domain.Dormitory;

public class DormitoryService {
    DormitoryDao dormitoryuser;

    public DormitoryDao getDormitoryuser() {
        return dormitoryuser;
    }

    public void setDormitoryuser(DormitoryDao dormitoryuser) {
        this.dormitoryuser = dormitoryuser;
    }

    public int addDormitory(final Dormitory dormitory) {
        return dormitoryuser.addDormitory(dormitory);
    }
}
