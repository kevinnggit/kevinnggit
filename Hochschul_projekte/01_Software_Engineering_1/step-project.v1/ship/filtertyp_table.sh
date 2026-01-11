#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

path=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/path=//g' | sed 's/%2F/\//g')
ship_typ=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/ship_typ=//g')

code='<!DOCTYPE html> <html lang="de"> <head> <meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1.0"> <style> </style> </head> <body>'

#html table cut %
declare -A ship_typs_table
ship_typs_table["1"]="<table border='1'> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>"
ship_typs_table["3"]="<table border='1'> <tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>turn</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>"
ship_typs_table["5"]="<table border='1'> <tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>imo</th> <th>callsign</th> <th>shipname</th> <th>shiptype</th> <th>shiptype_text</th> <th>to_bow</th> <th>to_stern</th> <th>to_port</th> <th>to_starboard</th> <th>epfd</th> <th>eta</th> <th>epfd_text</th> <th>month</th> <th>day</th> <th>hour</th> <th>minute</th> <th>draught</th> <th>destination</th> <th>dte</th> </tr>"
ship_typs_table["18"]="<table border='1'> <tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>raim</th> <th>radio</th> </tr>"
ship_typs_table["24"]="<table border='1'> <tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>partno</th> <th>part</th> <th>shiptype</th> <th>shiptype_text</th> <th>callsign</th> <th>mothership_mmsi</th> <th>vendorid</th> <th>model</th> <th>serial</th> <th>to_bow</th> <th>to_stern</th> <th>to_port</th> <th>to_starboard</th> </tr>"
code+="${ship_typs_table[$ship_typ]}"


grep -P "^[^|]*\|$ship_typ\|" $path >> /tmp/pihbpbpgaidf.csv
if [[ $ship_typ == "5" ]]; then
    code+=$(awk -F'|' '{printf "<tr> <td>" $1 "</td> <td>" $2 "</td> <td>" $3 "</td> <td>" $4 "</td> <td>" $5 "</td> <td>" $6 "</td> <td>" $7 "</td> <td>" $8 "</td> <td>" $9 "</td> <td>" $10 "</td> <td>" $11 "</td> <td>" $12 "</td><td>" $13 "</td><td>" $14 "</td><td>" $15 "</td><td>" $16 "</td><td>" $17 "</td><td>" $18 "</td><td>" $19 "</td><td>" $20 "</td><td>" $21 "</td><td>" $22 "</td> </tr>"}' /tmp/pihbpbpgaidf.csv)
elif [[ $ship_typ -eq "18" ]]; then
    code+=$(awk -F'|' '{printf "<tr> <td>" $1 "</td> <td>" $2 "</td> <td>" $3 "</td> <td>" $4 "</td> <td>" $5 "</td> <td>" $6 "</td> <td>" $7 "</td> <td>" $8 "</td> <td>" $9 "</td> <td>" $10 "</td> <td>" $11 "</td> <td>" $12 "</td> </tr>"}' /tmp/pihbpbpgaidf.csv)
elif [[ $ship_typ -eq "24" ]]; then
    code+=$(awk -F'|' '{printf "<tr> <td>" $1 "</td> <td>" $2 "</td> <td>" $3 "</td> <td>" $4 "</td> <td>" $5 "</td> <td>" $6 "</td> <td>" $7 "</td> <td>" $8 "</td> <td>" $9 "</td> <td>" $10 "</td> <td>" $11 "</td> <td>" $12 "</td><td>" $13 "</td><td>" $14 "</td><td>" $15 "</td><td>" $16 "</td></tr>"}' /tmp/pihbpbpgaidf.csv)
else
    code+=$(awk -F'|' '{printf "<tr> <td>" $1 "</td> <td>" $2 "</td> <td>" $3 "</td> <td>" $4 "</td> <td>" $5 "</td> <td>" $6 "</td> <td>" $7 "</td> <td>" $8 "</td> <td>" $9 "</td> <td>" $10 "</td> <td>" $11 "</td> <td>" $12 "</td> <td>" $13 "</td><td>" $14 "</td><td>" $15 "</td><td>" $16 "</td> <td>" $17 "</td> </tr>"}' /tmp/pihbpbpgaidf.csv)
fi

rm /tmp/pihbpbpgaidf.csv
code+="</table></body></html>"
echo "$code"