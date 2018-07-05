#!/bin/sh

# Get JAVA_HOME
JRE_HOME="${JAVA_HOME}"
echo $JRE_HOME
echo $JAVA_HOME

# Get home directory
APP_HOME=$(cd $(dirname $0); cd ..; pwd -P)

# Project Information
ARTIFACT_ID=DBWatcher
VERSION=1.0-SNAPSHOT
MAIN_CLASS=com.jd.dbw.App

# Set entry
MAIN_JAR_DIR=lib
MAIN_JAR=$ARTIFACT_ID-$VERSION.jar

# Set log directory for log4j
LOG_DIR=/export/Logs

# Set Java environment
JAVA_ENV="-Dlog-dir=$LOG_DIR"

# Run
setsid java $JAVA_OPTS $JAVA_ENV -cp $APP_HOME/$MAIN_JAR_DIR/$MAIN_JAR -Dfile.encoding=UTF-8 $MAIN_CLASS /export/App/main.properties &
