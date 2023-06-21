package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Color {	//product with color with category 

	private int product_id; 
	private String product_name; 
	private double product_price; 
	private String product_description; 	
	private int color_id; 
	private String color_name; 
	private String color_hex; 
	
	
	private int category_id; 
	private String category_name; 
	
}




