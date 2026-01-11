#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

code='<!DOCTYPE html><html lang="de"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><style>header { background-color: #333; color: white; padding: 1em; text-align: center; } main { padding: 1em; background-color: #333; } div { background-color: #eee; padding: 1em; text-align: center; border: 4px solid red; } div h2 { border-bottom: 2px solid #333; } a#newTicket { display: block; text-align: center; padding: 1em; background-color: #eee; border: 1px solid #333; color: black; text-decoration: none; } a:hover#newTicket { background-color: #333; color: white; } a#ticketRef { display: block; text-decoration: none; color: black; background: transparent; } a#ticketRef:hover { background-color: lightcyan; transition: 0.5s; }form button { width: 80%; font-size: 2em; background: transparent; border: none; color: black; cursor: pointer; } form button:hover { background-color: lightcyan; transition: 0.5s; }</style></head><body><header><h1>ToDo</h1></header><main><!-- GenCode -->'
while IFS=";" read -r title content ticketId; do
    code+="<div><form action='https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/ticket-edit/show-ticket-todo.sh' method='get'><input type='hidden' name='ticketId' value=$ticketId><button type="submit"><h2>$title</h2><br><p>$content</p></button></form></div>"
done < /home/docker-step2023-team-06/data/swe1-project/todo.csv
code+='<!-- GenCode --><a id="newTicket" href="https://informatik.hs-bremerhaven.de/step2023-team-06/swe1-project/sites/ticket-forms/ticket-form-todo.html">Neues Ticket</a></main></body></html>'

echo "$code"