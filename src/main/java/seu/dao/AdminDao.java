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
        Object[] params = new Object[] {id, password};
        return jdbcTemplate.update(sql, params);
    }

    public List<Admin> queryAll(){
        final String sql = "SELECT * FROM Admin" ;
        return (List<Admin>)jdbcTemplate.query(sql, new RowMapper() {
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Admin(rs.getInt("AdminID"), rs.getString("Password")
                );
            }
        });
    }
}
