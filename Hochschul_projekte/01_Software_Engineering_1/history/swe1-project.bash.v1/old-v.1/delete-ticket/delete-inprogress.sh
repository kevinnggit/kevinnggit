#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

idd=$(echo "$QUERY_STRING" |cut -d'&' -f1 | sed 's/ticketId=//g')

if [[ -f /tmp/inprogress.csv ]]; then
    rm -rf /tmp/inprogress.csv
else
    touch /tmp/inprogress.csv
fi

while IFS=";" read -r t c id; do
    if [[ $id != "$idd" ]]; then
        echo "$t;$c;$id" >> /tmp/inprogress.csv
        #sed -i "/$id/d" /tmp/inprogress.csv
    fi
done < /home/docker-step2023-team-06/data/swe1-project/inprogress.csv
cp /tmp/inprogress.csv /home/docker-step2023-team-06/data/swe1-project/inprogress.csv

echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/main-page/main-inprogress.sh"></head><body></body></html>'
