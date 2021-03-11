#! /bin/bash
nohup java -jar inventory-service-1.0.0.jar --server.port=9002 &
echo pid is:$?