#!/bin/bash
name=email-server
id=`ps -ef | grep "$name" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
echo "---------------"
for id in $id
do
kill $id
echo "killed $id"
done

#modify your java path 
nohup /usr/local/jdk1.8.0_72/bin/java -jar email-server-0.0.1-SNAPSHOT.jar
echo "start finish!"
exit 0
