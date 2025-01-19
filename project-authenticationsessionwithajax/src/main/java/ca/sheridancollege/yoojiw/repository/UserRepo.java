package ca.sheridancollege.yoojiw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username); 
	
	@Modifying
	@Query(value = "INSERT INTO user_role(user_id, role_id) VALUES(:user_id, :role_id)", nativeQuery = true)
	int saveUserRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id); 
	
	
}
