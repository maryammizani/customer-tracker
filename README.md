# Setup the Environment


### Install MySQL (5.6) 

- http://dev.mysql.com/downloads
- Download MySQL Community server
- Install MYSQL -> Developer Default 

### Verify Installation 
- In MySQL Workbench
  - Username: root
  - Password: node
  - Port: 3306
  - Hostname: 127.0.0.1

### Create a new Connection/User
- Connect to the DB as a root user (using the password that you used during installation: 
- Open and run the script called : **“01-create-user.sql”**
- This script creates a new MySQL user for the App:
  - userId: springstudent
  - Pass: springstudent
- To test if this user is created correctly, close the current connection(user: root) in Workbench and create a new connection:
  - Connection Name: springstudent
  - UserName: springstudent
  - Click: Test Connection


### Create a new DB:
- Connect to the DB as user = springstudent 
- Open and run this script: **“02-customer-tracker.sql”**
- This script will create a new DB called  web_customer_tracker
- Inside that DB, it will create a new table called “customer”
- Refresh the Schemas to see the created DB/Table


# Create a Dynamic Web Project in Eclipse:
- Create a new  Dynamic Web Project: file -> New -> Project -> Web -> Dynamic Web Project
  - Name: customer-tracker
  - Dynamic web module version: 3.1
  - Source Folder: src
  - Content directory: WebContent

# Add MYSQL JDBC Driver:
- Go to:  https://dev.mysql.com/
- My SQL Downloads -> MySQL Community Downloads -> Connector/J
- Download **Platform Independent** zip file and copy this file under the eclipse project lib folder:
- **mysql-connector-java-8.0.26\mysql-connector-java-8.0.26\mysql-connector-java-8.0.26.jar**
- Copy mysql-connector-java-8.0.26.jar and paste it under WebContent/WEB-INF/lib

### Test your JDBC Connection:
- Run “TestDbServlet"
- This file was created by creating a new Servlet under com.demo.testdb 


# Create Starter Config Files:
- WebContent/WEB-INF/lib/Web.xml
- WebContent/WEB-INF/lib/spring-mvc-crud-demo-servlet.xml
  - Define database dataSource/connectionPool
  - Setup Hibernate Session Factory
  - Setup Hibernate Transaction Manager
  - Enable Config of Transactional annotation
  
  
# Add JSTL (JSP Standard Tag Library) Libs
Add these 2 files under WebContent/WEB-INF/lib:
- WebContent\WEB-INF\lib\javax.servlet.jsp.jstl-1.2.1.jar
- WEB-INF\lib\javax.servlet.jsp.jstl-api-1.2.1.jar


# Add Spring JAR files 
- Go to https://repo.spring.io/ui/native/release/org/springframework/spring
- Download Spring Jar files -> version 5.2.3.RELEASE -> spring-5.2.10.RELEASE-dist.zip 
- Unzip the file and copy all the JAR files under the lib folder
- Copy them under WebContent/WEB-INF/lib


# Add Hibernate JAR Files:
- Go to: https://hibernate.org/
- Click on Hibernate ORM
- Download hibernate-release-5.5.5.final
- Extract the zip file
- Copy all the files in: **hibernate-release-5.5.5.Final\lib\required**
- Paste them in eclipse project under the WebContent\WEB-INF\lib folder

### Copy the files for Database connection pooling
- Copy all 3 files in: hibernate-release-5.5.5.Final\lib\optional\c3p0
- Paste them in eclipse project under  WebContent\WEB-INF\lib folder

- For Java 9 and higher, you need additional JAR files. 
  - javax.activation-1.2.0.jar 
  - jaxb-api-2.3.0.jar 
  - jaxb-core-2.3.0.jar 
  - jaxb-impl-2.3.0.jar


### Test Basic Spring MVC Controller:
- Create a new Java class: com.demo.springdemo.controller.CustomerController
- Create WebContent\WEB-INF\view\list-customers.jsp
- Right click on the project and run as Server

### Add AspectJ Weaver to be used for AOP Logging:
- Download aspectjweaver-1.8.13.jar from https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
- Paste it under WebContent>WEB-INF>lib
- Enable AspectJ Auto Proxy in spring-mvc-crud-demo-servlet.xml
