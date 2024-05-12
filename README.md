# Renault Web System API
This is a Java API system developed for the Renault web system, aimed at facilitating data management and communication within the Renault ecosystem. The API is built using Java and Spring Boot framework, with MySQL as the underlying database to persist the data sent by the system.

## Features

- RESTful API: Provides endpoints for various functionalities required by the Renault web system.
- Data Persistence: Utilizes MySQL database to store and manage the data efficiently.
- Security: Implements security measures to protect sensitive data and ensure secure communication.
- Scalability: Designed with scalability in mind to accommodate future growth and increased demand.
  
## Installation
1. To run this project locally, follow these steps:

```bash
git clone https://github.com/victormuller55/api-renault-system.git
```
2. Navigate to the project directory:
```bash
cd api-renault-system
```
3. Configure the MySQL database settings in application.properties file:
```properties
spring.application.name=your-name-aplication
server.adress=your-ip-aplication
server.port=your-port-aplication
spring.datasource.url=your-database-url-aplication
spring.datasource.username=your-username-aplication
spring.datasource.password=your-password-aplication
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
spring.http.multipart.max-file-size=5MB
spring.http.multipart.max-request-size=5MB
```
4. Build the project using Maven:
```bash
mvn clean install
```
5. Run the application:
```bash
mvn spring-boot:run
```
## Acknowledgements
- This project was developed using Java and Spring Boot framework.
- Special thanks to the developers of MySQL for providing a robust database solution.
- Thanks to all contributors who helped improve this project.
