#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

idd=$(echo "$QUERY_STRING" |cut -d'&' -f1 | sed 's/ticketId=//g')

if [[ -f /tmp/intest.csv ]]; then
    rm -rf /tmp/intest.csv
else
    touch /tmp/intest.csv
fi

while IFS=";" read -r t c id; do
    if [[ $id != "$idd" ]]; then
        echo "$t;$c;$id" >> /tmp/intest.csv
        #sed -i "/$id/d" /tmp/intest.csv
    fi
done < /home/docker-step2023-team-06/data/swe1-project/intest.csv
cp /tmp/backlog.csv /home/docker-step2023-team-06/data/swe1-project/intest.csv

echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/main-page/main-intest.sh"></head><body></body></html>'
