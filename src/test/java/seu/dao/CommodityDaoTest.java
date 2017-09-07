package seu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import static org.junit.Assert.*;

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
        queryAllTest();
    }

    @Test
    public void deleteCommodityByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        queryAllTest();
    }

    @Test
    public void updateCommodityInventoryByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        queryAllTest();
    }

    @Test
    public void updateCommodityPrizeByIdTest() throws Exception {
        queryAllTest();
        //To-Do!!!!!!
        queryAllTest();
    }

    @Test
    public void queryNameByIdTest() throws Exception {
    }

    @Test
    public void queryCommodityByIdTest() throws Exception {
    }

    @Test
    public void queryAllTest() throws Exception {
    }

}