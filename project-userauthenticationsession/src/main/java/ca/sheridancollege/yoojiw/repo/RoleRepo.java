package ca.sheridancollege.yoojiw.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yoojiw.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	@Query(value = "SELECT r.name FROM user_role ur INNER JOIN roles r ON ur.role_id = r.id WHERE ur.user_id = :userId ", nativeQuery = true)
	List<String> findRoleNameByUserId(@Param("userId") Long userId); 

}
