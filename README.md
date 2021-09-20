# This is base project created for candidate for technical interview.

## Requirements
- Installed Chrome browser.
- Java 11
- Maven
- Git

## Running tests in the project

- Running **RunTest.java** with your favourite IDE
- Use **mvn clean verify**

## Database H2 connection
When the application starts(AtApplication.class & Run) please search for the string in the application logs:

H2 console available at '/h2-console'. Database available at

In that log message a JDBC URL will be provided. It can be used to access the currently running H2 DB through the H2 web console: http://localhost:9081/h2-console

If there's a problem you can also use http://sqlfiddle.com/#!9/8700a3/