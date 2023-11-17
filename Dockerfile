FROM  openjdk:12-alpine
COPY target/5SE3-*.jar /5SE3-G8-kaddem.jar
CMD ["java", "-jar", "/5SE3-G8-kaddem.jar"]