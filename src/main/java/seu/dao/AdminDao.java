package seu.dao;

import seu.domain.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertAdmin(final Admin admin){
        final String sql = "INSERT INTO Admin(AdminID,Password) VALUES(?,?)";
        Object[] params = new Object[]{admin.getAdminId(),admin.getPassword()};
        return jdbcTemplate.update(sql, params );
    }

    public int insertAdmin(final int id, final String password){
        final String sql = "INSERT INTO Admin(AdminID,Password) VALUES(?,?)";
        Object[] params = new Object[] {id,password};
        return jdbcTemplate.update(sql, params);
    }

    public int deleteAdminById(final int id){
        final String sql = "DELETE FROM Admin WHERE AdminID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateAdminPasswordById(final int id, final String password){
        final String sql = "UPDATE Admin SET Password = ? WHERE AdminID = ?";
        Object[] params = new Object[] {password,id};
        return jdbcTemplate.update(sql, params);
    }

    public int updateAdminByAdminID(Admin admin)
    {
        final String sql = "UPDATE Admin SET Password = ? WHERE AdminID = ?";
        Object[] params = new Object[] {admin.getPassword(),admin.getAdminId()};
        return jdbcTemplate.update(sql, params);
    }

    public Admin queryAdminById(final int id){
        final String sql = "SELECT * FROM Admin WHERE AdminID = ?";
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject(sql, params ,new AdminMapper());
    }

    public List<Admin> queryAll(){
        final String sql = "SELECT * FROM Admin" ;
        return jdbcTemplate.query(sql, new AdminMapper());
    }

    private static final class AdminMapper implements RowMapper<Admin> {
        @Override
        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Admin(
                    rs.getInt("AdminID"),
                    rs.getString("Password")
            );
        }
    }
}
