pipeline {
agent any 

triggers {
    pollSCM('* * * * *')
}
stages {
    stage('Docker compose build') {
        steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'sudo apt-get update docker-compose'
        }
    }
  }
}
