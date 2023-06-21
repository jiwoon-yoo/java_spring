package ca.sheridancollege.yoojiw.controllers;

import java.util.List;



import ca.sheridancollege.yoojiw.bean.Order;
import ca.sheridancollege.yoojiw.bean.OrderItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.yoojiw.bean.Product_Color;
import ca.sheridancollege.yoojiw.bean.Product_Image;
import ca.sheridancollege.yoojiw.bean.Shipping;
import ca.sheridancollege.yoojiw.bean.Stock;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;
import ca.sheridancollege.yoojiw.service.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.sheridancollege.yoojiw.bean.Billing;
import ca.sheridancollege.yoojiw.bean.CartItem;
import ca.sheridancollege.yoojiw.bean.CartItemColorSizeProductImage;
import ca.sheridancollege.yoojiw.bean.Category;
import ca.sheridancollege.yoojiw.bean.Color;
import ca.sheridancollege.yoojiw.bean.Image;
import ca.sheridancollege.yoojiw.bean.OrderStatus;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


import java.nio.file.Files;
import java.nio.file.Path;



@Controller
public class MainController {

	private List<String> categories = Arrays.asList("boots", "sneakers", "heels");
	private List<String> status = Arrays.asList(OrderStatus.PROCESSING.toString(), OrderStatus.SHIPPED.toString(), OrderStatus.DELIVERED.toString(), OrderStatus.CANCELED.toString(), OrderStatus.CANCELING.toString() ); 
	
	@Autowired
	private DatabaseAccess da;
	
	@Autowired
	private UserService us; 
	
	@GetMapping("/")
	public String index() {

		return "index"; 
	}
	
	@GetMapping("/viewAll")
	public String viewAll(Model model) {
			
		List<Product_Color> pcs = da.getAllProductsOfAllColors(); 
		
		List<Image> images = new ArrayList<>(); 
		
		for(Product_Color i : pcs) {
			
			images.add(da.readOneImage(i.getProduct_id(), i.getColor_id())); 
			
		}
	
		
		model.addAttribute("images", images); 
		model.addAttribute("pcs", pcs);
		
		return "viewAll";  
	}
	
	@GetMapping("/top")
	public String top(Model model) {
		
		List<Product_Color> pcs = da.getAllProductsOfAllColors(); 
		
		List<Image> images = new ArrayList<>(); 
		
		for(Product_Color i : pcs) {
			
			images.add(da.readOneImage(i.getProduct_id(), i.getColor_id())); 
			
		}
	
		
		model.addAttribute("images", images); 
		model.addAttribute("pcs", pcs);
		
		return "top"; 
	}
	
	@GetMapping("/bottom")
	public String bottom(Model model) {
		
		List<Product_Color> pcs = da.getAllProductsOfAllColors(); 
		
		List<Image> images = new ArrayList<>(); 
		
		for(Product_Color i : pcs) {
			
			images.add(da.readOneImage(i.getProduct_id(), i.getColor_id())); 
			
		}
	
		
		model.addAttribute("images", images); 
		model.addAttribute("pcs", pcs);
		
		return "bottom"; 
	}
	
	@GetMapping("/dress")
	public String dress(Model model) {
		
		List<Product_Color> pcs = da.getAllProductsOfAllColors(); 
		
		List<Image> images = new ArrayList<>(); 
		
		for(Product_Color i : pcs) {
			
			images.add(da.readOneImage(i.getProduct_id(), i.getColor_id())); 
			
		}
	
		
		model.addAttribute("images", images); 
		model.addAttribute("pcs", pcs);
		
		return "dress"; 
	}
	
	
	@GetMapping("/jacket_coat")
	public String jacket_coat(Model model) {
		
		List<Product_Color> pcs = da.getAllProductsOfAllColors(); 
		
		List<Image> images = new ArrayList<>(); 
		
		for(Product_Color i : pcs) {
			
			images.add(da.readOneImage(i.getProduct_id(), i.getColor_id())); 
			
		}
	
		
		model.addAttribute("images", images); 
		model.addAttribute("pcs", pcs);
		
		return "jacket_coat"; 
	}
	

	@GetMapping("/extraDetail/{category}")
	public String extraDetail(@PathVariable String category, Model model) {

		model.addAttribute("category", category);

		return "extraDetail";
	}
	

	
	
