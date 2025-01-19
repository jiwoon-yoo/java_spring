

document.getElementById("register-form").addEventListener("submit", (event) => {
	
	event.preventDefault(); 
	
	const feedback = document.getElementById("feedback"); 
	feedback.innerHTML = "";
	
	
	let isValid = true; 
	
	
	
	//check match password 
	const password = document.getElementById("password").value;
	const verifyPassword = document.getElementById("verify-password").value; 
	
	if(password !== verifyPassword ){
		
		feedback.innerHTML += `password doesn't match <br>`; 
		feedback.style.color = "red"; 
				
		isValid = false;   
	}
		
	
	//check password, verify-password empty 
	if(password == "" || verifyPassword == ""){
		feedback.innerHTML += `password sections can't be empty <br>`; 
		feedback.style.color = "red"; 
				
		isValid = false;   
	}
	
	
	
	//check username empty 
	const username = document.getElementById("username").value.trim(); 
	
	if(username == ""){
				
		feedback.innerHTML += `username can't be empty <br>`; 
		feedback.style.color = "red"; 

		isValid = false;    
	}
	
	
	if(!isValid){
		return; 
	}
	
	
	
	fetch(`/check-user?username=${username}`)
		.then(response => response.json() ) 
		.then(data => {
			
			const isExist  = data; 
			
			if(isExist){
				
				
				feedback.innerHTML += `Username already exists<br>`;			//
	            feedback.style.color = "red";
				return; 
								
			}else{
				// 폼 직접 참조하여 제출
                document.getElementById("register-form").submit();
			}
	
			
		})
		.catch(error => console.error(error) )
	
	
		
	
} ); 


 

