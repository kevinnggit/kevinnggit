#!/usr/bin/env bash

if test "$1" = "/tmp/cur.log"; then

echo "Content-Type: application/pdf"
echo

tail -n 100 /tmp/cur.log | sed 's/^/\\item /g' > content.tex


latexmk -interaction=nonstopmode cur.tex &> latexmk.log


cp cur.pdf /var/www/html/docker-step2023-team-06-web/

    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cur.pdf"></head><body></body></html>'
else
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/log.pdf"></head><body></body></html>'
fi