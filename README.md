# Xplorer

Xplorer is a Spring Boot application developed by Moj Fazel as part of job interview. 

## Installation

Clone the repo and run it on a Java IDE. Alternatively you can dowlonad the .jar file and run the following command:

```bash
java -jar Xplorer-0.0.1-SNAPSHOT.jar

```

## Usage
You can use this app on the web on this address: 
http://localhost:8080
When the application starts, it provides a cli simultaneously to get the path from the user and show the result.

Also it provides the follwoing api which returns a Json object. Please make sure to replace "\\" with "/" in your pathname(e.g. C:/); Otherwise you will get an error:
http://localhost:8080/api?path={pathname} 