    @GetMapping("/product/{product_id}/{color_id}")
    public String showProduct(Model model, @PathVariable("product_id") int product_id, @PathVariable("color_id") int color_id) {
    
    	List<Product_Image> pis =  da.getOneProductByColorIdWithMultipleImages(product_id, color_id); 
    	List<Product_Color> pcs = da.getOneProductsOfAllColors(product_id); 
    	
    	
    	model.addAttribute("pis", pis);  
    	model.addAttribute("pis1", pis.get(0)); 
    	model.addAttribute("pcs", pcs);
    	
    	model.addAttribute("product_id", product_id);     	
    	model.addAttribute("color_id", color_id);     	
    	
    	List<Stock> stocks = da.getStocksByProductId(product_id, color_id); 
    	
    	int quantityS = 0; 
    	int quantityM = 0; 
    	int quantityL = 0; 
    	
    	for(Stock i :stocks) {
    		
    		if(i.getSize_id() == 1) {
    			quantityS = i.getStock_quantity(); 
    		}else if(i.getSize_id() == 2){
    			quantityM = i.getStock_quantity(); 
    		}else {
    			quantityL = i.getStock_quantity(); 
    		}
    	}
  
    	model.addAttribute("quantityS", quantityS); 
    	model.addAttribute("quantityM", quantityM); 
    	model.addAttribute("quantityL", quantityL); 
    	
    	return "productDetail"; 
    }


    @GetMapping("/showProductByColor/{product_id}/{color_id}")
    public String showProductByColor(Model model, @PathVariable("product_id")int product_id, @PathVariable("color_id")int color_id) {
   
    	List<Product_Image> pis =  da.getOneProductByColorIdWithMultipleImages(product_id, color_id); 
    	List<Product_Color> pcs = da.getOneProductsOfAllColors(product_id); 
    	
    	
    	model.addAttribute("pis", pis);  
    	model.addAttribute("pis1", pis.get(0)); 
    	model.addAttribute("pcs", pcs); 
    	
    	model.addAttribute("product_id", product_id);     	
    	model.addAttribute("color_id", color_id); 
    	
    	List<Stock> stocks = da.getStocksByProductId(product_id, color_id); 
    	int quantityS = 0; 
    	int quantityM = 0; 
    	int quantityL = 0; 
    	
    	for(Stock i :stocks) {
    		
    		if(i.getSize_id() == 1) {
    			quantityS = i.getStock_quantity(); 
    		}else if(i.getSize_id() == 2){
    			quantityM = i.getStock_quantity(); 
    		}else {
    			quantityL = i.getStock_quantity(); 
    		}
    	}
  
    	model.addAttribute("quantityS", quantityS); 
    	model.addAttribute("quantityM", quantityM); 
    	model.addAttribute("quantityL", quantityL); 
    	
    	
    	
    	
    	return "productDetail"; 
    }

    
    
    List<CartItem> tempCart = new ArrayList<>(); 
    
    /////////////////
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {

    
	   for(CartItem i : tempCart) {
		   
		   int cartProduct_id = i.getProduct_id();
	       int cartSize_id = i.getSize_id();
	       int cartColor_id = i.getColor_id();
		   
	       int count = da.countDuplicateCartItem(cartProduct_id, cartSize_id, cartColor_id, 1);
	       
	       int stockQuantityForCartItem = da.getQuantityOfStock(cartProduct_id, cartSize_id, cartColor_id);		//notice!!!! cart_id should be presented
	        
	        if (count > stockQuantityForCartItem) {
	            int howManyRowsDeleted = count - stockQuantityForCartItem; 
	            
	            for(int j = 0; j < howManyRowsDeleted; j++) {
	            
	            	da.updateEnabledToFalse(cartProduct_id, cartSize_id, cartColor_id); 
	            }
	            
	        }
	   }
	   

	   	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	   	String username = authentication.getName();
	   	int user_id = da.getUserIdByUserName(username);	
	   	int cart_id =da.getCartIdByUserId(user_id);	
	   	List<CartItemColorSizeProductImage> carts = da.getCartItemColorSizeImageByCartId(cart_id); 
	   	

	   	model.addAttribute("carts", carts);
    	   	
	   	
    	return "cart";
    }
    
    
    @GetMapping("/addToCart")
    public String addToCart( Model model, HttpSession session, @RequestParam("product_id") int product_id, @RequestParam("color_id") int color_id, 
    							@RequestParam("sizeSelect") String sizeSelect) {
    	
    	
    	
    	
    	//size -> size_id
    	int size_id = da.getSizeIdBySizeName(sizeSelect); 
    	int stockQuantity = da.getQuantityOfStock(product_id, size_id, color_id);   
        // Check if there is enough stock available
//    	if(stockQuantity == 0) {
//        	
//            String errorMessage1 = "Sorry, it's out of stock.";
//            model.addAttribute("errorMessage1", errorMessage1);	
//    		
//    		return "redirect:/cart?fail"; 
//        }
 
        

    	
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	int user_id = da.getUserIdByUserName(username);		//user_id
    	
    	//make up the cart for the user - insert 
    	if(!da.existUserIdInCart(user_id)) {
    		da.insertUserIdToCart(user_id); 
    	}
    	
    	


    	int cart_id =da.getCartIdByUserId(user_id);			//cart_id created only once
    	
    	
    	//notice. if insertCartItem(cart_id, product_id, size_id, color_id is same, 
    	
    	///////////////cart list is more than that, don't 
    	//insert into cartItem table 
    	da.insertCartItem(cart_id, product_id, size_id, color_id); 			///the actual inserting process has to be moved into the cart method? 
    	
    	tempCart.add(new CartItem(cart_id, product_id, size_id, color_id, true)); 		//////check it out     	
    	
    	//List<CartItemColorSizeProductImage> carts = da.getCartItemColorSizeImageByCartId(cart_id); 
    	
    	
    	//model.addAttribute("carts", carts);
    	

    	
    	
    	

    	return "redirect:/product/" + product_id + "/" + color_id; 
    }

    
    
