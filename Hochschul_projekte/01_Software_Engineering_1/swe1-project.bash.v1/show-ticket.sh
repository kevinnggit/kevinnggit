#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

boardId=$(echo "$QUERY_STRING" |cut -d"&" -f1 |sed 's/boardId=//g')
ticketId=$(echo "$QUERY_STRING" |cut -d"&" -f2 |sed 's/ticketId=//g')
ticketTitle=$(echo "$QUERY_STRING" |cut -d"&" -f3 |sed 's/ticketTitle=//g' | sed 's/-/ /g')
ticketContent=$(echo "$QUERY_STRING" |cut -d"&" -f4 |sed 's/ticketContent=//g' | sed 's/-/ /g')

declare -A boardNames
boardNames[1]="backlog"
boardNames[2]="todo"
boardNames[3]="inprogress"
boardNames[4]="intest"
boardNames[5]="live"

code="<!DOCTYPE html><html lang='de'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Edit Ticket</title><style>body {background: transparent;margin: 0;padding: 0;font-family: sans-serif;border: 2px solid white;border-radius: 20px;display: flex;flex-direction: column;align-items: center;justify-content: space-between;color: white;}header {background: transparent;padding: 0.5em;text-align: center;font-size: 2em;}main {background: transparent;}div {background: transparent;padding: 1em;margin: 20px;text-align: center;border: 4px solid white;border-radius: 20px;}div form {padding: 10px;background: transparent;}div form input {background: transparent;padding: 10px;color: white;border: 2px solid white;border-radius: 10px;}div form input:hover {background: white;color: black;transition: 0.5s;cursor: pointer;}form#formMove {display: flex;flex-direction: column;align-items: center;justify-content: space-around;padding: 10px;background: transparent;}form#formMove select {background: transparent;padding: 10px;color: white;border: 2px solid white;border-radius: 10px;margin-bottom: 5px;}form#formMove select:hover {background: white;color: black;transition: 0.5s;}form#inputForm input {margin: 5px;}form#ticketDelete input {color: white;border: 2px solid blueviolet;border-radius: 10px;}form#ticketDelete input:hover {background-color: red;color: white;transition: 0.5s;}form#inputForm input#textField:hover {cursor: text;}</style></head><body><header><h1>Hier können Sie das Ticket Bearbeiten</h1></header><main><!-- GenCode --><div id='curTicket'><h2>$ticketTitle</h2><p>$ticketContent</p></div><div><form id='inputForm' action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/edit.sh' method='get'><input type='hidden' name='boardId' value=$boardId><input type='hidden' name='ticketId' value=$ticketId><input type='text' name='title' id='textField' value=\"$ticketTitle\"><br><input type='text' name='content' id='textField' value=\"$ticketContent\"> <br><input type='submit' value='Ticket bearbeiten'></form></div><div><form id='ticketDelete' action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/delete.sh' method='get'><input type='hidden' name='ticketId' value=$ticketId><input type='hidden' name='boardId' value=$boardId><input type='submit' value='Ticket löschen'></form><form id='formMove' action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/move.sh' method='get'><input type='hidden' name='ticketId' value=$ticketId><input type='hidden' name='boardId' value=$boardId><input type='hidden' name='title' value=\"$ticketTitle\"><input type='hidden' name='content' value=\"$ticketContent\"><select name='toMove' id=''>"

for ((i = 1; i <= 5 ; i++)); do
    if ! [[ $i -eq $boardId ]]; then
        code+="<option value="${boardNames[$i]}">"${boardNames[$i]}"</option>"        
    fi
done
code+="</select><input type='submit' value='Ticket Verschieben'></form></div><!-- GenCode --></main></body></html>"

echo "$code"