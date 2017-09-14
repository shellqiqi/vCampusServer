package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CommodityDao;
import seu.dao.StudentDao;
import seu.domain.Commodity;
import seu.domain.Student;

import java.util.List;
@Service
public class ShopService {
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    StudentDao studentDao;

    public CommodityDao getCommodityDao() {
        return commodityDao;
    }

    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    //学生获取某个商品信息
    public Commodity getCommodityById(int id) {
        return commodityDao.queryCommodityById(id);
    }

    //学生获取所有商品的信息
    public List<Commodity> getCommodity() {
        return commodityDao.queryAll();
    }

    //学生购物
    public int Shopping(Student student, Commodity commodity) {
        if (commodity.getInventory() != 0 && student.getBalance() - commodity.getPrize() >= 0) {
            if (studentDao.updateBalanceByStudentID(student.getStudentId(), student.getBalance() - commodity.getPrize()) == 1 && commodityDao.updateCommodityInventoryById(commodity.getCommodityId(), commodity.getInventory() - 1) == 1)
                return 1;
            else
                return 0;
        } else
            return 0;
    }
}