INSERT INTO users(username, password) values('simon', '$2a$12$kQwjCvxWFRFLrAktcs.Lj.Opv2NeDSX1o/5nhWkSQYHidythmI8ua'); 


INSERT INTO roles(roleName) VALUES('ROLE_USER'),('ROLE_ADMIN');



INSERT INTO user_role(userId, roleId) VALUES(1, 1),(1,2);




INSERT INTO students(name) VALUES('kate'),('james'); 