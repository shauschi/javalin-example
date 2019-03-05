
pipeline {
  agent any
  options {
    skipDefaultCheckout()
  }
  environment{
    APP_NAME = "javalin-example"
    DOCKER_IMAGE = "javalin-example"
  }
  stages {
    stage('checkout') {
      steps { checkout scm }
    }

    stage('build application') {
      steps { sh './gradlew clean build -x test' }
    }

    stage('test (unit)') {
      steps { sh './gradlew test' }
    }

    stage('test (integration)') {
      steps { sh './gradlew integrationTest --debug' }
    }

    stage('containerize') {
      steps {
        sh 'docker build . -f Dockerfile -t ${APP_NAME}'
        sh 'docker tag ${APP_NAME} localhost:5000/${DOCKER_IMAGE}'
        sh 'docker push localhost:5000/${DOCKER_IMAGE}'
      }
    }
  }

  post {
    success {
      slackSend(color: "#BDFFC3", message: "${APP_NAME} [${BRANCH_NAME}] created new docker image successfully: ${DOCKER_IMAGE}")
    }
    failure {
      slackSend(color: "#FF9FA1", message: "${APP_NAME} [${BRANCH_NAME}] (${DOCKER_IMAGE}) build failed - ${BRANCH_NAME} ${env.BUILD_NUMBER}")
    }
  }
}
