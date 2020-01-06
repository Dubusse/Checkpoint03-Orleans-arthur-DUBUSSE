#!/usr/bin/env bash
clear
if [ -n "$1" ]; then
    classname="$1"
    classname="$(tr '[:lower:]' '[:upper:]' <<< ${classname:0:1})${classname:1}"

      javac -classpath out:lib/junit-4.12.jar -d out src/main/java/algo/${classname}.java 2> log/checkmethod_output.txt

    if [[ $(< log/checkmethod_output.txt) != "" ]]; then
        cat log/checkmethod_output.txt
    else
        javac -classpath out:lib/junit-4.12.jar -d out src/test/java/algo/${classname}Test.java

        java -classpath out:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore algo.${classname}Test
    fi
else
    echo "Please specify the class to test, e.g. : ./tester.sh StringTraining"
fi