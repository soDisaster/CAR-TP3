#!/bin/bash 

gnome-terminal -t "serverName" -e "java -jar NameServer.jar "&
sleep 1
gnome-terminal -t "node1" -e "java -jar tree/NodeTree.jar 1"&
gnome-terminal -t "node2" -e "java -jar tree/NodeTree.jar 2"&
gnome-terminal -t "node3" -e "java -jar tree/NodeTree.jar 3"&
gnome-terminal -t "node4" -e "java -jar tree/NodeTree.jar 4"&
gnome-terminal -t "node5" -e "java -jar tree/NodeTree.jar 5"&
gnome-terminal -t "node6" -e "java -jar tree/NodeTree.jar 6"&
sleep 10
gnome-terminal -e "java -jar tree/ClientTree.jar"&

