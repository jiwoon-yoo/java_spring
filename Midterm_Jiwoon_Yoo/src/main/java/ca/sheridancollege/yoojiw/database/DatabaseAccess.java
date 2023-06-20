package ca.sheridancollege.yoojiw.database;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.beans.Manufacturer;


@Repository
public class DatabaseAccess {

	@Autowired
	public NamedParameterJdbcTemplate jdbc; 
	
	
	//insert one row to the database 
	public void insertOneManufacturer(Manufacturer manufacturer) {
		
		String sql = "INSERT INTO manufacturers(manufacturer, country, email, shippingDate, shippingTime) VALUES(:manufacturer, :country, :email, :shippingDate, :shippingTime)"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
//		params.addValue("id", appointment.getId());
		params.addValue("manufacturer", manufacturer.getManufacturer());
		params.addValue("country", manufacturer.getCountry());
		params.addValue("email", manufacturer.getEmail());
		params.addValue("shippingDate", manufacturer.getShippingDate()); 
		params.addValue("shippingTime", manufacturer.getShippingTime()); 
		
		int rowsAffected = jdbc.update(sql, params); 
		
		if (rowsAffected > 0)
			System.out.println("Inserted manufacturer into database.");
	}
	
	
	//read all the rows 
	public List<Manufacturer> readAllManufacturer(){
		
		String sql = "SELECT * FROM manufacturers";
		
		List<Manufacturer> rows = jdbc.query(sql, new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));
		
		return rows; 
	}
	
	
	//delete one player
	public void deleteOneManufacturer(int id) {
		
		String sql = "DELETE FROM manufacturers WHERE id = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("id", id); 
		
		int rowsAffected = jdbc.update(sql, params); 
		
		if (rowsAffected > 0)
			System.out.println("Deleted manufacturer " + id + " from database");
		
	}
	
	
	//read one row(Player)
	public Manufacturer readOneManufacturer(int id) {
		
		String sql = "SELECT * FROM manufacturers WHERE id = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 	//
		
		params.addValue("id", id);
		
		List<Manufacturer> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class)); 
		
		if(rows.size() > 0) {
			
			return rows.get(0); 
		}else {
			
			return null; 
		}
		
	}
	
	
	
}
