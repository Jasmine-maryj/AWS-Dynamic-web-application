# AWS-Dynamic-web-application
This is a Spring Boot project that connects to Amazon Web Services (AWS) DynamoDB. It provides a web interface where users can add data, which is then stored in DynamoDB. Additionally, it sends notifications to the user's phone number.

# Table of Contents

- Prerequisites
- Installation
- Configuration
- Usage
- Technologies Used

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher installed.
- AWS account with DynamoDB configured.
- IDE of your choice (e.g., IntelliJ, Eclipse)

## Installation

1. Clone this repository:
 ```bash
  git clone https://github.com/your-username/your-project.git
 ```
2. Build the project using Maven
```bash
   mvn clean install
  ```
## Configuraion

1. AWS DynamoDB Configuration:

Set up your AWS credentials and configure the AWS SDK to access DynamoDB. You can do this by setting environment variables or using AWS CLI's aws configure command.

2. Web Application Configuration:

Configure the web application settings such as the server port, database connection, etc., in the application.properties (or application.yml) file.

## Usage

1. Start the Spring Boot Application:
 ```bash
  mvn spring-boot:run
```
2. Access the web application in your browser by navigating to http://localhost:8080 (or the configured port).

3. Use the web interface to add data. The data will be stored in DynamoDB.

4. Users will receive notifications on their phone numbers when data is added successfully.

## Technologies Used
- Spring Boot
- AWS DynamoDB
