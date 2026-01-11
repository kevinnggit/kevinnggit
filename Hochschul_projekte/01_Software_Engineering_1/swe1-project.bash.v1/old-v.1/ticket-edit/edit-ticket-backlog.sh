#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

ticketId=$(echo "$QUERY_STRING" |cut -d'&' -f1 |sed 's/ticketId=//g')
title=$(echo "$QUERY_STRING" |cut -d'&' -f2 | sed 's/title=//g')
content=$(echo "$QUERY_STRING" |cut -d'&' -f3 | sed 's/content=//g')

while IFS=";" read -r titlealt contentalt ticketIdalt;do
    if [ "$ticketId" == "$ticketIdalt" ]; then
        sed -i "s/$titlealt/$title/g" /home/docker-step2023-team-06/data/swe1-project/backlog.csv
        sed -i "s/$contentalt/$content/g" /home/docker-step2023-team-06/data/swe1-project/backlog.csv
    fi
done < /home/docker-step2023-team-06/data/swe1-project/backlog.csv