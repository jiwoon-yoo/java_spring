create table SEC_USER
(
	userId BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	email VARCHAR(75) NOT NULL UNIQUE,
	encryptedPassword VARCHAR(128) NOT NULL,
	enabled BIT NOT NULL
) ;

create table SEC_ROLE
(
	roleId BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	roleName VARCHAR(30) NOT NULL UNIQUE
) ;

create table USER_ROLE
(
	ID BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	userId BIGINT NOT NULL,
	roleId BIGINT NOT NULL
);



alter table USER_ROLE
add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
add constraint USER_ROLE_FK1 foreign key (userId)
references SEC_USER (userId);

alter table USER_ROLE
add constraint USER_ROLE_FK2 foreign key (roleId)
references SEC_ROLE (roleId);





CREATE TABLE pluginev( 
	id LONG PRIMARY KEY AUTO_INCREMENT, 
	vehiculemake VARCHAR(255), 
	vehiculemodel VARCHAR(255),
	enginetype VARCHAR(255), 
	purchaseDate DATE, 
	purchaseTime TIME 
); 



