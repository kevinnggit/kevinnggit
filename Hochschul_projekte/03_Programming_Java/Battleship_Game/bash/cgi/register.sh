#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

read -r QUERY_STRING


email=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/email=//g" | sed "s/%40/@/g")
password=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed "s/password=//g" | sed "s/%40/@/g")
confirmPass=$(echo "$QUERY_STRING" | cut -d'&' -f3 | sed "s/confirmPass=//g")

status=1

if [[ $password != $confirmPass ]]; then
    echo "Passwords do not match"
    status=0
fi


existing_mail=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select email from user_data where email='$email';")

if [[ $existing_mail == $email ]]; then
    echo "E-Mail bereits existierend"
    status=0
fi

if [[ $status -eq 1 ]]; then
    
    mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "insert into user_data (email, password) values ('$email', '$password');"
    
    echo "$email;$password"
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/html/index.html"></head><body></body></html>'
fi

