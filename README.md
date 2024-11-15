# SauceDemo Automation Framework

## Overview
This is an automated testing framework for SauceDemo website using Selenium WebDriver with Cucumber BDD framework in Java. The framework demonstrates automated login,  Highest priced product selection and adding to cart functionality.

## Features
- Login to SauceDemo website
- Select highest priced item
- Add selected item to cart
- BDD approach using Cucumber
- Page Object Model design pattern

## Prerequisites
- Java JDK 8 or higher
- Maven
- Chrome browser
- ChromeDriver
- IDE (Ec[sauceDemo.feature](src/test/resources/features/sauceDemo.feature)lipse/IntelliJ)

## Project execution
mvn clean test - To clean and run the test

mvn test -Dcucumber.options="--tags @yourTag" - To run using Tag
