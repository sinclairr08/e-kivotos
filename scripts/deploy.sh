#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/app
PROJECT_NAME=e-kivotos
BACKEND=backend

cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"

git pull

cd $BACKEND

echo "> Build"

./gradlew build

echo "> Build 파일 복사"

cp $REPOSITORY/$PROJECT_NAME/$BACKEND/build/libs/*.jar $REPOSITORY

echo "> PID 확인"

CURRENT_PID=${pgrep -f ${$BACKEND}.*.jar}

if [ -z "$CURRENT_PID" ]; then
  echo "> 구동 중인 애플리케이션 없음"
else
  echo "> kill $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR 이름: $JAR_NAME"

nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &
