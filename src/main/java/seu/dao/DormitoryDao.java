package seu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import seu.domain.Dormitory;

@Repository
public class DormitoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addDormitory(final Dormitory dormitory) {
        final String sql = "INSERT INTO Dormitory(DormitoryId,Score) VALUES(?,?)";
        Object[] params = new Object[]{dormitory.getDormitoryId(), dormitory.getScore()};
        jdbcTemplate.update(sql, params);
    }

    public void addDormitory(final int DormitoryID, final int Score) {
        final String sql = "INSERT INTO Dormitory(DormitoryId,Score) VALUES(?,?)";
        Object[] params = new Object[]{DormitoryID, Score};
        jdbcTemplate.update(sql, params);
    }

    public void deleteDormitoryByID(final int DormitoryID) {
        final String sql = "DELETE FROM Dormitory WHERE ID = ?";
        Object[] params = new Object[]{DormitoryID};
        jdbcTemplate.update(sql, params);
    }

    public void updateScoreByID(final int DormitoryID, final int Score) {
        final String sql = "UPDATE Dormitory SET Score = ? WHERE DormitoryId = ?";
        Object[] params = new Object[]{Score, DormitoryID};
        jdbcTemplate.update(sql, params);
    }

    public String queryScoreByDormitoryID(final int DormitoryID) {
        final String sql = "SELECT Score FROM Domitory WHERE DormitoryId = ?";
        Object[] params = new Object[]{DormitoryID};
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @SuppressWarnings("unchecked")
    public List<Dormitory> queryDormitoryByDormitoryID(final String DormitoryId) {
        final String sql = "SELECT * FROM Dormitory WHERE DorymitoryId = ?";
        Object[] params = new Object[] {DormitoryId};
        return (List<Dormitory>)jdbcTemplate.query(sql, params, new RowMapper() {
            public Dormitory mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Dormitory(rs.getInt("DormitoryId"), rs.getInt("Score"));
            }
        });
    }
}