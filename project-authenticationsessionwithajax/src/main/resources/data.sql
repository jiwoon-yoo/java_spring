-- Roles 테이블 초기 데이터
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

-- Users 테이블 초기 데이터
-- 비밀번호는 '1234'를 BCrypt로 암호화한 값
INSERT INTO users (username, password) VALUES ('admin@gmail.com', '$2a$12$izwvfOKZmrvStkhdVdHUAeGW0D5pfSk/pHpvzUI6FOb.dzYUWfqDq');
INSERT INTO users (username, password) VALUES ('user@gmail.com', '$2a$12$izwvfOKZmrvStkhdVdHUAeGW0D5pfSk/pHpvzUI6FOb.dzYUWfqDq');

-- User_Role 테이블 초기 데이터 (Users와 Roles 간의 매핑)
INSERT INTO user_role (user_id, role_id) VALUES (1, 1); -- admin@gmail.com -> ROLE_ADMIN
INSERT INTO user_role (user_id, role_id) VALUES (2, 2); -- user@gmail.com -> ROLE_USER
