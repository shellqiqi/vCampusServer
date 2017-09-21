package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.DormitoryDao;
import seu.domain.Dormitory;

import java.util.List;

@Service
public class DormitoryService {

    private DormitoryDao dormitoryDao;

    /**
     * 设置宿舍DAO
     * @param dormitoryDao
     */
    @Autowired
    public void setDormitoryDao(DormitoryDao dormitoryDao) {
        this.dormitoryDao = dormitoryDao;
    }

    /**
     * 通过学生宿舍查询学生成绩
     * @param DormitoryID 宿舍ID
     * @return 查询宿舍分成功返回宿舍分数，不成功返回0，异常返回-1
     */
    public int queryScoreByDormitoryID(int DormitoryID) {
        try {
            return dormitoryDao.queryScoreByDormitoryID(DormitoryID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 通过学生id查询学生宿舍
     * @param studentId 学生ID
     * @return 返回学生的宿舍，异常返回null
     */
    public Dormitory getDormitoryByStudentId(int studentId) {
        try {
            return dormitoryDao.queryDormitoryByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 学生查询所有学生成绩及宿舍信息
     * @return 返回所有宿舍的List，异常返回null
     */
    public List<Dormitory> getDormitoryAll() {
        try {
            return dormitoryDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 管理员增加宿舍
     * @param dormitory 宿舍对象
     * @return 增加宿舍成功返回1，不成功返回0，异常返回-1
     */
    public int insertDormitory(Dormitory dormitory) {
        try {
            return dormitoryDao.insertDormitory(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 管理员删除宿舍
     * @param dormitoryID 宿舍ID
     * @return 删除宿舍成功返回1，不成功返回0，异常返回-1
     */
    public int deleteDormitoryByID(int dormitoryID) {
        try {
            return dormitoryDao.deleteDormitoryByID(dormitoryID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 管理员更新学生分数与宿舍信息
     * @param dormitoryID 宿舍ID
     * @param score 宿舍分数
     * @return 更新宿舍分数成功返回1，不成功返回0，异常返回-1
     */
    public int updateScoreByID(int dormitoryID, int score) {
        try {
            return dormitoryDao.updateScoreByID(dormitoryID, score);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
