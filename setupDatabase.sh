#!/bin/bash
echo -e "\n==========Result of Agent Database Module docker create=============\n"
docker-compose -f docker-compose-agent-database.yml up --no-start
sleep 5

echo -e "\n===========Result of Agent Database Module docker start==============\n"
docker-compose -f docker-compose-agent-database.yml start
sleep 5

echo -e "\n=========Result of Agent Database Module docker docker run============\n"
docker ps -a -f name=agent.database
echo -e "\n========================================================\n"
