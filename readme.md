Proto-type Web App By Mohammed S Uddin
======================================

Description
-----------
To create a Java web app and build a web driver test framework to support it.
This is a prototype project and as a result has many gaps. The focus here is
not to complete it but to simply write a project with the focal aim of learning
how these technologies work.

Purpose
-------
The focus of this project is to write a basic web app with the following functionality:
- Write a web app using servlets, jsp with attention to the MVC model
- App runs off a local database
- Use builder to help persist data to local database as means of setting up test data
- Write tests using Selenium WebDriver and assertions

Technology used
---------------
- Java 1.7
- Servlets
- JSP
- SQL
- JDBC:MySQL
- WebDriver
- Gradle
- Selenium WebDriver
- JUnit

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
5. Copy the jar file into your tomcat/webapp directory and run your instance of Tomcat
6. Go to locahost:8080
7. Select manager app
8. Select Webapp
9. You will need a local installation of mysql database named tstdb

Known Issues
------------
- After logging or registering, navigating back returns a https 500 internal error
- Running instance of Tomcat needed before running Gradle Build to allow test to work
- Test does not perform any assert since a connection to DB is not established during gradle build