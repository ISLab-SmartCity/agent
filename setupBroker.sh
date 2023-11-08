#!/bin/bash
echo -e "\n==========Result of Agent Broker Module docker create=============\n"
docker-compose -f docker-compose-agent-broker.yml up --no-start
sleep 5

echo -e "\n===========Result of Agent Broker Module docker start==============\n"
docker-compose -f docker-compose-agent-broker.yml start
sleep 5

echo -e "\n===========Result of Agent Broker Module docker run==============\n"
docker ps -a -f "name=agent.broker"
echo -e "\n========================================================\n"
