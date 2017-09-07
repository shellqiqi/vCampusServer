package seu.dao;

import org.springframework.jdbc.core.RowMapper;
import seu.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommodityDao {//TODO: Create Test

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCommodity(final Commodity commodity){
        final String sql = "INSERT INTO Commodity(CommodityID,CommodityName,Prize,Inventory) VALUES(?,?,?,?)";
        Object[] params = new Object[] {commodity.getCommodityId(), commodity.getCommodityName(),commodity.getPrize(),commodity.getInventory()};
        jdbcTemplate.update(sql, params);
    }

    public void addCommodity(final int id, final String name, final int prize, final int inventory ){
        final String sql = "INSERT INTO Commodity(CommodityID,CommodityName,Prize,Inventory) VALUES(?,?,?,?)";
        Object[] params = new Object[] {id, name,prize,inventory};
        jdbcTemplate.update(sql, params);
    }

    public void deleteCommodityById(final int id){
        final String sql = "DELETE FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        jdbcTemplate.update(sql, params);
    }

    public void deleteCommodityByName(final String name){
        final String sql = "DELETE FROM Commodity WHERE CommodityName = ?";
        Object[] params = new Object[] {name};
        jdbcTemplate.update(sql, params);
    }

    public void updateCommodityInventoryById(final int id, final int inventory){
        final String sql = "UPDATE Commodity SET Inventory = ? WHERE CommodityID = ?";
        Object[] params = new Object[] {id, inventory};
        jdbcTemplate.update(sql, params);
    }

    public void updateCommodityPrizeById(final int id, final int prize){
        final String sql = "UPDATE Commodity SET Prize = ? WHERE CommodityID = ?";
        Object[] params = new Object[] {id, prize};
        jdbcTemplate.update(sql, params);
    }

    public String queryNameById(final int id) {
        final String sql = "SELECT CommodityName FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public List<Commodity> queryCommodityById(final int id) {
        final String sql = "SELECT * FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        return (List<Commodity>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Commodity(rs.getInt("CommodityID"), rs.getString("CommodityName")
                        ,rs.getInt("CommodityPrize"), rs.getInt("Inventory"));
            }
        });
    }
}
