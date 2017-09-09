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


    public int insertDormitory(final Dormitory dormitory) {
        final String sql = "INSERT INTO Dormitory(DormitoryId,Score) VALUES(?,?)";
        Object[] params = new Object[]{dormitory.getDormitoryId(), dormitory.getScore()};
        return jdbcTemplate.update(sql, params);
    }

    public int insertDormitory(final int DormitoryID, final int Score) {
        final String sql = "INSERT INTO Dormitory(DormitoryId,Score) VALUES(?,?)";
        Object[] params = new Object[]{DormitoryID, Score};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteDormitoryByID(final int DormitoryID) {
        final String sql = "DELETE FROM Dormitory WHERE DormitoryID = ?";
        Object[] params = new Object[]{DormitoryID};
        return jdbcTemplate.update(sql, params);
    }

    public int updateScoreByID(final int DormitoryID, final int Score) {
        final String sql = "UPDATE Dormitory SET Score = ? WHERE DormitoryId = ?";
        Object[] params = new Object[]{Score, DormitoryID};
        return jdbcTemplate.update(sql, params);
    }

    public int queryScoreByDormitoryID(final int DormitoryID) {
        final String sql = "SELECT Score FROM Dormitory WHERE DormitoryId = ?";
        Object[] params = new Object[]{DormitoryID};
        return jdbcTemplate.queryForObject(sql, params, int.class);
    }

    public Dormitory queryDormitoryByStudentId(final int studentId){
        final String sql = "SELECT * FROM Dormitory INNER JOIN Student ON Student.DormitoryId = Dormitory.DormitoryId " +
                "WHERE Student.StudentId = ?";
        Object[] params = new Object[]{studentId};
        return jdbcTemplate.queryForObject(sql, params, new DormitoryMapper());
    }


    public List<Dormitory> queryAll() {
        final String sql = "SELECT * FROM Dormitory";
        return jdbcTemplate.query(sql, new DormitoryMapper());
    }

    private static final class DormitoryMapper implements RowMapper<Dormitory> {
        @Override
        public Dormitory mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Dormitory(
                    rs.getInt("DormitoryId"),
                    rs.getInt("Score")
            );

        }
    }
}