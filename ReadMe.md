Environment Setup Required: 
1. Install Java8
2. Install postgresql [https://www.enterprisedb.com/downloads/postgres-postgresql-downloads]
3. Install Gradle [https://downloads.gradle.org/distributions/gradle-5.1-rc-3-bin.zip]
4. IDE used for development: Intellij

Endpoints Available:
1. http://localhost:<regular port>/discount/userType/<userType>/amount/<amount>
    This end point is used to fetch the discounted bill amount for a given bill amount
     Sample Response:
      {
          "userType": "STANDARD",
          "originalBillAmount": 1050,
          "discountedBillAmount": 1045
      }
    
2. http://localhost:<dev port>/discount/dev/upload
    Request Param key: file 
    Request Param value: csv file with the discount slabs 
    
    This is used to update the discount slabs everytime     

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
    * Kindly run `bash test.sh` file
    * Spring Boot is started in 2 Ports -one regular port and one developer port.
         The access to this developer port can be restricted to only Local office environment so as to upload the discount slabs in csv file 
         The normal client communications happen in regular port 
    