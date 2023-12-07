package ca.sheridancollege.yoojiw.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.beans.Product;
import ca.sheridancollege.yoojiw.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc; 
	
	
	public List<Student> getAllStudents() {
		
		String sql = "SELECT * FROM students";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		List<Student> rows =  jdbc.query(sql, params, new BeanPropertyRowMapper<Student>(Student.class)); 
		
		if(rows.isEmpty()) {
			
			System.out.println("no student");
			
			return null; 
		}else {
			
			return rows; 
		}
	}
	
	
	public Student getOneStudentById(int id) {
		
		String sql = "SELECT * FROM students WHERE id = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("id", id); 
		
		List<Student> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<Student>(Student.class)); 
		
		if(rows.isEmpty()) {
			
			System.out.println("no such a student");
			
			return null; 
		}else {
			
			return rows.get(0); 
		}	
	}
	
	
	

	
}
