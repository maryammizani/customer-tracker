# MySQL Setup

### Download MySQL (5.6) 

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


# Setup a new Dynamic Web Project in Eclipse:
- Create an Eclipse Project
- Create a new  Dynamic Web Project: file -> New -> Project -> Web -> Dynamic Web Project
  - Name: customer-tracker
  - Dynamic web module version: 3.1
  - Source Folder: src
  - Content directory: WebContent

### Download MYSQL JDBC Driver:
- Go to:  https://dev.mysql.com/
- My SQL Downloads -> MySQL Community Downloads -> Connector/J
- Download **Platform Independent** zip file and copy this file under the eclipse project lib folder:
- **mysql-connector-java-8.0.26\mysql-connector-java-8.0.26\mysql-connector-java-8.0.26.jar**

### Add mysql JAR File to the WebContent/WEB-INF/lib
- Copy mysql-connector-java-8.0.26.jar that you just downloaded under WebContent/WEB-INF/lib

### Testing your JDBC Connection:
- Run “TestDbServLet"






