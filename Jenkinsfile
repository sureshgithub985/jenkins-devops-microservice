//declartive pipelline

pipeline{
    agent any
    //agent {
      //  docker { image 'node:14.15.5-buster' }
    //}
    environment {
        dockerHome = "tool docker"
        mavenGHome = "tool maven"
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
        stage('Build'){
            steps {
                sh 'mvn --verison'
                sh  'docker version'
                echo "Build"
               ehco "PATH - $PATH"
                //echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                //echo "BUILD_ID - $env.BUILD_ID"
                //echo "JOB_NAME - $env.JOB_NAME"
                //echo "BUILD_TAG - $env.BUILD_TAG"
                //echo "BUILD_URL - $env.BUILD_URL"
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