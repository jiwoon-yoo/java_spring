package ca.sheridancollege.yoojiw.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {

	private int id;
	private String manufacturer; 
	private String country;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate shippingDate;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime shippingTime;
	
	
	
}


