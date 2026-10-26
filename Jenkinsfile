pipeline{
    agent any
    stages{
        stage('Build and Test'){
            steps{
                bat 'gradlew.bat clean build'
            }
        }
    }
    post {
        always {
            junit '**/build/test-results/test/*.xml'
        }
    }
}