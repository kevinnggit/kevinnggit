#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

email=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/email=//g")
password1=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed "s/pwd=//g")
password2=$(echo "$QUERY_STRING" | cut -d'&' -f3 | sed "s/pwd2=//g")

status=0
if [[ $password1 != $password2 ]]; then
    echo "$password1"
    echo "$password2"
    echo "Passwords do not match"
fi

while IFS=';' read -r emails pswd; do
    if test "$email" == "$emails"; then
        echo "Email already exists"
        status=1
    fi
done < /home/docker-liajohanns/data/swe1-data/user.csv

if [[ $status -eq 0 ]]; then
    echo "$email;$password1" >> /home/docker-liajohanns/data/swe1-data/user.csv
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/swe1-project/sites/login.html"></head><body></body></html>'
fi  