#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

#$QUERY_STRING

title=$(echo "$QUERY_STRING" |cut -d'&' -f1 |sed 's/title=//g')
content=$(echo "$QUERY_STRING" |cut -d'&' -f2 | sed 's/content=//g')

echo "$title;$content" >> /home/docker-step2023-team-06/data/swe1-project/demo.csv