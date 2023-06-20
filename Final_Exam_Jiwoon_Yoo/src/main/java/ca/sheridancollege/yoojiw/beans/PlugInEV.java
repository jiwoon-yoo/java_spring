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
public class PlugInEV{
	
	private int id; 
	private String vehiculemake; 
	private String vehiculemodel;
	private String enginetype;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate purchaseDate;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime purchaseTime; 

}
