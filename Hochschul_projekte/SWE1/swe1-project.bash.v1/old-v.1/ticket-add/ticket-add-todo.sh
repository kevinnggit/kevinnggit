#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

#$QUERY_STRING

title=$(echo "$QUERY_STRING" |cut -d'&' -f1 |sed 's/title=//g' | sed 's/+/ /g')
content=$(echo "$QUERY_STRING" |cut -d'&' -f2 | sed 's/content=//g' | sed 's/+/ /g')
id=$(cat /home/docker-step2023-team-06/data/swe1-project/id-todo.int)

echo "$title;$content;$(($id + 1))" >> /home/docker-step2023-team-06/data/swe1-project/todo.csv
echo $(($id + 1)) > /home/docker-step2023-team-06/data/swe1-project/id-todo.int

echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/main-page/main-todo.sh"></head><body></body></html>'