package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;

import seu.domain.Commodity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class CommodityDaoTest {
    @Autowired
    CommodityDao commodityItem;

    @Test
    public void insertCommodityTest() throws Exception {
        queryAllTest();
        Commodity Item = new Commodity(1,"一号商品",10,100);
        System.out.println(commodityItem.insertCommodity(Item));
        queryAllTest();
    }

    @Test
    public void insertCommodityTest1() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        int Id = 2; String name = "2号商品"; int prize = 20; int inventory = 200;
        System.out.println(commodityItem.insertCommodity(Id,name,prize,inventory));
        queryAllTest();
    }

    @Test
    public void deleteCommodityByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        System.out.println(commodityItem.deleteCommodityById(2));
        queryAllTest();
    }

    @Test
    public void updateCommodityInventoryByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        System.out.println(commodityItem.updateCommodityInventoryById(1,150));
        queryAllTest();
    }

    @Test
    public void updateCommodityPrizeByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        System.out.println(commodityItem.updateCommodityPrizeById(1,15));
        queryAllTest();
    }

    @Test
    public void queryNameByIdTest() throws Exception {
        System.out.println(commodityItem.queryNameById(1));
    }

    @Test
    public void queryCommodityByIdTest() throws Exception {
        System.out.println(commodityItem.queryCommodityById(2));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(commodityItem.queryAll());
    }

}