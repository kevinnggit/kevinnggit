#!/usr/bin/env bash

email=$(echo "$QUERY_STRING" | cut -d ";" -f1 | cut -d "=" -f2)
password=$(echo "$QUERY_STRING" | cut -d ";" -f2 | cut -d "=" -f2)

check=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select * from user_data where email = \"$email\" and password = \"$password\"")

if test "$check" != "" ; then
  cookie=$(pwgen 40 1)
echo "Content-Type: text/html"
echo "Set-Cookie: __SECURE-mysession=$cookie; Secure; SameSite=Strict; Path=/docker-tfw-2024-e-web/"
echo ""
fi
