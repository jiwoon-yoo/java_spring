package ca.sheridancollege.yoojiw.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.bean.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc; 
	
	

	public User getUserByUsername(String username) {
		
		String sql = "SELECT * FROM users WHERE username = :username"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", username); 
		
		User user = jdbc.query(sql, params, new BeanPropertyRowMapper<User>(User.class)).get(0);
		
		return user; 	
	}
	
	public List<String> getAllRolesByUserId(int userId) {
		
		String sql = "SELECT roleName FROM users u INNER JOIN user_role ur ON u.userId = ur.userId INNER JOIN roles r ON r.roleId = ur.roleId WHERE u.userId = :userId";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("userId", userId);
		
		List<String> roles =  jdbc.queryForList(sql, params, String.class); 
		
		
		return roles; 
	}
	
	
	
	public void insertOneUser(String username, String password) {
		
		String sql = "INSERT INTO users(username, password) VALUES(:username, :password)"; 

		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("username", username)
			.addValue("password", password); 
		
		jdbc.update(sql, params); 
	}
	
	public void insertUserRole(int userId) {
		
		//role - USER account 
		String sql  = "INSERT INTO user_role(userId, roleId) VALUES(:userId, 2)"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("userId", userId); 
		
		jdbc.update(sql, params); 
		
	}
	
	
	public int getUserIdByUsername(String username) {
		
		String sql = "SELECT userId FROM users WHERE username = :username"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("username", username); 
		
		int userId  =   jdbc.queryForObject(sql, params, Integer.class); 
		
		
		return userId; 
	}
}
