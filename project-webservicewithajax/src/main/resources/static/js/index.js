

document.getElementById("getButton").addEventListener("click", () => {
	
	fetch("https://reqres.in/api/users?page=2")
		.then(response => response.json() )
		.then(data => {
			
			const box = document.getElementById("getContent"); 
			const userList = data.data; 
			
			
			userList.forEach(user => {
				
				const firstName = user.first_name;
				const lastName = user.last_name; 
				const email = user.email; 
				
				box.innerHTML += `firstname : ${firstName}   last name : ${lastName}  email : ${email} <br>`; 
				
			}  ); 
			
			
		})
		.catch(error => {console.error(error)})
	
	
}  ); 





document.getElementById("one-user-btn").addEventListener("click", () => {
	fetch("https://reqres.in/api/users/2")
		.then(response => response.json() )
		.then(data => {
			
			const userInfo = data.data; 
			
			const box = document.getElementById("one-user-output"); 
			
			box.innerHTML = userInfo.first_name + "<br>" + userInfo.last_name + "<br>" + userInfo.email; 
  			
			
		}  )
		.catch(error => console.error(error) ); 
}   ); 





document.getElementById("resources-btn").addEventListener("click", () => {
	
	fetch("https://reqres.in/api/unknown")
		.then(response => response.json() )
		.then(data => {
			
			const resourceList = data.data; 
			
			const box = document.getElementById("resources-output"); 
			
			resourceList.forEach( resource => {
				
				box.innerHTML += `name : ${resource.name}  year : ${resource.year} <br> `; 
				
			}  ); 
			
			
		} ) 
		.catch(error => console.error(error)); 
}  ); 








document.getElementById("create-btn").addEventListener("click", () => {
	
	const nameVal = document.getElementById("name").value; 
	const jobVal = document.getElementById("job").value; 
		
	fetch("https://reqres.in/api/users", {
		method : "post", 
		headers : { "content-type" : "application/json"  }, 
		body : JSON.stringify( {name: nameVal,   job : jobVal  }  )
		
	})
		.then(response => response.json() )
		.then(data => { 
			
			const box = document.getElementById("post-output"); 
			
			box.innerHTML = ` name : ${data.name}  <br>  job : ${data.job}  `; 
			
		})
		.catch(error => console.error(error) )
	
} ); 






document.getElementById("delete-button").addEventListener("click", () => {
	
	const deleteId = document.getElementById("delete-id").value;
	
	fetch(`https://reqres.in/api/users/${deleteId}`,{
		
		method : "delete"
	} )
		.then(response => {
			
			if(response.status === 204){
			}				document.getElementById("delete-output").innerHTML = `${deleteId} is deleted`; 

			
		} )
		.catch(error => console.error(error) )
	
	
	
	
} ); 