package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Commodity {
    private int commodityId;
    private String commodityName;
    private int prize;
    private int inventory;

    public int getCommodityId() { return commodityId; }

    public void setCommodityId(int commodityId) { this.commodityId = commodityId; }

    public String getCommodityName() { return commodityName; }

    public void setCommodityName(String commodityName) { this.commodityName = commodityName; }

    public int getPrize() { return prize; }

    public void setPrize(int prize) { this.prize = prize; }

    public int getInventory() { return inventory; }

    public void setInventory(int inventory) { this.inventory = inventory; }
}
