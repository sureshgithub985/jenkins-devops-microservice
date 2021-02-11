//declartive pipelline

pipeline{
    //agent any
    agent {
        docker { image 'maven:3-openjdk-8-slim' }
    }
    stages {
        stage('Build'){
            steps {
                //sh 'node --verison'
                echo "Build"
            }
        }
        stage('Test'){
            steps {
                echo "Test"
            }
        }
        stage('Integration Test'){
            steps {
                echo "Integration Test"
            }
        }
    }
    post {
        always {
            echo "Iam awesome i run always"
        }
        success {
            echo "i run only in case of success"
        }
        failure {
            echo " I run only in case of failure"
        }
    }
}