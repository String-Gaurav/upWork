# DemoProject
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [About Test Framework](#about-test-framework)
* [Reporting](#reporting)

## General info
 Outline a brief description of this project.
- Selenium Framework with TestNG
- TestNG based Framework

	
## Technologies
Project is created with:
* JAVA Version - jdk1.8.0_291
* Selenium-WebDriver version- 3.141.59
* 
* TestNG Version - 7.3.0

## Setup
- Intall java from - https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
Setup JAVA_HOME path
- Install MAVEN- https://maven.apache.org/download.cgi
Setup .M2 and MAVEN_HOME path as per the below screenshot
![image](https://user-images.githubusercontent.com/88622330/128636681-414f6dab-7205-4725-97be-b94fe36d5864.png)
- Download and Import the project.
- Let MAVEN to install all the dependencies.
- Run Below MAVEN Commands in CMD.

```
 mvn clean
 mvn compile
 mvn test
  ``` 
	
## About Test Framework
The framework has following features

* Maven based framework
* Log4j enabled for logging
* Integrated HTML adn PDF report by using Extent Spark lib/plugins
* Centralized Configuration (Using Properties file)

**Same Commands can be configured in CICD tools like Jenkins, TeamCity**

MAVEN COMMANDS:-

* mvn clean
* mvn compile

## Reporting
	
 * 1-Reporting of all the test cases.
 * 2-Can check the error logs.
 * 3-Check the screenshot where the test case is failing.
  
  



```
