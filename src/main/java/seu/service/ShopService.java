package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import seu.dao.CommodityDao;
import seu.dao.StudentDao;
import seu.domain.Commodity;
import seu.domain.Student;

import java.util.List;

@Service
public class ShopService {

    private StudentDao studentDao;
    private CommodityDao commodityDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    public int updatePrice(int commodityID, int price) {

        try {
            return commodityDao.updateCommodityPrizeById(commodityID, price);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateInventory(int commodityID, int price) {
        try {
            return commodityDao.updateCommodityInventoryById(commodityID, price);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateCommodity(Commodity commodity) {
        try {
            int ifUpdateInvent = commodityDao.updateCommodityInventoryById(commodity.getCommodityId(), commodity.getInventory());
            int ifUpdatePrice = commodityDao.updateCommodityPrizeById(commodity.getCommodityId(), commodity.getPrize());
            return (ifUpdateInvent + ifUpdatePrice == 2) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生购物
    public int purchase(int studentID, int commodityID) {
        Commodity commodity;
        Student student;
        try {
            student = studentDao.queryStudentByStudentID(studentID);
            commodity = commodityDao.queryCommodityById(commodityID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        if (commodity.getInventory() != 0 && student.getBalance() - commodity.getPrize() >= 0) {
            try {
                studentDao.updateBalanceByStudentID(student.getStudentId(), student.getBalance() - commodity.getPrize());
                commodityDao.updateCommodityInventoryById(commodity.getCommodityId(), commodity.getInventory() - 1);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    //管理员获取某个商品信息
    public Commodity getCommodityById(int id) {
        try {
            return commodityDao.queryCommodityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //管理员添加商品信息
    public int addCommodity(Commodity comm) {
        try {
            return commodityDao.insertCommodity(comm);
        } catch (DataIntegrityViolationException dE) {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生获取所有商品的信息
    public List<Commodity> getCommodity() {
        try {
            return commodityDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}