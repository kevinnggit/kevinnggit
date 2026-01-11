#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

boardId=4
code="<!DOCTYPE html><html lang='de'><head><meta http-equiv="refresh" content="2"><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><style>body {background: transparent;margin: 0;padding: 0;font-family: sans-serif;border: 2px solid white;border-radius: 20px;display: flex;flex-direction: column;align-items: center;justify-content: space-between;color: white;}header {background: transparent;padding: 0.5em;text-align: center;font-size: 2em;}main {background: transparent;}div {background: transparent;padding: 1em;margin: 20px;text-align: center;border: 4px solid white;border-radius: 20px;}div form {padding: 10px;background: transparent;}div form button {background: transparent;padding: 10px;color: white;border: 2px solid white;border-radius: 10px;}div form button:hover {background: white;color: black;transition: 0.5s;cursor: pointer;}form#ticketForm {display: flex;flex-direction: column;align-items: center;justify-content: space-around;padding: 10px;background: transparent;}form#ticketForm input {background: transparent;padding: 10px;color: white;border: 2px solid white;border-radius: 20px;}form#ticketForm input:hover {background: white;color: black;transition: 0.5s;cursor: pointer;}</style></head><body><header><h1>In Test</h1></header><main><!-- GenCode -->"

while IFS=";" read -r ticketId title content; do
    code+="<div><form action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/show-ticket.sh' method='get'><input type='hidden' name='boardId' value=$boardId><input type='hidden' name='ticketId' value=$ticketId><input type='hidden' name='ticketTitle' value="$(./convert.sh "$title")"><input type='hidden' name='ticketContent' value="$(./convert.sh "$content")"><button type='submit'><h2>$title</h2><br><p>$content</p></button></form></div>"
done < /home/docker-liajohanns/data/swe1-data/intest.csv
code+="<form id='ticketForm' action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/new-ticket-form.sh' method='get'><input type='hidden' name='boardId' value=$boardId><input type='submit' value='Neues Ticket'></form>"

code+="<!-- GenCode --></main></body></html>"
echo "$code"