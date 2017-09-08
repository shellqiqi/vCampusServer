package seu.service;

import org.springframework.stereotype.Service;
import seu.dao.CommodityDao;
import seu.domain.Commodity;

import java.util.List;
@Service
public class ShopService {
    CommodityDao commodityDao;


    public CommodityDao getCommodityDao() {
        return commodityDao;
    }

    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    //添加商品信息
    public int addCommodity(Commodity comm){
        if(commodityDao.queryCommodityById(comm.getCommodityId()) == null)
            return commodityDao.insertCommodity(comm);
        else
            return 0;
    }

    public int addCommodity(int id, String name, int prize, int inventory ){
        if(commodityDao.queryCommodityById(id) == null)
            return commodityDao.insertCommodity(id,name,prize,inventory);
        else
            return 0;
    }

    //删除商品信息
    public int deleteCommodityById(int id){
        return commodityDao.deleteCommodityById(id);
    }

    //更改商品库存
    public int changeInventoryById(int id,int inventory){
        return commodityDao.updateCommodityInventoryById(id, inventory);
    }

    //更改商品价格
    public int changePriceById(int id, int price){
        return commodityDao.updateCommodityPrizeById(id, price);
    }

    public String getCommodityNameById(int id){
        return commodityDao.queryNameById(id);
    }

    public List<Commodity> getCommodityById(int id){
        return commodityDao.queryCommodityById(id);
    }

    public List<Commodity> getCommodity(){
        return commodityDao.queryAll();
    }
}
