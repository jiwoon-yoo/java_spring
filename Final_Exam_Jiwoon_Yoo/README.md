Part 2: Bean (15 marks) 
Create a PlugInEV Bean or POJO that contains the following fields :
•	ID: Auto generated when added into the database 
•	A private String VehiculeMake 
•	A private String VehiculeModel
•	A private String EngineType
•	A private LocalDate purchaseDate
•	A private LocalTime purchaseTime

Part 3: Schema.sql and H2 Table (5 marks) 
In an SQL file, create a table for the bean where columns match the fields.  Create at least 3 sample records to be generated when the program starts. Consider the following statements: 
CREATE TABLE pluginev( 
id LONG PRIMARY KEY AUTO_INCREMENT, 
vehiculemake VARCHAR(255), 
vehiculemodel VARCHAR(255),
enginetype VARCHAR(255), 
purchaseDate DATE, 
purchaseTime TIME 
); 

INSERT INTO pluginev(vehiculemake, vehiculemodel, enginetype, purchaseDate, purchaseTime) VALUES 
('GM', 'Volt', 'Electric', '2020-01-01', '12:00:00'), 
('Nissan', 'Leaf', 'Gas Electric', '2020-02-02', '08:15:00'), 
('Hyundai', 'Elantra', 'Hybrid', '2020-03-03', '14:30:00'); 

Part 4: addItem EDIT/UPDATE (5 marks) 
Create an add item HTML page that will add a PlugInEV item to the database.  After adding a PlugInEV item your program should return to the add item page.   


Part 5: Controller (5 marks) 
Display all Manufacturing items in an HTML page.  This should be done in a well formatted HTML table with column headings for each field.
Create a Controller called PlugInEVController in a ca.sheridancollege.<yourUserName>.controllers package.  Inside, create methods mapped to “/”, insertPlugInEV, editPlugInEV, and deletePlugInEV for the different CRUD operations.

Part 6: index.html (6 marks edit, 4 marks delete) 
Create an index.html.
Your index.html page should automatically display all entered PlugInEV at launch (i.e. loading of “/”), along with unique Edit and Delete buttons for each, and then provide your users a simple form where they can enter additional PlugInEVs info following the POJO. 
Make use of Thymeleaf Fragments in your FRONT-END file(s).

Part 7: Database Access and Config (5 marks) 
Create the DatabaseAccess.java and the DatabaseConfig.java files in a ca.sheridancollege.<yourUserName>.database package.

Part 8: Database Security (5 marks) 
Create a secure system which uses a database to store users with salted passwords. Use your database users for authentication. (based on exercise 9-1)
Use H2 embedded database for user storage.


<korean>
파트 2: Bean (15점)
PlugInEV Bean 또는 POJO를 생성합니다. 다음 필드를 포함해야 합니다:
• ID: 데이터베이스에 추가될 때 자동으로 생성됨
• private String VehiculeMake
• private String VehiculeModel
• private String EngineType
• private LocalDate purchaseDate
• private LocalTime purchaseTime

파트 3: Schema.sql 및 H2 테이블 (5점)
SQL 파일에서 Bean을 위한 테이블을 생성하고, 열이 필드와 일치하도록합니다. 프로그램이 시작될 때 생성될 적어도 3개의 샘플 레코드를 만듭니다. 다음 명령문을 고려해보세요:
CREATE TABLE pluginev(
id LONG PRIMARY KEY AUTO_INCREMENT,
vehiculemake VARCHAR(255),
vehiculemodel VARCHAR(255),
enginetype VARCHAR(255),
purchaseDate DATE,
purchaseTime TIME
);

INSERT INTO pluginev(vehiculemake, vehiculemodel, enginetype, purchaseDate, purchaseTime) VALUES
('GM', 'Volt', 'Electric', '2020-01-01', '12:00:00'),
('Nissan', 'Leaf', 'Gas Electric', '2020-02-02', '08:15:00'),
('Hyundai', 'Elantra', 'Hybrid', '2020-03-03', '14:30:00');

파트 4: addItem EDIT/UPDATE (5점)
데이터베이스에 PlugInEV 항목을 추가하는 add item HTML 페이지를 생성합니다. PlugInEV 항목을 추가한 후 프로그램은 add item 페이지로 돌아와야 합니다.

파트 5: Controller (5점)
HTML 페이지에 모든 제조 항목을 표시합니다. 각 필드에 대한 열 제목이 있는 잘 정돈된 HTML 테이블로 표시해야 합니다.
ca.sheridancollege.<yourUserName>.controllers 패키지에 PlugInEVController라는 컨트롤러를 생성합니다. 안에는 " / ", insertPlugInEV, editPlugInEV 및 deletePlugInEV에 대한 다른 CRUD 작업에 매핑된 메서드를 생성합니다.

파트 6: index.html (6점 편집, 4점 삭제)
index.html을 생성합니다.
index.html 페이지는 시작할 때 입력된 모든 PlugInEV를 자동으로 표시해야 하며, 각각에 대해 고유한 편집 및 삭제 버튼을 제공하고 사용자가 POJO를 따라 추가적인 PlugInEV 정보를 입력할 수 있는 간단한 양식을 제공해야 합니다.
FRONT-END 파일에서 Thymeleaf Fragments를 사용하세요.

파트 7: Database Access 및 Config (5점)
ca.sheridancollege.<yourUserName>.database 패키지에 DatabaseAccess.java 및 DatabaseConfig.java 파일을 생성합니다.

파트 8: Database Security (5점)
암호화된 비밀번호로 사용자를 저장하기 위해 데이터베이스를 사용하는 보안 시스템을 생성합니다. 인증에 데이터베이스 사용자를 사용합니다. (연습 문제 9-1을 기반으로 함)
사용자 저장을 위해 H2 내장 데이터베이스를 사용하세요.
