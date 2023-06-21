package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem { 	//some of the properties 

    private int oi_id;
    private int oder_id; 
    private String product_name;
    private String size_name;
    private String color_name;

    private int product_quantity; 

}

