pipeline {
    environment {
        registry = "dermacon/jenkins-test"
        registryCredentials = 'dermacon'
        dockerImage = ''
        TOMCAT_WEBAPPS_DIR = '/opt/tomcat/webapps/'
    }
    agent any
    tools {
        maven 'Maven 5.4.0-42-generic'
        jdk 'JDK 11.0.8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    mvn -v
                    pwd
                '''
            }
        }

        stage ('Maven Build') {
            steps {
                
                sh 'mvn clean package'
            }
        }

        stage ('Tomcat Deploy') {
            steps {
                    sh 'echo "about to push war to git"'
                    sh 'ls -la ./target/'
                    sh 'chmod 777 tomcat-deploy.sh'
                    sh './tomcat-deploy.sh'
                    sh 'git rev-parse --is-inside-work-tree'

            }
        }
       
    }
}
