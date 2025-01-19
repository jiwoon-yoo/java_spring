package ca.sheridancollege.yoojiw.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "user_id")
	@jakarta.validation.constraints.NotNull
	private User user; 
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "role_id")
	@jakarta.validation.constraints.NotNull
	private Role role; 
	
	
	
	
	
	
	
}
