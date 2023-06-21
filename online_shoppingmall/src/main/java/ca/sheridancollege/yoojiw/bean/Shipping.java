package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {
	
    private int shipping_id;
    private String address_line1;
    private String address_line2;
    private String city;
    private String state;
    private String postal_code;
    private String phone_number;
    private int user_id;
    private int order_id;
    
    
}
