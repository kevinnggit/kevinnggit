#!/usr/bin/env bash

echo "Content-Type: application/pdf"
echo

cat /home/docker-step2023-team-06/data/step-project/shipData.log | tail -n 1000 | sed 's/^/\\item /g' >
content2.tex

latexmk -interaction=nonstopmode log.tex &> latexmk2.log

cp log.pdf /var/www/html/docker-step2023-team-06-web/