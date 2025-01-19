package ca.sheridancollege.yoojiw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.entity.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	
	
	//inner join 
	@Query(value = "SELECT r.name  FROM users u INNER JOIN user_role ur ON u.id = ur.user_id INNER JOIN roles r ON ur.role_id = r.id WHERE u.id = :userId", nativeQuery = true)
	List<String> findRoleNameByUserId(@Param("userId") Long userId);
	
	
	Optional<Role> findByName(String name); 
}
