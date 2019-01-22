This is an Example to show some skills for my job application.

What you’ll need

JDK 1.8
Maven 3.2
MySqlServer 5

This application can be compiled under Windows & Linux.
To run the server stand alone is tested and configured only under Unix.

You can configure to target a new DB by configuring application.proprerties in the right way as the documentation of Spring

To run this stand alone server you have to start MySql before.

to complile run in main directory

mvn clean install

to compile and run

mvn package && java -jar target/example1-0.0.1-SNAPSHOT.jar

Skipping test
mvn clean install -DskipTests

mvn package -DskipTests && java -jar target/gs-spring-boot-0.1.0.jar

The example page can be loaded from 127.0.0.1:8080/index in your browser, ENJOY

Know Issues

the application works only with java version 1.8, to change the java version

sudo update-alternatives --config java
