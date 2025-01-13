-- Roles 테이블 초기 데이터
INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

-- Users 테이블 초기 데이터
-- 비밀번호는 '1234'를 BCrypt로 암호화한 값
INSERT INTO users (id, username, password) VALUES (1, 'admin@gmail.com', '$2a$10$vbx/wZhFNGNtUzb18jI.oepT3rlgNZCk9SU6agZjBFeN2yWvtu5My');
INSERT INTO users (id, username, password) VALUES (2, 'user@gmail.com', '$2a$10$vbx/wZhFNGNtUzb18jI.oepT3rlgNZCk9SU6agZjBFeN2yWvtu5My');

-- User_Role 테이블 초기 데이터 (Users와 Roles 간의 매핑)
INSERT INTO user_role (id, user_id, role_id) VALUES (1, 1, 1); -- admin@gmail.com -> ROLE_ADMIN
INSERT INTO user_role (id, user_id, role_id) VALUES (2, 2, 2); -- user@gmail.com -> ROLE_USER
