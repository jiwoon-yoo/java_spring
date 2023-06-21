package ca.sheridancollege.yoojiw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

	private int image_id; 
	private int product_id; 
	private int color_id;
	private String image_url; 
	
	
}
