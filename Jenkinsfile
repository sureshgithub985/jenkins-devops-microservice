//declartive pipelline

pipeline{
    agent any
    //agent {
      //  docker { image 'node:14.15.5-buster' }
    //}
    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'maven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
        stage('Checkout'){
            steps {
                sh 'mvn -v'
                echo "After maven version"
                //sudo usermod -a -G docker jenkins
                //sh  'docker version'
                echo "Build"
                //ehco "SURESH is  $PATH"
                sh 'printenv'
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
            }
        }
        stage('Compile'){
            steps {
                echo "compile"
                sh "mvn clean compile"
            }
        }
        stage('Test'){
            steps {
                echo "Test"
                sh "mvn test"
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