    @GetMapping("/removeItem/{ci_id}")
    public String removeItem(@PathVariable("ci_id") int ci_id) {
        // Use the passed parameters to remove the item from the cart
        da.removeItemFromCartItem(ci_id);
        
        return "redirect:/cart";
    }

    
    
    
    //notice. while checking out, triple check the stock quantity 
    @GetMapping("/checkout")
    public String checkout(Model model) {
    	
       	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	int user_id = da.getUserIdByUserName(username);	
    	int cart_id =da.getCartIdByUserId(user_id);	
    	
    	//remove duplicate cartItems that is never yet removed in the cart page
    	da.deleteAllDuplicateCartItems(cart_id, 2); 
    	
	   	List<CartItemColorSizeProductImage> carts = da.getCartItemColorSizeImageByCartId(cart_id); 
	   	
	   	model.addAttribute("carts", carts);
    	
    	
    	return "checkout"; 
    }
    @PostMapping("/checkout")
    public String checkout2(@RequestParam("address-line1") String addressLine1,
                            @RequestParam("address-line2") String addressLine2,
                            @RequestParam("city") String city,
                            @RequestParam("state") String state,
                            @RequestParam("postal-code") String postalCode,
                            @RequestParam("phone-number") String phoneNumber,
                            @RequestParam("card-number") String cardNumber,
                            @RequestParam("cardholder-name") String cardholderName,
                            @RequestParam("expiration-date") String expirationDate,
                            @RequestParam("cvc") String cvc) {

    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	int user_id = da.getUserIdByUserName(username);	
    	int cart_id =da.getCartIdByUserId(user_id);	

    	
    	//make up one order 
    	da.insertOrder(user_id, 0); 		//by default, processing at first
    	
    	
    	//retrieve 'current' orderId by user id 
    	int currentOrderId = da.getOrderIdByuserId(user_id);
    	
    	
     	//save shipping info 
    	da.saveShippingInfo(addressLine1, addressLine2, city, state, postalCode, phoneNumber, user_id, currentOrderId);

    	//save billing info 
        da.saveBillingInfo(cardNumber, cardholderName, expirationDate, cvc, user_id, currentOrderId);
    	

    	
    	//transfer the info in the cartItem table into orderItem table 
    	List<CartItemColorSizeProductImage> carts = da.getCartItemColorSizeImageByCartId(cart_id); 
    	
    	for(CartItemColorSizeProductImage i : carts) {
    		
    		da.insertOrderItem(currentOrderId, i.getProduct_name(), i.getSize_name(), i.getColor_name(), i.getProduct_price(), i.getImage_url());  
    	}
    	

    	//get total amount -> updated
    	double totalAmount = da.getTotalAmount(currentOrderId); 
    	da.updateOrder(currentOrderId, totalAmount);  
    	
        
    	//delete the values from the cart table and cartItem table 
    	da.deleteCartItemByCartId(cart_id); 
    	da.deleteCartByCartId(cart_id);

    	
    	
    	
    	//modify the stock 
    	//retrieve current order_id of the same user_id
    	int order_id = da.getCurrentOrderIdOfUserId(user_id);     	
    	List<OrderItem> orderItems = da.getOrderItemsByOrderId(order_id);       

    	for(OrderItem i : orderItems) {
    		
    		int product_id = da.getProductIdByProductName(i.getProduct_name());   
    		int size_id =  da.getSizeIdBySizeName( i.getSize_name());  
    		int color_id = da.getColorIdByColorName(i.getColor_name()); 
    		
 
    		int stock_quantity = da.getQuantityOfStock(product_id, size_id, color_id);
    		if(stock_quantity > 0) {
    			da.updateQuantityInStock(product_id, color_id, size_id); 
    		}else {
    			System.out.println("out of stock. we modifed the orders.");
    			
    			break; 
    		}
    	 }
    	
    	
         return "redirect:/?checkout-success";
    }

    
    
    
    
