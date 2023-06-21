package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Image {	//inner joing table 

	private int product_id; 
	private String product_name; 
	private double product_price; 
	private String product_description; 	
	private int image_id; 
	private int color_id; 
	private String image_url; 
	
	
	
}
