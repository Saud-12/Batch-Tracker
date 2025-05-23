# Twinleaves Backend Task- Batch-Tracker

A REST API System for managing product inventory with GTIN(Global Trade Item Number) support, batch
tracking, and quantity management

## Batch-Tracker Live link
https://batch-tracker-z5wn.onrender.com/api/v1/swagger-ui/index.html#/

### Business Logic Summary
The smart invenotry API implements the following logic:

POST API: To create rows in all tables

GET API: To query based on gtins.

Postive Quantities: Returns all batches with available quantity>0

Non-positive Quantities: For batches with available Quantity<=0 , returns only the most recent batch based on inwarded On date

### Tech Stack
* Language: Java
* Framework: Spring
* Database: MySQL
* Documentation: SwaggerUI

### Getting Started

1. **Clone the repository**:
```bash
git clone https://github.com/Saud-12/Batch-Tracker-.git
cd Batch-Tracker
```
2. **Configure MySQL**:
    Set up a MySQL database and update the application.properties file with your database connection details.
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password

3. **Build and run the application**:
   ```bash
   ./gradlew build
    ./gradlew bootRun
   
