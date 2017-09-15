package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Commodity implements Serializable {
    private int commodityId;
    private String commodityName;
    private int prize;
    private int inventory;

    public Commodity() {
        super();
    }

    public Commodity(int id, String name, int prize, int inventory) {
        this.setCommodityId(id);
        this.setCommodityName(name);
        this.setPrize(prize);
        this.setInventory(inventory);
    }


    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Commodity{" + "commodityId=" + commodityId + ", commodityName='" + commodityName + '\'' + ", prize=" + prize + ", inventory=" + inventory + '}';
    }
}
