#!/bin/bash
set -e

echo "Dropping existing databases.."
dropdb -U postgres -h localhost --if-exists discount_service_test

echo "Creating base databases"
createdb -U postgres -h localhost  discount_service_test

echo "Building Discount Service jar.."
spring_config_location=config/test/application.yml logging_config=config/test/log4j2-spring.xml ./gradlew clean build
