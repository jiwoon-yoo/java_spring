package ca.sheridancollege.yoojiw.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import ca.sheridancollege.yoojiw.bean.Order;
import ca.sheridancollege.yoojiw.bean.OrderItem;

import java.math.BigDecimal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.bean.Billing;
import ca.sheridancollege.yoojiw.bean.CartItemColorSizeProductImage;
import ca.sheridancollege.yoojiw.bean.Category;
import ca.sheridancollege.yoojiw.bean.Color;
import ca.sheridancollege.yoojiw.bean.Image;
import ca.sheridancollege.yoojiw.bean.Product_Color;
import ca.sheridancollege.yoojiw.bean.Product_Image;
import ca.sheridancollege.yoojiw.bean.Shipping;
import ca.sheridancollege.yoojiw.bean.Stock;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc; 
	
	

	public List<Product_Color> getAllProductsOfAllColors() {
		
		String sql = "SELECT * FROM product p INNER JOIN product_color pc ON p.product_id = pc.product_id    INNER JOIN product_category pca ON pc.product_id = pca.product_id INNER JOIN category c ON pca.category_id = c.category_id";
		
		List<Product_Color> rows = jdbc.query(sql, new BeanPropertyRowMapper<>(Product_Color.class)); 
		
		if(rows.size() > 0) {
			
			return rows; 
		}else {
			
			return null; 	/////
		}
	}
	
	
	
	
	public List<Product_Color> getOneProductsOfAllColors(int product_id) {
		
		String sql = "SELECT * FROM product p INNER JOIN product_color pc ON p.product_id = pc.product_id INNER JOIN color c ON pc.color_id = c.color_id WHERE p.product_id = :product_id";
		
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("product_id", product_id); 
		
		List<Product_Color> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Product_Color.class)); 
		
		if(rows.size() > 0) {
			
			return rows; 
		}else {
			
			return null; 	/////
		}
	}
	
	//retrieve one main image for the showcase page 
	public Image readOneImage(int product_id, int color_id) {
		
		String sql = "SELECT * FROM image WHERE product_id = :product_id AND color_id = :color_id"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("product_id", product_id); 
		params.addValue("color_id", color_id); 
		
		List<Image> images = jdbc.query(sql, params, new BeanPropertyRowMapper<Image>(Image.class)); 
		
		if(images.size() > 0) {
			
			return images.get(0); 
		}else {
			
			return null; 	/////
		}
	}
	
	
	//product with the particular color 
	public List<Product_Image> getOneProductByColorIdWithMultipleImages(int product_id, int color_id) {
		
		String sql = "SELECT * FROM product p INNER JOIN image i ON p.product_id = i.product_id WHERE i.product_id = :product_id AND  i.color_id = :color_id"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		
		params.addValue("product_id", product_id); 
		params.addValue("color_id", color_id); 
		
		List<Product_Image> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Product_Image.class)); 

		
		if(rows.size() > 0) {
			
			return rows; 
		}else {
			
			return null; 	/////
		}
	}
	
	
	public List<Stock> getStocksByProductId(int product_id, int color_id) {
		
		String sql = "SELECT * FROM stock WHERE product_id = :product_id AND color_id = :color_id "; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("product_id", product_id); 
		params.addValue("color_id", color_id); 
		
		List<Stock> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Stock.class)); 
		
		
		return rows; 
	}
	
	public List<Stock> getStocksByProductId2(int product_id, int color_id, int size_id) {
		
		String sql = "SELECT * FROM stock WHERE product_id = :product_id AND color_id = :color_id AND size_id = :size_id"; 
		
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("product_id", product_id); 
		params.addValue("color_id", color_id); 
		params.addValue("size_id", size_id); 
		
		List<Stock> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Stock.class)); 
		
		
		return rows; 
	}
	
       
       public int getUserIdByUserName(String user_name) {
    	   
    	   String sql = "SELECT user_id FROM users WHERE user_name = :user_name";  
    	
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_name", user_name); 
    			  
    	   List<Map<String, Object>> rows =  jdbc.queryForList(sql, params); 
    	   
    	   int user_id = 0; 
    	   
    	   for(Map<String, Object> i : rows) {
    		   
    		   user_id = (int)i.get("user_id"); 
    		   
    	   }
       
       
    	   return user_id;
       }
    	   

       //insert the user_id into the cart
       public void insertUserIdToCart(int user_id) {
    	   
    	   String sql = "INSERT INTO cart(user_id) values(:user_id)";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_id", user_id);
    	   
    	   jdbc.update(sql, params); 
       }
	
       
   	   //retrieve cart_id from the database 
       public int getCartIdByUserId(int user_id) {
    	   
    	   String sql = "Select cart_id FROM cart WHERE user_id = :user_id"; 
       
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_id", user_id);
    	   
    	   List<Map<String, Object>> rows =  jdbc.queryForList(sql, params);
    	   
    	   int cart_id = 0; 
    	   
    	   for(Map<String, Object> i : rows) {
    		   
    		    cart_id = (int)i.get("cart_id"); 
    		   
    	   }
    	   
    	   return cart_id; 
       }
       
       //
       public int getQuantityOfStock(int product_id, int size_id, int color_id) {
    	    String sql = "SELECT stock_quantity FROM stock WHERE product_id = :product_id AND size_id = :size_id AND color_id = :color_id";
    	    
    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("product_id", product_id);
    	    params.addValue("size_id", size_id);
    	    params.addValue("color_id", color_id);


    	    List<Map<String, Object>> rows = jdbc.queryForList(sql, params);

    	    int stockQuantity = 0; 
    	    
    	    for(Map<String, Object> i : rows) {
    	    	
    	    	stockQuantity = (int)i.get("stock_quantity"); 
    	    }
    	    
    	    
    	    return stockQuantity;
    	}

       
       //Store data into the cartItem table
       public void insertCartItem(int cart_id, int product_id, int size_id, int color_id) {
       
    	   String sql = "INSERT INTO cartItem (cart_id, product_id, size_id, color_id) VALUES (:cart_id, :product_id, :size_id, :color_id)";

           MapSqlParameterSource params = new MapSqlParameterSource();
           params.addValue("cart_id", cart_id);
           params.addValue("product_id", product_id);
           params.addValue("size_id", size_id);
           params.addValue("color_id", color_id);

           jdbc.update(sql, params);
           
       }


       
       //
       public int getSizeIdBySizeName(String size_name) {
    	   
    	   String sql = "SELECT size_id FROM size WHERE size_name = :size_name"; 
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource();
    	   params.addValue("size_name", size_name); 
    	   
    	   List<Map<String, Object>> rows = jdbc.queryForList(sql, params);
    	   
    	   int size_id = 0; 
    	   
    	   for(Map<String, Object> i : rows) {
    		   
    		   size_id = (int) i.get("size_id"); 
    	   }
    	   
    	   return size_id; 
       }
       
       public List<CartItemColorSizeProductImage> getCartItemColorSizeImageByCartId(int cart_id) {


    	   String sql = "SELECT "
    		        + "    i.image_url AS image_url,"
    		        + "    p.product_name AS product_name,"
    		        + "    c.color_name AS color_name,"
    		        + "    s.size_name AS size_name,"
    		        + "    p.product_price AS product_price,"
    		        + "    ci.enabled AS enabled,"
    		        + "    ci.ci_id AS ci_id "
    		        + "FROM cartItem ci "
    		        + "INNER JOIN product p ON ci.product_id = p.product_id "
    		        + "INNER JOIN size s ON ci.size_id = s.size_id "
    		        + "INNER JOIN color c ON ci.color_id = c.color_id "
    		        + "LEFT JOIN ("
    		        + "    SELECT "
    		        + "        i.product_id,"
    		        + "        i.color_id,"
    		        + "        MIN(i.image_url) AS image_url "
    		        + "    FROM image i "
    		        + "    GROUP BY i.product_id, i.color_id "
    		        + ") i ON p.product_id = i.product_id AND c.color_id = i.color_id "
    		        + "WHERE ci.cart_id = :cart_id";



    	   
    	   

    	   MapSqlParameterSource params = new MapSqlParameterSource();
    	   params.addValue("cart_id", cart_id);

    	   //
    	   List<CartItemColorSizeProductImage> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(CartItemColorSizeProductImage.class));

    	   if(!rows.isEmpty()) {
   
    		   return rows; 
    		
    	   }else {
   
    		   return null; 
    		   
    	   }

    	}


       public void removeItemFromCartItem(int ci_id) {
    	    String sql = "DELETE FROM cartItem WHERE ci_id = :ci_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("ci_id", ci_id); 
    	    
    	    jdbc.update(sql, params);
    	}

       
    
       public void updateRestQuantity(int product_id, int color_id, int size_id) {
           String sql = "UPDATE stock SET stock_quantity = stock_quantity -1 WHERE product_id = :product_id AND color_id = :color_id AND size_id = :size_id";

           MapSqlParameterSource params = new MapSqlParameterSource();
           params.addValue("product_id", product_id);
           params.addValue("color_id", color_id);
           params.addValue("size_id", size_id);

           jdbc.update(sql, params);
       }
       
       public void updateIncreasedQuantity(int product_id, int color_id, int size_id, int quantity) {
           String sql = "UPDATE stock SET stock_quantity = stock_quantity + :quantity   WHERE product_id = :product_id AND color_id = :color_id AND size_id = :size_id";

           MapSqlParameterSource params = new MapSqlParameterSource();
           params.addValue("product_id", product_id);
           params.addValue("color_id", color_id);
           params.addValue("size_id", size_id);
           params.addValue("quantity", quantity);

           jdbc.update(sql, params);
       }
       
       public boolean existUserIdInCart(int user_id) {
    	    String sql = "SELECT * FROM cart WHERE user_id = :user_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("user_id", user_id);

    	    List<Map<String, Object>> rows = jdbc.queryForList(sql, params);

    	    return !rows.isEmpty();
    	}

       //save shipping info
       public void saveShippingInfo(String addressLine1, String addressLine2, String city, String state, String postalCode, String phoneNumber, int user_id, int order_id) {
    	    String sql = "INSERT INTO shipping (address_line1, address_line2, city, state, postal_code, phone_number, user_id, order_id) " +
    	                 "VALUES (:address_line1, :address_line2, :city, :state, :postal_code, :phone_number, :user_id, :order_id)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("address_line1", addressLine1);
    	    params.addValue("address_line2", addressLine2);
    	    params.addValue("city", city);
    	    params.addValue("state", state);
    	    params.addValue("postal_code", postalCode);
    	    params.addValue("phone_number", phoneNumber);
    	    params.addValue("user_id", user_id); 
    	    params.addValue("order_id", order_id); 
    	    
    	    jdbc.update(sql, params);
    	}

       //save billing info 
       public void saveBillingInfo(String cardNumber, String cardholderName, String expirationDate, String cvc, int user_id, int order_id) {
    	    String sql = "INSERT INTO billing (card_number, cardholder_name, expiration_date, cvc, user_id, order_id) " +
    	                 "VALUES (:card_number, :cardholder_name, :expiration_date, :cvc, :user_id, :order_id)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("card_number", cardNumber);
    	    params.addValue("cardholder_name", cardholderName);
    	    params.addValue("expiration_date", expirationDate);
    	    params.addValue("cvc", cvc);
    	    params.addValue("user_id", user_id);
    	    params.addValue("order_id", order_id);

    	    jdbc.update(sql, params);
    	}
       
       
       //cartItem -> orderItem 
       public void insertOrderItem(int orderId, String productName, String sizeName, String colorName,  double productPrice, String imageUrl) {
    	
    	   String sql = "INSERT INTO orderItem (order_id, product_name, size_name, color_name, product_price, image_url) " +
    	             "VALUES (:order_id, :product_name, :size_name, :color_name,  :product_price, :image_url)";

	    	MapSqlParameterSource params = new MapSqlParameterSource();
	    	params.addValue("order_id", orderId);
	    	params.addValue("product_name", productName);
	    	params.addValue("size_name", sizeName);
	    	params.addValue("color_name", colorName);

	    	params.addValue("product_price", productPrice);
	    	params.addValue("image_url", imageUrl);
	
	    	jdbc.update(sql, params);

    	   
       }
       
       
       //make up specific order 
       public void insertOrder(int userID, double totalAmount) {
    	    String sql = "INSERT INTO orders(user_id, totalAmount) VALUES(:user_id, :totalAmount)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("user_id", userID);
    	    params.addValue("totalAmount", totalAmount);

    	    jdbc.update(sql, params);
    	}

       
       //retrieve current and one orderid by userid 
       public int getOrderIdByuserId(int userId) {
    	   
    	   String sql = "SELECT order_id FROM orders WHERE user_id = :user_id ORDER BY orderDate DESC LIMIT 1"; 
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_id", userId); 
    	   
    	   List<Map<String, Object>> lists = jdbc.queryForList(sql, params);
    	   
    	   int order_id = 0; 
    	   
    	   for(Map<String, Object> i : lists) {
    		   
    		   order_id = (int)i.get("order_id"); 
    	   }
    	   
    	   
    	   return order_id; 
       }
       
       
       //return total amount calculated by orderItem table 
       public double getTotalAmount(int order_id) {
    	   
    	   String sql = "SELECT SUM(product_price) AS totalAmount FROM orderItem WHERE order_id = :order_id";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("order_id", order_id); 
    	   
    	   List<Map<String, Object>> lists = jdbc.queryForList(sql, params);
    	
    	   double totalAmount = 0; 
    	   
    	   for(Map<String, Object> i : lists) {
    		   
    	        BigDecimal amount = (BigDecimal) i.get("totalAmount");
    	        totalAmount = amount.doubleValue();
    	   }
    	   
    	   
    	   return totalAmount; 
       }
       
       
       public void updateOrder(int order_id, double totalAmount) {
    	    String sql = "UPDATE orders SET totalAmount = :totalAmount WHERE order_id = :order_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("totalAmount", totalAmount);
    	    params.addValue("order_id", order_id);

    	    jdbc.update(sql, params);
    	}

       public void deleteCartByCartId(int cart_id) {
    	   
    	   String sql = "DELETE FROM cart WHERE cart_id = :cart_id"; 
       
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("cart_id", cart_id); 
    	   
    	   jdbc.update(sql, params); 
       }
       
       public void deleteCartItemByCartId(int cart_id) {
    	   String sql = "DELETE FROM cartItem WHERE cart_id = :cart_id"; 
           
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("cart_id", cart_id); 
    	   
    	   jdbc.update(sql, params); 
       }
       
       public List<Order> getOrdersByUserId(int user_id) {
    	   
    	   String sql = "SELECT * FROM orders WHERE user_id = :user_id ORDER BY orderDate DESC";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_id", user_id);
    	   
    	   List<Order> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Order.class));
    	   
    	   if(!rows.isEmpty()) {
    		   
    		   return rows; 
    	   }else {

    		   return null; 
    	   }
    	   
       }
       
       public List<Order> getOrderWithOrderItemByOrderId(int order_id) {
    	   
    	   String sql = "SELECT * FROM orders o INNER JOIN orderItem oi ON o.order_id = oi.order_id WHERE o.order_id = :order_id ";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("order_id", order_id);
    	   
    	   List<Order> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Order.class));
    	   
    	   if(!rows.isEmpty()) {
    		   
    		   return rows; 
    	   }else {
    		   
    		   return null; 
    	   }  
       }
       
       public Shipping getShippingByOrderId(int order_id) {
    	   
    	   String sql = "SELECT * FROM shipping WHERE order_id = :order_id"; 
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("order_id", order_id);
    	   
    	   List<Shipping> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Shipping.class)); 
    	   
    	   if(!rows.isEmpty()) {
    		   
    		   return rows.get(0); 
    	   }else {
    		   
    		   return null; 
    	   }
    	   
       }
       
       public Billing getBillingByOrderId(int order_id) {
    	    String sql = "SELECT * FROM billing WHERE order_id = :order_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("order_id", order_id);

    	    List<Billing> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Billing.class));

    	    if (!rows.isEmpty()) {
    	       
    	    	return rows.get(0); 
    	    } else {
    	        return null;
    	    }
    	}

       public List<Order> getAllOrdersWithOrderItemsWithUsers() {		
    	    
    	   String sql = "SELECT * FROM orderItem oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN users u ON o.user_id = u.user_id"; 
    	   List<Order> rows = jdbc.query(sql, new BeanPropertyRowMapper<>(Order.class)); 
    	    
    	   return rows;
       }

       public void updateStatusInOrderItem(int oi_id, String status) {
    	    String sql = "UPDATE orderItem SET status = :status WHERE oi_id = :oi_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("oi_id", oi_id);
    	    params.addValue("status", status);

    	    jdbc.update(sql, params);
    	}

       public List<Order> getOrdersWithOrderItemsWithUsersByStatus(String status) {		
   	    
    	   String sql = "SELECT * FROM orderItem oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN users u ON o.user_id = u.user_id WHERE oi.status = :status"; 
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("status", status);     	  
    	   
    	   List<Order> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Order.class)); 
    	    
    	   return rows;
       }
       
       public List<Order> getOrdersWithOrderItemsWithUsersByUsername(String user_name) {	
    	   
    	   String sql = "SELECT * FROM orderItem oi INNER JOIN orders o ON oi.order_id = o.order_id INNER JOIN users u ON o.user_id = u.user_id WHERE u.user_name LIKE :user_name"; 
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("user_name", "%" + user_name + "%"); 
    	   
    	   List<Order> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Order.class)); 

    	   return rows; 
       }
       
       
       public OrderItem getOrderItemsByOiId(int oi_id) {
    	   
    	   String sql = "SELECT * FROM orderItem WHERE oi_id = :oi_id";
    	   
    	   MapSqlParameterSource params= new MapSqlParameterSource();
    	   params.addValue("oi_id", oi_id);
    	   
    	   List<OrderItem> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(OrderItem.class)); 
    	   
    	   if(!rows.isEmpty()) {
    		   
    		   return rows.get(0);
    	   }else {
    		   
    		   return null; 
    	   }
       }
       
       
       public int getProductIdByProductName(String product_name) {
    	   
    	  String sql = "SELECT product_id FROM product WHERE product_name = :product_name";  
       
    	  MapSqlParameterSource params = new MapSqlParameterSource(); 
    	  params.addValue("product_name", product_name);
    	  
    	  List<Map<String, Object>> rows =  jdbc.queryForList(sql, params);  
    	  
    	  int product_id =   (int)rows.get(0).get("product_id"); 
    	  
    	  return product_id; 
       }
       
       public int getColorIdByColorName(String colorName) {
    	    String sql = "SELECT color_id FROM color WHERE color_name = :color_name";
    	    
    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("color_name", colorName);
    	    
    	    List<Map<String, Object>> rows = jdbc.queryForList(sql, params);
    	    
    	    int colorId = 0;
    	    
    	    for (Map<String, Object> row : rows) {
    	        colorId = (int) row.get("color_id");
    	    }
    	    
    	    return colorId;
    	}
       
       public int getColorIdByColorHex(String colorHex) {
    	    String sql = "SELECT color_id FROM color WHERE color_hex = :color_hex";
    	    
    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("color_hex", colorHex);
    	    
    	    List<Map<String, Object>> rows = jdbc.queryForList(sql, params);
    	    
    	    int colorId = 0;
    	    
    	    for (Map<String, Object> row : rows) {
    	        colorId = (int) row.get("color_id");
    	    }
    	    
    	    return colorId;
    	}

       
       
       public void deleteOneOrderItem(int oi_id) {
    	   
    	   String sql = "DELETE FROM orderItem WHERE oi_id = :oi_id";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("oi_id", oi_id);
    	   
    	   jdbc.update(sql, params); 
       }


       
       
       //retrieve order_id 
       public int getCurrentOrderIdOfUserId(int user_id) {
    	    String sql = "SELECT order_id FROM orders WHERE user_id = :user_id ORDER BY orderDate DESC LIMIT 1";
    	    
    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("user_id", user_id); 
    	    
    	    List<Map<String, Object>> rows = jdbc.queryForList(sql, params); 
    	    
    	    int order_id = (int)rows.get(0).get("order_id");
    	    
    	    return order_id; 
    	  
    	}

       public List<OrderItem> getOrderItemsByOrderId(int order_id) {
    	   
    	   String sql = "SELECT * FROM orderItem WHERE order_id = :order_id";
    	   
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   params.addValue("order_id", order_id); 
    	   List<OrderItem> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(OrderItem.class)); 

      	   
    	   if(!rows.isEmpty()) {
    		   
    		   return rows;
    	   }else {
    		   
    		   return null; 
    	   }

       }
       
       public void updateQuantityInStock(int product_id, int color_id, int size_id) {
    	    String sql = "UPDATE stock SET stock_quantity = stock_quantity - 1 WHERE product_id = :product_id AND color_id = :color_id AND size_id = :size_id";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("product_id", product_id);
    	    params.addValue("color_id", color_id);
    	    params.addValue("size_id", size_id);

    	    jdbc.update(sql, params);
    	}


       
       public int countDuplicateCartItem(int product_id, int size_id, int color_id, int enabled) {
    	    String sql = "SELECT COUNT(*) FROM cartItem WHERE product_id = :product_id AND size_id = :size_id AND color_id = :color_id AND enabled = :enabled";
    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("product_id", product_id);
    	    params.addValue("size_id", size_id);
    	    params.addValue("color_id", color_id);
    	    params.addValue("enabled", enabled);

    	    int count = jdbc.queryForObject(sql, params, Integer.class);
    	    return count;
    	}

       //update enabled proeprty to false 
       public void updateEnabledToFalse(int product_id, int size_id, int color_id) {
    	    String sql = "UPDATE cartItem SET enabled = 2 WHERE product_id = :product_id AND size_id = :size_id AND color_id = :color_id AND enabled = 1 LIMIT 1";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("product_id", product_id);
    	    params.addValue("size_id", size_id);
    	    params.addValue("color_id", color_id);

    	    jdbc.update(sql, params);
    	}

       
       public void deleteAllDuplicateCartItems(int cart_id, int enabled) {
    	    String sql = "DELETE FROM cartItem WHERE cart_id = :cart_id AND enabled = :enabled";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("cart_id", cart_id);
    	    params.addValue("enabled", enabled);

    	    jdbc.update(sql, params);
    	}
       public List<Category> getAllCategories() {
    	    String sql = "SELECT category_name FROM category";
    	    
    	    List<Category> rows = jdbc.query(sql, new BeanPropertyRowMapper<>(Category.class));     	  
 
    	    
    	    return rows;
    	}

       public List<Color> getAllColors() {
   	    String sql = "SELECT color_name FROM color";
   	    
   	    List<Color> rows = jdbc.query(sql, new BeanPropertyRowMapper<>(Color.class));     	  

   	    
   	    return rows;
   	}
       
       
       public void insertProduct(String productName, double productPrice, String productDescription) {
    	    String sql = "INSERT INTO product (product_name, product_price, product_description) VALUES (:productName, :productPrice, :productDescription)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("productName", productName);
    	    params.addValue("productPrice", productPrice);
    	    params.addValue("productDescription", productDescription);


	        jdbc.update(sql, params);

    
    	}

       
       public void insertImage(int productId, int colorId, String imageUrl) {
    	    String sql = "INSERT INTO image (product_id, color_id, image_url) VALUES (:productId, :colorId, :imageUrl)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("productId", productId);
    	    params.addValue("colorId", colorId);
    	    params.addValue("imageUrl", imageUrl);

    	    jdbc.update(sql, params);
    	}

       
       public void insertProductColor(int productId, int colorId) {
    	    String sql = "INSERT INTO product_color (product_id, color_id) VALUES (:productId, :colorId)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("productId", productId);
    	    params.addValue("colorId", colorId);

    	    jdbc.update(sql, params);
    	}

       
       
       
       //check if the color hexa code already exists 
       public boolean isColorHexCodeExists(String color_hex) {
    	   
    	   String sql = "SELECT count(*) FROM color WHERE color_hex = :color_hex"; 
    	
    	   MapSqlParameterSource params = new MapSqlParameterSource(); 
    	   
    	   params.addValue("color_hex", color_hex);
    	   
    	   int count = jdbc.queryForObject(sql, params, Integer.class); 
    	   
    	   return count > 0; 
       }
       
       public void insertColor(String colorName, String colorHex) {
    	    String sql = "INSERT INTO color(color_name, color_hex) VALUES(:color_name, :color_hex)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("color_name", colorName);
    	    params.addValue("color_hex", colorHex);

    	    jdbc.update(sql, params);
    	}

       public void insertCategory(int productId, int categoryId) {
    	    String sql = "INSERT INTO product_category (product_id, category_id) VALUES (:productId, :categoryId)";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("productId", productId);
    	    params.addValue("categoryId", categoryId);

    	    jdbc.update(sql, params);
    	}
       
       public List<Stock> getAllStocks() {
    	    String sql = "SELECT * FROM product p\r\n"
    	    		+ "INNER JOIN stock st ON p.product_id = st.product_id\r\n"
    	    		+ "INNER JOIN color c ON c.color_id = st.color_id\r\n"
    	    		+ "INNER JOIN size s ON s.size_id = st.size_id;\r\n"; 
    	    
    	    List<Stock> stocks = jdbc.query(sql, new BeanPropertyRowMapper<>(Stock.class));
    	    
    	    return stocks;
    	}
       
       public List<Stock> searchStockByProductName(String productName) {
    	    String sql = "SELECT * FROM stock s INNER JOIN product p ON s.product_id = p.product_id WHERE p.product_name LIKE :productName";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("productName", "%" + productName + "%");

    	    List<Stock> rows = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Stock.class));

    	    return rows;
    	}


       public boolean searchUserName(String username) {
    	    String sql = "SELECT COUNT(*) FROM users WHERE user_name = :user_name";

    	    MapSqlParameterSource params = new MapSqlParameterSource();
    	    params.addValue("user_name", username);
    	    

    	    int count = jdbc.queryForObject(sql, params, Integer.class);

    	    
    	    return count > 0;
    	}

		
		public void registerUser(String username, String password) {
		    String sql = "INSERT INTO users(user_name, password, enabled) VALUES(:user_name, :password, 1)";
		    
		    MapSqlParameterSource params = new MapSqlParameterSource();
		    params.addValue("user_name", username);
		    params.addValue("password", password);
		    
		    jdbc.update(sql, params);
		}


		
		
		public int searchUserId(String username, String password) {
		    String sql = "SELECT user_id FROM users WHERE user_name = :user_name AND password = :password";

		    MapSqlParameterSource params = new MapSqlParameterSource();
		    params.addValue("user_name", username);
		    params.addValue("password", password);

		    try {
		        return jdbc.queryForObject(sql, params, Integer.class);
		    } catch (EmptyResultDataAccessException e) {
		        return 0; // Return a default value or handle the absence of the user ID as per your requirement
		    }
		}

		public void registerUserRole(int user_id, int role_id) {
		    String sql = "INSERT INTO user_role(user_id, role_id) VALUES(:user_id, :role_id)";

		    MapSqlParameterSource params = new MapSqlParameterSource();
		    params.addValue("user_id", user_id);
		    params.addValue("role_id", role_id);

		    jdbc.update(sql, params);
		}


}
