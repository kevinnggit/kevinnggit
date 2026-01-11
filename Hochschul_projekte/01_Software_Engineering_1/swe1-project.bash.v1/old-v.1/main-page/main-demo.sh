#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

code='<!DOCTYPE html><html lang="de"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><style>header {background-color: #333;color: white;padding: 1em;text-align: center;}main {padding: 1em;background-color: #333;}div {background-color: #eee;padding: 1em;text-align: center;}a {display: block;text-align: center;padding: 1em;background-color: #eee;border: 1px solid #333;color: black;text-decoration: none;}a:hover{background-color: #333;color: white;}</style></head><body><header><h1>Bsp.Page</h1></header><main><!-- GenCode -->'
while IFS=";" read -r title content; do
    code+="<div><h2>$title</h2><br><p>$content</p></div>"
done < /home/docker-step2023-team-06/data/swe1-project/demo.csv
code+='<!-- GenCode --><a href="https://informatik.hs-bremerhaven.de/step2023-team-06/sites/ticket-form.html">Neues Ticket</a></main></body></html>'

echo "$code"