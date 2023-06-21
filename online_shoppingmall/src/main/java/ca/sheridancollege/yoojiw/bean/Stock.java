package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {		//stock with product with color with size 

	private int product_id; 
	private int size_id; 
	private int color_id; 
	private int stock_quantity; 
	
	private String product_name; 
	private String color_name; 
	private String size_name; 
	
	
}


