#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

boardId=$(echo "$QUERY_STRING" |cut -d"&" -f1 | sed 's/boardId=//g')

code='<!DOCTYPE html><html lang="de"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><style>body {background: transparent;margin: 0;padding: 0;font-family: sans-serif;border: 2px solid white;border-radius: 20px;display: flex;flex-direction: column;align-items: center;justify-content: space-between;color: white;}header {background: transparent;padding: 0.5em;text-align: center;font-size: 2em;}main {background: transparent;}form {display: flex;flex-direction: column;padding: 10px;background: transparent;}input {padding: 10px;margin: 10px;border: 2px solid white;border-radius: 10px;background: transparent;color: white;}form input:hover {background: white;color: black;transition: 0.5s;}form input#submitInput:hover {cursor: pointer;}</style></head><body><header><h1>New Ticket</h1></header><main>'
code+="<form action='https://informatik.hs-bremerhaven.de/docker-liajohanns-web/cgi-bin/swe1-project/new-ticket.sh' method='get'><input type='hidden' name='boardId' value='$boardId'><input id='titelInput' type='text' name='title' placeholder='Titel'><br><input id='contentInput' type='text' name='content' placeholder='Beschreibung'><br><input id='submitInput' type='submit'></form>"
code+='</main></body></html>'

echo "$code"