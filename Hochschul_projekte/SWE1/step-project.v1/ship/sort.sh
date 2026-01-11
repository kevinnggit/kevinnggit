#!/usr/bin/env bash
#Sortiert die Daten nach zweiter zahl
if [[ $1 == "/tmp/cur.log" ]]; then
    codestart='<!DOCTYPE html> <html lang="de"> <head> <meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1.0"> <style> </style> </head> <body>'
    code1='<table border='1' width="100%"> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>'
    sorted_data1=$(cat $1 | grep -P '^[^|]*\|1\|')
    code1+=$(echo "$sorted_data1" | while IFS="|" read a b c d e f g h i j k l m n o p q; do
        echo "<tr> <td>$a</td> <td>$b</td> <td>$c</td> <td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> <td>$m</td> <td>$n</td> <td>$o</td> <td>$p</td> <td>$q</td> </tr>"
    done)

    code3='</table> <br> <table border='1' width="100%"> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>'
    sorted_data3=$(cat $1 | grep -P '^[^|]*\|3\|')
    code3+=$(echo "$sorted_data3" | while IFS="|" read a b c d e f g h i j k l m n o p q; do
        echo "<tr> <td>$a</td> <td>$b</td> <td>$c</td> <td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> <td>$m</td> <td>$n</td> <td>$o</td> <td>$p</td> <td>$q</td> </tr>"
    done)

    code5='</table> <br> <table border='1' width="100%"> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>imo</th> <th>callsign</th> <th>shipname</th> <th>shiptype</th> <th>shiptype_text</th> to_bow</th> <th>to_stern</th> to_port</th> to_starboard</th> <th>epfd</th> <th>eta</th> <th>epfd_text</th> <th>month</th> <th>day</th> <th>hour</th> <th>minute</th> <th>draught</th> <th>destination</th> <th>dte</th> </tr>'
    sorted_data5=$(cat $1 | grep -P '^[^|]*\|5\|')
    code5+=$(echo "$sorted_data5" | while IFS="|" read a b c d e f g h i j k l m n o p q r s t u v; do
        echo "<tr> <td>$a</td> <td>$b</td> <td>$c</td> <td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> <td>$m</td> <td>$n</td> <td>$o</td> <td>$p</td> <td>$q</td> <td>$r</td> <td>$s</td> <td>$t</td> <td>$u</td> <td>$v</td> </tr>"
    done)

    code18='</table> <br> <table border='1' width="100%"> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>raim</th> <th>radio</th> </tr>'
    sorted_data18=$(cat $1 | grep -P '^[^|]*\|18\|')
    code18+=$(echo "$sorted_data18" | while IFS="|" read a b c d e f g h i j k l; do
        echo "<tr> <td>$a</td> <td>$b</td> <td>$c</td> <td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> </tr>"
    done)

    code24='</table> <br> <table border='1' width="100%"> <tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>partno</th> <th>part</th> <th>shiptype</th> <th>shiptype_text</th> <th>callsign</th> <th>mothership_mmsi</th> <th>vendorid</th> <th>model</th> <th>serial</th> <th>to_bow</th> <th>to_stern</th> <th>to_port</th> <th>to_starboard</th> </tr>'
    sorted_data24=$(cat $1 | grep -P '^[^|]*\|24\|')
    code24+=$(echo "$sorted_data24" | while IFS="|" read a b c d e f g h i j k l m n o p; do
        echo "<tr> <td>$a</td> <td>$b</td> <td>$c</td> <td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> <td>$m</td> <td>$n</td> <td>$o</td> <td>$p</td> </tr>"
    done)
    codeende="</table> </body> </html>"

    echo "$codestart $code1 $code3 $code5 $code18 $code24 $codeende"

elif [[ $1 == "/home/docker-step2023-team-06/data/step-project/shipData.log" ]]; then
    tail -n 10000 "$1" > /tmp/sort_tmp.log
    sort -t '|' -k 2n /tmp/sort_tmp.log > /tmp/sort_tmp_2.log
    sorted_data=$(sed 's/$/<br>/g' /tmp/sort_tmp_2.log)
    echo '<!DOCTYPE html> <html lang="de"> <head> <meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1.0"> <style> </style> </head> <body>'
    echo "$sorted_data"
    echo "</body> </html>"
fi