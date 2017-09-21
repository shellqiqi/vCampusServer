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

    /**
     *设置学生DAO
     * @param studentDao 输入学生DAO
     */
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     *设置商品DAO
     * @param commodityDao 输入商品DAO
     */
    @Autowired
    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    /**
     *更新商品价格
     * @param commodityID 商品ID
     * @param price 商品新价格
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updatePrice(int commodityID, int price) {

        try {
            return commodityDao.updateCommodityPrizeById(commodityID, price);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *更新商品库存
     * @param commodityID 商品ID
     * @param price 商品价格
     * @return 更新成功返回1，不成功返回0，异常返回-1
     */
    public int updateInventory(int commodityID, int price) {
        try {
            return commodityDao.updateCommodityInventoryById(commodityID, price);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *通过商品对象更新商品
     * @param commodity 输入商品对象
     * @return 更新商品价格以及库存成功返回1，存在更新失败返回0，异常返回-1
     */
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

    /**
     *购买商品
     * @param studentID 购买学生的ID
     * @param commodityID 所购买商品的ID
     * @return 购买成功返回1，不成功返回0，异常返回-1
     */
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

    /**
     *通过商品ID找商品
     * @param id 商品ID
     * @return 查询商品成功返回商品对象，不成功或异常返回null
     */
    public Commodity getCommodityById(int id) {
        try {
            return commodityDao.queryCommodityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *通过商品对象增加商品
     * @param comm 增加的商品对象
     * @return 增加商品成功返回1，增加商品已存在则触发异常但返回1，不成功返回0，异常返回-1
     */
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


    /**
     *
     * @return 查询成功返回商品的LIST，异常返回null
     */
    public List<Commodity> getCommodity() {
        try {
            return commodityDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}