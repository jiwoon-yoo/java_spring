package ca.sheridancollege.yoojiw.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.yoojiw.entities.Product;
import ca.sheridancollege.yoojiw.repository.ProductRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/product")
public class RestController {

	@Autowired
	private ProductRepository pr; 
	
	
	//get one
	@GetMapping("/{id}")
	public Product getOneProduct(@PathVariable Long id) {
		
		Optional<Product> product = pr.findById(id); 
		
		if(product.isPresent()) {
			
			return product.get(); 
		}else {
			throw new RuntimeException("product not found with id : " + id); 
		}
	}
	
	//get all 
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(pr.findAll()); 
	}
	
	//save 
	@PostMapping("/single")
	public void saveOneProduct(@RequestBody Product product) {
		
		pr.save(product); 
		
	}
	//save all 
	@PostMapping("/all")
	public void saveAll(@RequestBody List<Product> products) {
			
		pr.saveAll(products); 
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteOneProduct(@PathVariable Long id) {
		
		pr.deleteById(id); 
	}
	
	//deleteall 
	@DeleteMapping
	public void deleteAllProducts() {
		pr.deleteAll(); 
	}
	
	
    // Endpoint to get products with price greater than or equal to a given value
	@GetMapping("/price")
	public Product getMethodName(@RequestParam("minPrice") double minPrice) {
		
		return pr.findProductByPriceGreaterAndEqual(minPrice).get(0);  
	}
	
	
	
}
