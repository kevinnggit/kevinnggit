#!/usr/bin/env bash


cookieline=$(echo "$HTTP_COOKIE" | tr ";" "\n" | grep "^__SECURE-mysession=")
cookie=$(echo "$cookieline" | cut -d "=" -f 2 )


if test -n "$cookie" && test -d "/tmp/mysession-$cookie"; then
    
    rm -rf "/tmp/mysession-$cookie"

    
    echo "Content-Type: text/plain"
    echo "Set-Cookie: __SECURE-mysession=; Secure; HttpOnly; Path=/docker-tfw-2024-e-web/; Expires=Thu, 01 Jan 1970 00:00:00 GMT;"
    echo ""
    echo "Session gelöscht. Cookie wurde für $cookie zurückgesetzt."
else
    echo "Content-Type: text/plain"
    echo ""
    echo "Fehler beim Löschen der Session."
fi

$HTTP_COOKIE=""
