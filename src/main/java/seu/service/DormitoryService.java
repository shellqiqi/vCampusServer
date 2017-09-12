package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.DormitoryDao;
import seu.domain.Dormitory;

import java.util.List;
@Service
public class DormitoryService{
    @Autowired
    DormitoryDao dormitoryDao;

    public DormitoryDao getDormitoryUser() {
        return dormitoryDao;
    }

    public void setDormitoryUser(DormitoryDao dormitoryUser) {
        this.dormitoryDao = dormitoryUser;
    }

    //学生通过学生宿舍查询学生成绩
    public int queryScoreByDormitoryID(int DormitoryID) {
        return dormitoryDao.queryScoreByDormitoryID(DormitoryID);
    }

    //学生通过学生id查询学生宿舍
    public Dormitory getDormitoryByStudentId(int studentId) {
        return dormitoryDao.queryDormitoryByStudentId(studentId);
    }

    //学生查询所有学生成绩及宿舍信息
    public List<Dormitory> getDormitoryAll() {
        return dormitoryDao.queryAll();
    }
}
