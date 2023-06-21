package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {

	private int color_id; 
	private String color_name; 
	private String color_hex; 
	
}
