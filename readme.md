WEBAPP By Mohammed S Uddin
==========================

Description
-----------
To create a Java web app and build a web driver test framework to support it.

Purpose
-------
The focus of this project is to write a basic web app with the following functionality:
- Write a web app using servlets, jsp with attention to the MVC model
- App runs off a local database
- Use builder to help persist data to local database as means of setting up test data
- Write tests on all levels i.e. unit, integration and full stack

Technology used
---------------
- Java 1.7
- Servlets
- JSP
- SQL
- JDBC:MySQL
- WebDriver
- Gradle

Methodologies
-------------
- MVC Model
- Singleton Pattern
- Data Access Object

Installation / Run Instructions
-------------------------
1. Clone the project
2. Import the project as a Gradle project using build.gradle using your IDE
3. Run gradle build (can use the wrapper if you like) using gitbash
4. Grab the jar file generate in build/lib
5. Copy the jar file into your tomcat/webapp directory
6. Go to locahost:8080
7. Select manager app
8. Select Webapp
9. You will need a local installation of mysql database named tstdb

Outstanding tasks
-----------------
- Write cucumber functional tests
- Write unit and integration tests using mock frameworks
- Write driver handler
- Write business logic classes
- Write database scripts
- Write build script which also runs unit and integration tests
- Write tests using Web driver