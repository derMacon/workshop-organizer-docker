FROM tomcat:8.0.51-jre8-alpine
ADD target/sample.war /usr/local/tomcat/webapps/
EXPOSE 8888
CMD ["catalina.sh", "run"]
