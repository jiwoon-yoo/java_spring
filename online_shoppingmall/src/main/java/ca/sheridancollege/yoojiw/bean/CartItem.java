package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

	private int cart_id; 
	
	private int product_id; 
	private int size_id; 
	private int color_id; 
	
	private boolean enable = true; 	//////
	
	
}
