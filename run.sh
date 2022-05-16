#!/bin/bash

startXvfb() {
    # Set the defaults (GRAPHICS)
    DEFAULT_RES="1920x1080x24"
    DEFAULT_DISPLAY=":"99
    RES=${RES:-$DEFAULT_RES}
    DISPLAY=${DISPLAY:-$DEFAULT_DISPLAY}

    echo +e "[INFO] Google Chrome version is: $(google-chrome --version)"

    # Start Xvfb
    echo +e "Starting Xvfb on display ${DISPLAY} with res ${RES}"
    Xvfb ${DISPLAY} -ac -screen 0 ${RES} &
    export DISPLAY=${DISPLAY}
}

stopXvfb() {
    kill -9 $(pgrep Xvfb)
}

runTests() {
  mvn --version
  mvn clean verify
}
set +e

startXvfb

runTests
stopXvfb