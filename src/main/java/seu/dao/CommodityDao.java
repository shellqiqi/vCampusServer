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

    public int insertCommodity(final Commodity commodity){
        final String sql = "INSERT INTO Commodity(CommodityID,CommodityName,Prize,Inventory) VALUES(?,?,?,?)";
        Object[] params = new Object[] {commodity.getCommodityId(), commodity.getCommodityName(),commodity.getPrize(),commodity.getInventory()};
        return jdbcTemplate.update(sql, params );
    }

    public int insertCommodity(final int id, final String name, final int prize, final int inventory ){
        final String sql = "INSERT INTO Commodity(CommodityID,CommodityName,Prize,Inventory) VALUES(?,?,?,?)";
        Object[] params = new Object[] {id, name,prize,inventory};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteCommodityById(final int id){
        final String sql = "DELETE FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateCommodityInventoryById(final int id, final int inventory){
        final String sql = "UPDATE Commodity SET Inventory = ? WHERE CommodityID = ?";
        Object[] params = new Object[] {inventory,id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateCommodityPrizeById(final int id, final int prize){
        final String sql = "UPDATE Commodity SET Prize = ? WHERE CommodityID = ?";
        Object[] params = new Object[] {prize,id};
        return jdbcTemplate.update(sql, params);
    }

    public String queryNameById(final int id) {
        final String sql = "SELECT CommodityName FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    public Commodity queryCommodityById(final int id) {
        final String sql = "SELECT * FROM Commodity WHERE CommodityID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params, new CommodityMapper());
    }

    public List<Commodity> queryAll(){
        final String sql = "SELECT * FROM Commodity" ;
        return jdbcTemplate.query(sql, new CommodityMapper());
    }

    private static final class CommodityMapper implements RowMapper<Commodity> {
        @Override
        public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Commodity(
                    rs.getInt("CommodityID"),
                    rs.getString("CommodityName"),
                    rs.getInt("Prize"),
                    rs.getInt("Iventory")
            );
        }
    }
}
