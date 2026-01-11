#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

ticketId=$(echo "$QUERY_STRING" |cut -d"&" -f1 |sed 's/ticketId=//g')
boardId=$(echo "$QUERY_STRING" |cut -d"&" -f2 |sed 's/boardId=//g')

declare -A boardNames   
boardNames[1]="backlog"
boardNames[2]="todo"
boardNames[3]="inprogress"
boardNames[4]="intest"
boardNames[5]="live"

sed -i "/^$ticketId;/d" /home/docker-liajohanns/data/swe1-data/${boardNames[$boardId]}.csv

echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/loader/'"${boardNames[$boardId]}"'.sh"></head><body></body></html>'