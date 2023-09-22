package ca.sheridancollege.yoojiw.database;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc; 
	
	
	//return all students 
	public List<Student> getAllStudents() {
		
		String sql = "SELECT * FROM students";
		
		List<Student> rows = jdbc.query(sql, new BeanPropertyRowMapper<Student>(Student.class)); 
		
		return rows;
	}
 
	
	public Student getOneStudentById(int id) {
		
		String sql= "SELECT * FROM students WHERE id = :id";
		
		MapSqlParameterSource params= new MapSqlParameterSource(); 
		
		params.addValue("id", id);
		
		Student st = jdbc.query(sql, params, new BeanPropertyRowMapper<Student>(Student.class)).get(0); 
		
		return st;
	}
	
	public int insertOneStudent(Student st) {
		
		String sql = "INSERT INTO students(name, age, attended) VALUES(:name, :age, :attended)";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		KeyHolder keyholder = new GeneratedKeyHolder(); 
		
		params.addValue("name", st.getName());
		params.addValue("age", st.getAge());
		params.addValue("attended", st.isAttended());	//is 

		jdbc.update(sql, params, keyholder);
		
		return (int)keyholder.getKey(); 	
	}
	
	public void insertStudents(List<Student> students) {		
		
		for(Student i : students) {
			insertOneStudent(i); 
		}
	}
	
	public void deleteAllStudents() {
		
		String sql = "DELETE FROM students";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		jdbc.update(sql, params); 
	}
	
	public int countAllStudents() {
		
		String sql = "SELECT COUNT(*) FROM students";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		int countRow = jdbc.queryForObject(sql, params, Integer.TYPE); 
		
		return countRow; 
	}
}
