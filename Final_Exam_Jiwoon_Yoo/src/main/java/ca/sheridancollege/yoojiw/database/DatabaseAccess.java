package ca.sheridancollege.yoojiw.database;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.beans.PlugInEV;
import ca.sheridancollege.yoojiw.beans.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;		//

	public User findUserAccount(String email) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where email=:email";
		parameters.addValue("email", email);
		List<User> users = (ArrayList<User>) jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));

		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	
	public List<String> getRolesById(Long userId) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select user_role.userId, sec_role.roleName "
				+ "FROM user_role, sec_role "
				+ "WHERE user_role.roleId=sec_role.roleId "
				+ "AND userId=:userId";
		
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

		for (Map<String, Object> row : rows) {
			roles.add((String) row.get("roleName"));
		}
		
		return roles;	//
	}

	
	
	
	
	
	
	
	
	
	
	
	//insert one each row to the database 
		public void insertOnePlugInEV(PlugInEV pluginev) {
			
			String sql = "INSERT INTO pluginev(vehiculemake, vehiculemodel, enginetype, purchaseDate, purchaseTime) VALUES(:vehiculemake, :vehiculemodel, :enginetype, :purchaseDate, :purchaseTime)"; 
			
			MapSqlParameterSource params = new MapSqlParameterSource(); 
			
//			params.addValue("id", appointment.getId());
			params.addValue("vehiculemake", pluginev.getVehiculemake());
			params.addValue("vehiculemodel", pluginev.getVehiculemodel());
			params.addValue("enginetype", pluginev.getEnginetype()); 
			params.addValue("purchaseDate", pluginev.getPurchaseDate()); 
			params.addValue("purchaseTime", pluginev.getPurchaseTime()); 
			
			int rowsAffected = jdbc.update(sql, params); 
			
			if (rowsAffected > 0)
				System.out.println("Inserted pluginev into database.");
		}
		
		
		//read all the rows 
		public List<PlugInEV> readAllPlugInEV(){
			
			String sql = "SELECT * FROM pluginev";
			
			List<PlugInEV> rows = jdbc.query(sql, new BeanPropertyRowMapper<PlugInEV>(PlugInEV.class));
			
			return rows; 
		}
		
		
		//delete one player
		public void deleteOnePlugInEV(int id) {
			
			String sql = "DELETE FROM pluginev WHERE id = :id";
			
			MapSqlParameterSource params = new MapSqlParameterSource(); 
			
			params.addValue("id", id); 
			
			int rowsAffected = jdbc.update(sql, params); 
			
			if (rowsAffected > 0)
				System.out.println("Deleted pluginev " + id + " from database");
			
		}
		
		
		//read one row(Player)
		public PlugInEV readOnePlugInEV(int id) {
			
			String sql = "SELECT * FROM pluginev WHERE id = :id";
			
			MapSqlParameterSource params = new MapSqlParameterSource(); 
			
			params.addValue("id", id);
			
			List<PlugInEV> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<PlugInEV>(PlugInEV.class)); 
			
			if(rows.size() > 0) {
				
				return rows.get(0); 
			}else {
				
				return null; 
			}
			
		}
	
	
	
}