    @GetMapping("/myaccount")
    public String myaccount(Model model) {
    	
    	//retrieve all the data by userId
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
    	String user_name = auth.getName(); 
    	int user_id = da.getUserIdByUserName(user_name); 
    	
    	List<Order> orders = da.getOrdersByUserId(user_id); 
    	
    	model.addAttribute("orders", orders);
    	
    	return "myaccount"; 
    }


    @GetMapping("/purchase/{order_id}")
    public String purchaseDetail(Model model, @PathVariable("order_id") int order_id) {
    	
    	//
    	List<Order> purchases = da.getOrderWithOrderItemByOrderId(order_id); 
    	
    	model.addAttribute("purchases", purchases);
    	
    	//
    	Shipping shipping = da.getShippingByOrderId(order_id); 
    	model.addAttribute("shipping", shipping); 
    	
    	//
    	Billing billing = da.getBillingByOrderId(order_id); 
    	model.addAttribute("billing", billing); 
    	
    	return "purchaseDetail"; 
    }
    
    @GetMapping("/adminOrder")
    public String adminOrder(Model model) {
    	
    	List<Order> orders =  da.getAllOrdersWithOrderItemsWithUsers(); 
    	
    	model.addAttribute("orders", orders); 
    	
    	model.addAttribute("status", status); 
     
    	
    	return "adminOrder"; 
    }
    
    
    
    @PostMapping("/statusModify")
    public String statusModify(@RequestParam("oi_id") int oi_id, @RequestParam("status") String status) {
        // Modify the status of each orderItem 
        da.updateStatusInOrderItem(oi_id, status);
        
        return "redirect:/adminOrder?modified-success";
    }


    
    
    @PostMapping("/searchByStatus")
    public String searchByStatus(Model model, @RequestParam("status") String selectedStatus) {

    	
    	if ("TOTAL".equals(selectedStatus)) {
    	    return "redirect:/adminOrder";
    	    
    	} else {
    		
    	    List<Order> orders = da.getOrdersWithOrderItemsWithUsersByStatus(selectedStatus);		////
    	    
    	    model.addAttribute("orders", orders);
    	    model.addAttribute("status", selectedStatus);
    	    return "adminOrder";
    	}	
    }
    
    @PostMapping("/searchByUserName")
    public String searchByUserName(Model model, @RequestParam("username") String username){
    	
    	List<Order> orders = da.getOrdersWithOrderItemsWithUsersByUsername(username); 
    	
    	model.addAttribute("orders", orders);
    	model.addAttribute("status", status); 
    	
    	return "adminOrder"; 
    }

    
      @GetMapping("/modifyStatus/{oi_id}/{order_id}")
      public String modifyStatus(@PathVariable("oi_id") int oi_id, @PathVariable("order_id") int order_id){
    	  
    	  da.updateStatusInOrderItem(oi_id, "CANCELING"); 
    	  
    	  return "redirect:/purchase/" + order_id; 
    	  
      }
      
      
      @GetMapping("/adminStock")
      public String adminProduct(Model model) {
    	  
    	  List<Stock> stocks = da.getAllStocks(); 
    	  
    	  model.addAttribute("stocks", stocks); 
    	  
    	  return "adminStock"; 
      }
    
      @PostMapping("/addQty")
      public String addQty(@RequestParam("product_id") int productId,
                           @RequestParam("color_id") int colorId,
                           @RequestParam("size_id") int sizeId,
                           @RequestParam("qty") int quantity) {

          da.updateIncreasedQuantity(productId, colorId, sizeId, quantity);
          
     
          return "redirect:/adminStock"; 
      }

      @PostMapping("/searchByProductName")
      public String searchByProductName(@RequestParam("productName") String productName, Model model) {
          // Perform the search logic based on the provided product name
          List<Stock> stocks = da.searchStockByProductName(productName);
          
          model.addAttribute("stocks", stocks);
          
          
          return "adminStock";
      }
      
      @GetMapping("/register")
      public String register() {
    	  
    	  return "register"; 
      }
      
      @PostMapping("/register")
      public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") int role_id) {
    	  
          us.register(username, password, role_id); 
          
          return "redirect:/registerSuccess";
      }

      @GetMapping("/registerSuccess")
      public String registerSuccess() {
    	  
    	  
    	  
    	  return "registerSuccess"; 
      }

}
