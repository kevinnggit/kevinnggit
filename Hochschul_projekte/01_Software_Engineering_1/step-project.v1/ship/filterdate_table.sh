#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

path=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/path=//g' | sed 's/%2F/\//g')
ship_date=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/ship_date=//g')

grep -P "$ship_date" $path > /tmp/djqhqjhkdk.jkhdsbasdsndsa

code="<!DOCTYPE html><html lang='de'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Filtered By Date</title><style>table, th, td {border:1px solid black;}</style></head><body><table><tr><th>Date</th><th>Type</th><th>mmsi</th><th>partno</th><th>part</th><th>shiptype</th><th>shiptype_text</th><th>callsign</th><th>mothership_mmsi</th><th>vendorid</th><th>model</th><th>serial</th><th>to_bow</th><th>to_stern</th><th>to_port</th><th>to_starboard</th></tr><tr><th></th><th></th><th></th><th></th><th></th><th></th><th></th><tdh</th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th</th><th></th><th></th><th></th><th></th></th>"
code+=$(awk -F'|' '{printf "<tr> <td>" $1 "</td> <td>" $2 "</td> <td>" $3 "</td> <td>" $4 "</td> <td>" $5 "</td> <td>" $6 "</td> <td>" $7 "</td> <td>" $8 "</td> <td>" $9 "</td> <td>" $10 "</td> <td>" $11 "</td> <td>" $12 "</td><td>" $13 "</td><td>" $14 "</td><td>" $15 "</td><td>" $16 "</td><td>" $17 "</td><td>" $18 "</td><td>" $19 "</td><td>" $20 "</td><td>" $21 "</td><td>" $22 "</td> </tr>"}' /tmp/djqhqjhkdk.jkhdsbasdsndsa)
code+="</table></body></html>"
echo "$code"