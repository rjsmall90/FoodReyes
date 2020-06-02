# FoodReyes
This REST API was intended as a backend for a store/restaraunt, customer-facing ordering application. Customer would be able to enter location, then use application to add **Items** to a **Cart** and checkout.
A simple CRUD repository, allows storage and retrieval of **Items** into/from a PostgreSQL database.
**Cart** is defined by orderNumber, list of **Items**, and total amount.

An **Item** is defined by it's name, price & quantity.  **Inventory** is the management service for the **Items**
\ **Items** would be stored in database to be called on by the application, while customer **Cart** would be cataloged and **Inventory** updated.

*Future versions would have established an adminstrator and OAuth components in order to update* **Inventory** *by adding* **Items**. 


## Getting Started
To get started clone the repository to your local server. When accessing the project in preferred IDE in order to import the dependencies automatically, select start a new project from existing source, find FoodReyes folder, and open the project from the pom.xml file.
Right now the database will have to be established locally. Once the database has been created, head to appliation.properties and update properties with local database info:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/**add database name here**
spring.datasource.username=**postgres database username**
spring.datasource.password=**postgres database password**
```
Once completed, proceed to MenuApplication.java and select 'Run'. 


### What You'll Need (Prerequisites)
* Java 8 
* Maven
* PostgreSQL
