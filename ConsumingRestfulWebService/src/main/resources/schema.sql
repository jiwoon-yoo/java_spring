CREATE TABLE users(
	
	userId INT PRIMARY KEY AUTO_INCREMENT, 
	username VARCHAR(50), 
	password VARCHAR(100)
); 

CREATE TABLE roles(

	roleId INT PRIMARY KEY AUTO_INCREMENT, 
	roleName VARCHAR(50)
); 

CREATE TABLE user_role(

	id INT PRIMARY KEY AUTO_INCREMENT, 
	userId INT, 
	roleId INT, 
	FOREIGN KEY(userId) REFERENCES users(userId), 
	FOREIGN key(roleId) REFERENCES roles(roleId)
);



CREATE TABLE students(

	studentId INT PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(50)
);



