## Message Scheduler

**Setup**

 - Spring Tool Suits 4 
 - MySQL workbench 
 - https://start.spring.io/  (2.2.4) used to create spring boot setup with following lib
		 - SpringWeb, Quartz Schedular, SPring boot devtools, Spring data JPA, MYSQL Driver
		 - Quartz is used for scheduling the message which used MySql data source for persisting message. 

**MySQL setup**

 - create database locally (ex: quartz)
		 - CREATE DATABASE quartz
 - setup username (quartz) and password (ex: quartz123)
		 - CREATE USER 'quartz'@'localhost' IDENTIFIED BY 'quartz123';
		 - 	GRANT ALL ON quartz.* TO 'quartz'@'localhost';
 - run the sql script provided in the project under resources/sql folder which was downloaded from quartz lib - https://github.com/quartz-scheduler/quartz/releases

**Setup Locally**

 - clone the branch
 - maven install
 - Maven - update project
 - Right click Application.java and run as Java Application which internally start embedded tomcat.

**Test Application**

 - Use any client to fire POST request example postman
 - Post request expect 2 parameter 
		 -  message schedule time which is specific date time format
		 - message content
 
 URL - http://localhost:8080/schedule-message

    {
	"timestamp":"2020-02-08T21:46:00",
	"content": "Hello my friend 59"
	}

Response
"ACCEPTED" if message is scheduled or "INTERNAL SERVER ERROR" if message is not scheduled.


