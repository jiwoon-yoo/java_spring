package ca.sheridancollege.yoojiw.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.benas.Student;
import ca.sheridancollege.yoojiw.benas.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc; 
	
	
	//
	public User getUserByUsername(String username) {
		
		String sql = "SELECT * FROM users WHERE username = :username";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("username", username); 
		
		List<User> users =    jdbc.query(sql, params, new BeanPropertyRowMapper<User>(User.class)); 
		
		if(!users.isEmpty()) {
			
			return users.get(0); 
		}else {
			
			System.out.println("error");
			
			return null; 
		}
	}
	
	public List<String> getAllRolesByUserId(int userId) {
		
		String sql = "SELECT roleName FROM roles r INNER JOIN user_role ur ON r.roleId = ur.roleId WHERE ur.userId = :userId";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("userId", userId); 
		
		List<String> rows =  jdbc.queryForList(sql, params, String.class);
		
		if(!rows.isEmpty()) {
			
			return rows; 
		}else {
			
			System.out.println("error");
			
			return null; 
		}
	}
	
	public void addUser(String username, String password) {
		
		String sql = "INSERT INTO users(username, password) VALUES(:username, :password)";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("username", username); 
		params.addValue("password", password);
		
		jdbc.update(sql, params); 
	}
	
	public int getUserIdByUsername(String username) {
		
		String sql = "SELECT userId FROM users WHERE username = :username";
		 
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("username", username); 
		
		int userId =  jdbc.queryForObject(sql, params, Integer.class);
		
		return userId; 
	}
	
	public void addUser_role(int userId, int roleId) {
		
		String sql = "INSERT INTO user_role(userId, roleId) VALUES(:userId, :roleId)"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("userId", userId); 
		params.addValue("roleId", roleId);
		
		jdbc.update(sql, params); 
		
	}
	
	
	
	//
	public Student getStudentById(int studentId) {
		
		String sql = "SELECT * FROM students WHERE studentId = :studentId";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("studentId", studentId); 
		
		List<Student> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<Student>(Student.class)); 
	
		if(!rows.isEmpty()) {
			
			return rows.get(0); 
		}else {
			
			System.out.println("error");
			
			return null; 	
		}
	}
	
	public List<Student> getAllStudent(){
		
		String sql = "SELECT * FROM students";
		
		List<Student> rows = jdbc.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
		
		if(!rows.isEmpty()) {
			
			return rows; 
		}else {
			
			System.out.println("error");
			
			return null; 
		}
	}
	
	public int addStudent(Student student) {
		
		String sql = "INSERT INTO students(name) VALUES(:name)"; 
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("name", student.getName()); 
		
		
		jdbc.update(sql, params, keyHolder); 
		
		return (int) keyHolder.getKey(); 
	}
	
	public int addStudents(List<Student> students) {
		
		int count = 0 ;
		
		for(Student i : students) {
			
			if(addStudent(i) > 0) {
				count++; 
			}
		}
		
		return count; 
	}
	
	public int updateStudent(int studentId, Student student) {
		
		String sql = "UPDATE students SET name = :name WHERE studentId = :studentId";
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("name", student.getName()); 
		params.addValue("studentId", studentId); 
		
		jdbc.update(sql, params, keyHolder);
		
		return (int) keyHolder.getKey(); 
	}
	
	public boolean deleteStudent(int studentId) {
		String sql = "DELETE FROM students WHERE studentId = :studentId";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("studentId", studentId); 
		
		int rowsAffected =   jdbc.update(sql, params); 
		
		return rowsAffected > 0; 
	}
	
}
