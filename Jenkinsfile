//declartive pipelline

pipeline{
    agent any
    //agent { dockerfile true }
    //agent {
      //  docker { image 'node:14.15.5-buster' }
    //}
    environment {
        dockerHome = tool 'docker'
        mavenHome = tool 'maven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
        stage('Checkout'){
            steps {
			    echo "In checkout step"
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
       stage('Integration Test'){
            steps {
                echo "Integration Test"
                //sh "mvn failsafe:integration-test failsafe:verfiy"
            }
        }
        stage('Package'){
            steps {
                echo "Package"
                sh "mvn package -DskipTests"
            }
        }
		stage('Build Docker Image'){
            steps {
                echo "Build Docker Image"
                //"docker build -t suresh931/currency-exchange-devops:$env.BUILD_TAG"
                script {
				    echo "chnage the permission"
				    sh 'chmod -R 755 /var/jenkins_home/workspace/jenkins-devops-microservice@tmp'
					echo "After changing the permission"
				    sh 'docker login'
					echo "succesfully loggined"
                    dockerImage = docker.build("suresh931/currency-exchange-devops:${env.BUILD_TAG}")
                }
            }
        }
		stage('Push Docker Image'){
            steps {
                echo "Push Docker Image"
                script {
                    docker.withRegistry('' , dockerHub){
                        dockerImage.Push();
                        dockerImage.Push('latest');
                    }
                }
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