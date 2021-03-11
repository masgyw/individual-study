#! /bin/bash
nohup java -jar order-service-1.0.0.jar --server.port=9003 &
echo pid is:$?