pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning repository...'
                git 'https://github.com/Chintharlaakshaya/jenkinsgitintegration.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                bat 'echo Build command here'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'echo Test command here'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying project...'
                bat 'echo Deploy command here'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
