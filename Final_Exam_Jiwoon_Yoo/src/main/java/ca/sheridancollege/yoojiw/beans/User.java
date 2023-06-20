package ca.sheridancollege.yoojiw.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor		//@RequiredConstructor - @NonNull 
public class User {

	private Long userId;
	@NonNull
	private String email;
	@NonNull
	private String encryptedPassword;	//
	@NonNull
	private Boolean enabled;

}