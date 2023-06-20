insert into SEC_User (email, encryptedPassword, ENABLED)
values ('simon.hood@sheridancollege.ca', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

insert into SEC_User (email, encryptedPassword, ENABLED)
values ('jonathan.penava@sheridancollege.ca', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);


insert into sec_role (roleName)
values ('ROLE_ADMIN');

insert into sec_role (roleName)
values ('ROLE_USER');



insert into user_role (userId, roleId)
values (1, 1);

insert into user_role (userId, roleId)
values (1, 2);

insert into user_role (userId, roleId)
values (2, 2);





INSERT INTO pluginev(vehiculemake, vehiculemodel, enginetype, purchaseDate, purchaseTime) VALUES 
('GM', 'Volt', 'Electric', '2020-01-01', '12:00:00'), 
('Nissan', 'Leaf', 'Gas Electric', '2020-02-02', '08:15:00'), 
('Hyundai', 'Elantra', 'Hybrid', '2020-03-03', '14:30:00'); 
