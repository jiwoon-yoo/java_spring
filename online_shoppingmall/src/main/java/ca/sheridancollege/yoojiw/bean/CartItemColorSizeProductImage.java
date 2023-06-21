package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemColorSizeProductImage {		//cartItem & size & color tables & product tables inner join 

	private int ci_id; 
	private int cart_id; 
	private int product_id; 
	private int size_id; 
	private int color_id; 
	private int enabled = 2; 
	
	private String product_name; 
	private double product_price; 
	private String description; 
	
	private String size_name; 
	
	private String color_name; 
	
	private int image_id; 	//
	private String image_url;
	
	
}
