package ca.sheridancollege.yoojiw.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.dto.ProductDTO;
import ca.sheridancollege.yoojiw.dto.ProductNameQuantityDTO;
import ca.sheridancollege.yoojiw.dto.ProductTitleDTO;
import ca.sheridancollege.yoojiw.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//save
	//saveall 
	//deleteall
	//deletebyid
	//findall
	//findbyid
	
    // Custom Method: Find products with price greater than or equal to a given value
	@Query(value = "SELECT * FROM products WHERE price >= :minPrice", nativeQuery = true)
	List<Product> findProductByPriceGreaterAndEqual(@Param("minPrice")double price); 
	
	// Select product name AS productName and price only, and map them to ProductDTO
	@Query(value = "SELECT name AS productName, price FROM products", nativeQuery = true)
	List<ProductDTO> findProudctDTO(); 
	
	// Select products with price greater than a given value, mapping to ProductDTO
	@Query(value = "SELECT name AS productName, price FROM products WHERE price > :price", nativeQuery = true)
	List<ProductDTO> findProductDTOByPrice(@Param("price") double price); 
	
	// Select products with a specific name, only retrieving the name and price into ProductDTO
	@Query(value = "SELECT name AS productName, price FROM products WHERE productName = :name", nativeQuery = true)
	List<ProductDTO> findProductByProductName(@Param("name") String name);
	
	// Select the maximum price among all products, mapping it to a custom alias
	@Query(value = "SELECT MAX(price) FROM products", nativeQuery = true)
	Double findMaxPrice(); 
	
	// Retrieve the average price of all products, mapping it to a custom alias
	@Query(value = "SELECT AVG(price) FROM products", nativeQuery = true)
	Double findAvgPrice(); 
	
	// Select the product name and quantity where the quantity is in a specific range, mapping to a custom DTO
	@Query(value = "SELECT name, quantity FROM products WHERE quantity BETWEEN :minQuan AND :maxQuan", nativeQuery = true)
	List<ProductNameQuantityDTO> findProductByQuantity(@Param("minQuan") int minQuan, @Param("maxQuan") int maxQuan); 
	
	// Retrieve products where the name contains a specific keyword, mapping the name and price to a DTO
	@Query(value = "SELECT name AS productName, price FROM products WHERE name LIKE CONCAT('%',:keyword,'%') ", nativeQuery = true)
	List<ProductDTO> findProudctByName(@Param("keyword") String keyword); 
	
	// Select product name starting with a specific prefix, mapping it with alias "productTitle" into DTO
	@Query(value = "SELECT name AS productTitle FROM products WHERE name LIKE CONCAT(:title, '%') ", nativeQuery = true)
	List<ProductTitleDTO> findProductByTitle(@Param("title") String title); 
	
	
	
}
