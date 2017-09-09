package seu.service;

import seu.dao.DormitoryDao;
import seu.domain.Dormitory;

import java.util.List;

public class DormitoryService {
    DormitoryDao dormitoryuser;

    public DormitoryDao getDormitoryuser() {
        return dormitoryuser;
    }

    public void setDormitoryuser(DormitoryDao dormitoryuser) {
        this.dormitoryuser = dormitoryuser;
    }

    public int insertDormitory(final Dormitory dormitory) {
        return dormitoryuser.insertDormitory(dormitory);
    }

    public int insertDormitory(final int DormitoryID, final int Score) {
        return dormitoryuser.insertDormitory(DormitoryID, Score);
    }

    public int deleteDormitoryByID(final int DormitoryID) {
        return dormitoryuser.deleteDormitoryByID(DormitoryID);
    }

    public int updateScoreByID(final int DormitoryID, final int Score) {
        return dormitoryuser.updateScoreByID(DormitoryID, Score);
    }

    public int queryScoreByDormitoryID(final int DormitoryID) {
        return dormitoryuser.queryScoreByDormitoryID(DormitoryID);
    }

    //public List<Dormitory> queryDormitoryByStudentId(final int studentId) {
    //    return dormitoryuser.queryDormitoryByStudentId(studentId);
  //  }

}
