# REST API for an Online Food Delivery Application
This project is developed by team of 5 members during project week in Masai School. It can perform all the fundamental CRUD operations like add, update, view, delete etc with user validation.

## Tech Stack and Tools
- Java
- Spring Boot
- Spring Framework
- Spring Data JPA
- Hibernate
- MySQL
- Swagger-UI
- Lombok

## Modules
- Login Module
- Restaurant Module
- Customer Module
- Order Module
- Items Module
- Food Cart Module
- Bill Module

## Features
- Customer and Admin authentication & validation with session uuid.
- Admin Features:
 - Only registered admins with valid session id can do the CRUD operations like add/update/delete.
 - Admin can add restaurants and food items.
 - Admin can remove restaurants and items.
 
- Customer Features:
 - Customer can register themselves with the application.
 - Customer can login to get the valid session token(id).
 - View list of available items.
 - Add items to food cart and placing the order.
 - View cart details, update and access other features
 
## Installation & Run
- To run this API server, you should update the database config inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database config.

```
server.port=8008
spring.datasource.url=jdbc:mysql://localhost:3306/FoodExpress;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
```
## API Root Endpoint
```
https://localhost:8888/
```
```
https://localhost:8888/swagger-ui.html
```
