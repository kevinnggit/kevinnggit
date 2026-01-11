#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

email=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/email=//g")
password=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed "s/pwd=//g")

status=1
while IFS=';' read -r emails pswd; do
    if test "$email" == "$emails"; then
        if test "$password" == "$pswd"; then
        status=0
        fi
    fi
done < /home/docker-liajohanns/data/swe1-data/user.csv

if [[ $status -eq 0 ]]; then
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/swe1-project/sites/main-page.html"></head><body></body></html>'
else
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/swe1-project/sites/login.html"></head><body></body></html>'
fi