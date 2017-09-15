package seu.service;

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
public class ShopServiceTest {


    @Autowired
    private ShopService shopService;
    @Test
    public void updatePrice() throws Exception {
        System.out.println(shopService.updatePrice(3,89));
    }

    @Test
    public void updateInventory() throws Exception {
        System.out.println(shopService.updateInventory(3,997));
    }

    @Test
    public void updateCommodity() throws Exception {
        System.out.println(shopService.updateCommodity(new Commodity(3,"3",36,998)));
    }

    @Test
    public void purchase() throws Exception {
        System.out.println(shopService.purchase(9,1));
    }

    @Test
    public void getCommodityById() throws Exception {
        System.out.println(shopService.getCommodityById(2));
    }

    @Test
    public void addCommodity() throws Exception {
        System.out.println(shopService.addCommodity(new Commodity(4,"3号商品",20,200)));
    }

    @Test
    public void getCommodity() throws Exception {
        System.out.println(shopService.getCommodityById(3).toString());
    }

}