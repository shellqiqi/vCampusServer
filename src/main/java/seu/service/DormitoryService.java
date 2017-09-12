package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.DormitoryDao;
import seu.domain.Dormitory;

import java.util.List;
@Service
public class DormitoryService{
    @Autowired
    DormitoryDao dormitoryUser;

    public DormitoryDao getDormitoryUser() {
        return dormitoryUser;
    }

    public void setDormitoryUser(DormitoryDao dormitoryUser) {
        this.dormitoryUser = dormitoryUser;
    }

    //增加宿舍
    public int insertDormitory(Dormitory dormitory) {
        if(dormitoryUser.queryScoreByDormitoryID(dormitory.getDormitoryId()) == dormitory.getScore())
            return 0;
        else
            return dormitoryUser.insertDormitory(dormitory);
    }



    //删除宿舍
    public int deleteDormitoryByID(Dormitory dormitory) {
        if(dormitoryUser.queryScoreByDormitoryID(dormitory.getDormitoryId()) == dormitory.getScore())
            return dormitoryUser.deleteDormitoryByID(dormitory.getDormitoryId());
        else
            return 0;
    }

    //更新学生分数与宿舍信息
    public int updateScoreByID(Dormitory dormitory) {
        if(dormitoryUser.queryScoreByDormitoryID(dormitory.getDormitoryId()) == dormitory.getScore())
            return 0;
        else
            return dormitoryUser.updateScoreByID(dormitory.getDormitoryId()
                , dormitory.getScore());
    }

    //通过学生宿舍查询学生成绩
    public int queryScoreByDormitoryID(int DormitoryID) {
        return dormitoryUser.queryScoreByDormitoryID(DormitoryID);
    }

    //通过学生id查询学生宿舍
    public Dormitory getDormitoryByStudentId(int studentId) {
        return dormitoryUser.queryDormitoryByStudentId(studentId);
    }

    //查询学生成绩级宿舍信息
    public List<Dormitory> getDormitoryAll() {
        return dormitoryUser.queryAll();
    }
}
