# 빌드 스테이지
FROM openjdk:17-jdk-slim AS builder

# 작업 디렉토리 설정
WORKDIR /build

# Gradle 래퍼와 소스 코드 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Gradle 빌드 실행
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# 실행 스테이지
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 스테이지에서 생성된 JAR 파일만 복사
COPY --from=builder /build/build/libs/*.jar app.jar

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java","-jar","app.jar"]
