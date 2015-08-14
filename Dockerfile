FROM sonarqube:5.1
COPY target/*.jar /opt/sonarqube/extensions/plugins/
