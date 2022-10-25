FROM openjdk:17
EXPOSE 8081
ADD /target/ms-BankAccount-0.0.1-SNAPSHOT.jar ms-BankAccount-1.0.0.jar
ENTRYPOINT ["java", "-jar","ms-BankAccount-1.0.0.jar"]