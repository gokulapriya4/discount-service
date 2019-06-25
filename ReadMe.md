Environment Setup Required: 
1. Install Java8
2. Install postgresql [https://www.enterprisedb.com/downloads/postgres-postgresql-downloads]
3. Install Gradle [https://downloads.gradle.org/distributions/gradle-5.1-rc-3-bin.zip]
4. IDE used for development: Intellij

Steps for Local development:
 * Set the Environment variables in intellij Run configurations as
       spring_config_location=config/development/application.yml 
       logging_config=config/development/log4j2-spring.xml
 
 * Create database in postgresDB as 
        createdb -U postgres -h localhost  discount_service_test      
  
Steps to build and execute tests:
 * Ensure the correctness of postgres credentials in application.yml file in test folde
 * Run the `test.sh` file
 
 Note to Interviewer:
    Kindly run `bash test.sh` file