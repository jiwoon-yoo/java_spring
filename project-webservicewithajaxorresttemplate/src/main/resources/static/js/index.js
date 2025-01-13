

document.getElementById("getButton").addEventListener("click", () => {
	
	fetch("https://reqres.in//api/users?page=2", {}   )
		.then(response => response.json() )
		.then(data => {
			
			
			
		})
		.catch(error => {console.error(error)})
	
	
}  ); 