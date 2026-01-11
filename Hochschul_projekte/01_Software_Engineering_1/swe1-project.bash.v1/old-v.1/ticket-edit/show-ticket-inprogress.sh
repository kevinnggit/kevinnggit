#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

ticketIdalt=$(echo "$QUERY_STRING" |cut -d'&' -f1 |sed 's/ticketId=//g')
code="<!DOCTYPE html><html lang='de'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Edit Ticket</title><style>header { background-color: #333; color: #fff; padding: 15px; text-align: center; } main { display: flex; flex-direction: column; align-items: center; justify-content: space-around; } form { display: flex; flex-direction: column; align-items: center; justify-content: space-around; padding: 10px; } input { margin: 5px; }</style></head><body><header><h1>Hier können Sie das Ticket Bearbeiten</h1></header><main><!-- GenCode -->"

while IFS=";" read -r title content ticketId;do
    if [ "$ticketId" == "$ticketIdalt" ]; then
        code+="<div><h2>$title</h2><p>$content</p></div><div><form action='https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/ticket-edit/edit-ticket-inprogress.sh' method='get'><input type='hidden' name='ticketId' value=$ticketId><input type='text' name='title' id='title' value=$title><br><input type='text' name='content' value=$content> <br><input type='submit' value='Ticket bearbeiten'></form></div><div><form action='https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/swe1-project/delete-ticket/delete-inprogress.sh' method='get'><input type='hidden' name='ticketId' value=$ticketId><input type='submit' value='Ticket löschen'></form></div>"
    fi
done < /home/docker-step2023-team-06/data/swe1-project/inprogress.csv
code+="<!-- GenCode--></main></body></html>"

echo "$code"