#! /bin/bash
nohup java -jar product-service-1.0.0.jar --server.port=9001 &
echo pid is:$?