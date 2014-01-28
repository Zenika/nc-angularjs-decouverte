#!/bin/sh

java -cp "target/restx/classes:target/dependency/*" -Drestx.mode=prod com.zenika.nc.angular.mybottles.AppServer $1 $2
