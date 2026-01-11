#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

declare -A boardNames
boardNames[1]="backlog"
boardNames[2]="todo"
boardNames[3]="inprogress"
boardNames[4]="intest"
boardNames[5]="live"


boardId=$(echo "$QUERY_STRING" |cut -d"&" -f1 | sed 's/boardId=//g')
title=$(echo "$QUERY_STRING" |cut -d"&" -f2 | sed 's/title=//g')
content=$(echo "$QUERY_STRING" |cut -d"&" -f3 | sed 's/content=//g')

if ! [ -s /home/docker-liajohanns/data/swe1-data/${boardNames[$boardId]}.csv ]; then
    ticketId=1
else
    ticketId=$(tail -n 1 /home/docker-liajohanns/data/swe1-data/${boardNames[$boardId]}.csv | cut -d";" -f1)
    ticketId=$((ticketId+1))
fi

correctedTitle=$(./translate.sh "$title")
correctedContent=$(./translate.sh "$content")

echo "$ticketId;$correctedTitle;$correctedContent" >> /home/docker-liajohanns/data/swe1-data/${boardNames[$boardId]}.csv
echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/loader/'"${boardNames[$boardId]}"'.sh"></head><body></body></html>'