#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

benutzername=$(echo "$QUERY_STRING" | cut -d'&' -f'1' | sed "s/username=//g")
passwort=$(echo "$QUERY_STRING" | cut -d'&' -f'2' | sed "s/enterpass=//g")

status=1

while IFS="|" read -r a b c uname d upwd; do
    if [[ "$uname" == "$benutzername" && "$upwd" == "$passwort" ]]; then
        status=0
        break
    fi
done < kundendata.csv

if [[ $status -eq 0 ]]; then
     echo "<html><body><script>window.location.href = 'https://informatik.hs-bremerhaven.de/docker-swe2-2024-team17-web/produkte.html';</script></body></html>"
else
    echo "<html><body><script>alert('Benutzername oder Passwort falsch');window.location.href='https://informatik.hs-bremerhaven.de/docker-swe2-2024-team17-web/login.html';</script></body></html>"
fi
