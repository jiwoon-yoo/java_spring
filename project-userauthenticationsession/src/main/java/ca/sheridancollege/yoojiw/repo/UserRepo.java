package ca.sheridancollege.yoojiw.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	
	@Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
	Optional<User> findUserByUsername(@Param("username") String username); 
}
