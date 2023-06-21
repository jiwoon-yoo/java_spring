package ca.sheridancollege.yoojiw.bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {		//order with orderItem with users 

	private int oi_id; 
	private int order_id;
    private int user_id;
    private LocalDateTime orderDate;		//compatible 
    private double totalAmount;
    private String status;
	
    
    private String product_name; 
    private String size_name; 
    private String color_name; 
    private int product_quantity; 
    private double product_price; 
    private String image_url; 
    
    
    private String user_name; 
	
}



