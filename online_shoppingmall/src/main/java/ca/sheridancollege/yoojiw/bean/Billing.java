package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    private int billing_id;
    private String card_number;
    private String cardholder_name;
    private String expiration_date;
    private String cvc;
    private int user_id;
    private int order_id;
}
