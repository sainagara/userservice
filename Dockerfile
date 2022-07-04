From openjdk:11
EXPOSE 9001
copy ./target/Ecommerce_User_Registration-0.0.1-SNAPSHOT.jar Ecommerce_User_Registration-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","Ecommerce_User_Registration-0.0.1-SNAPSHOT.jar"]