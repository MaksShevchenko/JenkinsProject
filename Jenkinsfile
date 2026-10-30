pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timeout(time: 20, unit: 'MINUTES')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and test') {
            steps {
                script {
                    if (isUnix()) {
                        sh '''
                            chmod +x gradlew
                            ./gradlew --no-daemon clean build
                        '''
                    } else {
                        bat 'gradlew.bat --no-daemon clean build'
                    }
                }
            }

            post {
                always {
                    junit testResults: '**/build/test-results/test/*.xml'
                }
            }
        }

        stage('Save JAR') {
            steps {
                archiveArtifacts(
                    artifacts: '**/build/libs/*.jar',
                    fingerprint: true
                )
            }
        }
    }
}
