#!/usr/bin/env bash

# This script is used to reset the password of a user.
echo "Content-type: text/html"
echo ""

email=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/email=//g")
password=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed "s/pwd=//g")


sed -i "s/^$email;.*$/$email;$password/g" /home/docker-liajohanns/data/swe1-data/user.csv
echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-liajohanns-web/swe1-project/sites/login.html"></head><body></body></html>'