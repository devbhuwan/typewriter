#!/usr/bin/env bash
./gradlew clean bootJar &&\
 cd .docker && build.sh &&\
 cd ..