# ScheduleApp
The ScheduleApp is a web application designed to manage schedules, courses, groups, students, professors, and timetables for a university.  
It provides different functionalities and views based on the user's role: User, Professor, or Admin.  
# Features
# Common Features
Login or Sign up: Users can either log in with their credentials or sign up for a new account.  
Login: Users can log in using their username and password.  
Sign up: Users can register for a new account by providing their name, email, and password.  

# User Role
Users with the "User" role have access to the following features:  
Group Information: Users can view information about their group.  
Today's Schedule: Users can see the schedule for the current day or the upcoming day, depending on their ongoing classes.  
Schedule Header: Users can filter the schedule view by selecting options like "Week," "Month," or "Today." The page will reload based on the selected filter.  

# Professor Role
Users with the "Professor" role have access to the following features:  
Professor Information: Professors can view their personal information, including their name and email.  
List of Courses Taught: Professors can access a new screen displaying a table of the courses they teach.  
List of Groups Taught: Professors can access a new screen displaying a table of the groups they teach.  
Schedule Header: Professors can filter the schedule view by selecting options like "Week," "Month," or "Today".  
The page will reload based on the selected filter.  

# Admin Role
Users with the "Admin" role have access to the following features:  
Timetable for the University: Admins can view a table with the timetable for the entire university for one week.  
Student Management: Admins can add and delete new students.  
Group Management: Admins can add and delete new groups.  
Course Management: Admins can add and delete new courses.  
Professor Management: Admins can add and delete new professors.  
Timetable Management: Admins can manage the timetable for the university.  

# Usage
To use the ScheduleApp, follow these steps:  
Log in or Sign up for an account.  
Depending on your role, you will have access to different features and functionalities.  
Navigate through the application using the menu to access various screens and perform actions specific to your role.  

# Technologies Used
The ScheduleApp is built using the following technologies and frameworks:  
Spring Boot: A Java framework for building web applications.  
Spring Security: Provides authentication and authorization functionalities for securing the application.  
Spring Data JPA: Simplifies the interaction with the database using the Java Persistence API (JPA).  
Thymeleaf: A modern server-side Java template engine for rendering views.  
Flyway Migration: Handles version control for the database schema and migrations.  
H2 Database or PostgreSQL: Options for the underlying database storage.  

# Getting Started
To get started with the ScheduleApp, follow these steps:  
Clone the repository to your local machine.  
Set up the database using either H2 Database or PostgreSQL.  
Configure the database connection in the application properties.  
Build and run the application using your preferred IDE or the command line.  
Access the application in your web browser at the specified URL.  

# Testing
The ScheduleApp includes comprehensive testing to ensure the functionality and reliability of the application.  
The following types of tests are implemented:  
Unit Tests: Tests individual units of code, such as repositories, services, and controllers, in isolation.  
Integration Tests: Tests the integration between different components of the application, ensuring they work together correctly.  
End-to-End Tests: Tests the application as a whole, simulating user interactions and verifying the expected outcomes.  
To run the tests, use the testing framework or tools provided by your IDE or run the test command from the command line.  

# Dependencies
The ScheduleApp has the following dependencies:  
Spring Boot Starter Web: Provides the necessary dependencies to build web applications using Spring MVC.  
Spring Boot Starter Security: Includes dependencies for integrating Spring Security into the application.  
Spring Boot Starter Data JPA: Provides support for using JPA with Spring Data.  
Thymeleaf: A modern server-side Java template engine for rendering views.  
Flyway Core: Handles database schema version control and migration.  
H2 Database or PostgreSQL Driver: Depending on the chosen database, either the H2 database driver or the PostgreSQL driver is required.  
Spring Boot Starter Test: Includes dependencies for testing Spring Boot applications.  
JUnit: A popular testing framework for Java applications.  
Mockito: A mocking framework used for creating mock objects in unit tests.  
Hamcrest: A library of matcher objects for creating assertions in tests.  
AssertJ: A fluent assertion library for writing more expressive test assertions.  
Spring Boot DevTools: Provides additional development-time features such as automatic restarts and enhanced logging.  
These dependencies are managed by the build tool (e.g., Maven or Gradle) and will be downloaded automatically when building the application.  


