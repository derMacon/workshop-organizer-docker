pipeline {

    environment {
        registry = "dermacon/jenkins-test"
        registryCredentials = 'dermacon'
    }

    agent any

    tools {
        maven 'Maven 5.4.0-42-generic'
        jdk 'JDK 11.0.8'
    }

    stages {

        stage ('Maven Build') {
            steps {
                dir('workshop-app') {
                    sh 'mvn clean package'
                }
            }
        }

        stage ('Build Docker Image') {
            steps {
                dir('workshop-app') {
                    sh 'docker-compose build'
                }
            }
        }

        stage ('Run Docker Containers') {
            steps {
                dir('workshop-app') {
                    sh 'docker-compose down'
                    sh 'docker-compose up -d'
                }
            }
        }
       
    }
}
