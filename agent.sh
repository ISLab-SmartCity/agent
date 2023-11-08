#!/bin/bash
echo -e "\n===========Result of Agent Database Module docker start==============\n"
sudo docker-compose -f docker-compose-agent-database.yml up --no-start
sleep 5
sudo docker-compose -f docker-compose-agent-database.yml start
sleep 5

echo -e "\n===========Result of Agent Broker Module docker start==============\n"
sudo docker-compose -f docker-compose-agent-broker.yml up --no-start
sleep 5
sudo docker-compose -f docker-compose-agent-broker.yml start
sleep 5

echo -e "\n===========Result of Agent Module docker run==============\n"
sudo docker ps
echo -e "\n========================================================\n"
