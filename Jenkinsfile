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

        stage ('Initialize') {
            steps {
                sh 'cd workshop-organizer'
            }
        }

        stage ('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage ('Build Docker Image') {
            steps {
                sh 'docker-compose build'
            }
        }

        stage ('Run Docker Containers') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose up -d'
            }
        }
       
    }
}
