#!/bin/bash

# Gradle을 사용하여 프로젝트 빌드
echo -e "\n===========Result of Agent Backend Service Build==============\n"
./gradlew build

# 테스트 실행
echo -e "\n===========Result of Agent Backend Service Test==============\n"
./gradlew test

# Spring Boot 애플리케이션 실행 (포트번호는 필요에 따라 수정)
echo -e "\n===========Result of Agent Backend Service Run==============\n"
java -jar build/libs/your-project.jar --server.port=8080