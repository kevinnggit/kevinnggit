#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

path=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/path=//g' | sed 's/%2F/\//g')
ship_typ=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/ship_typ=//g')

code="<!DOCTYPE html> <html lang='de'> <head> <meta charset='UTF-8'> <style> </style> </head> <body> <table border='1'>"

grep "^[^|]*|$ship_typ|" $path > /tmp/Filtertyp.log

if test "$ship_typ" -eq "1"; then
        code+="<tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>"
        while IFS="|" read a b c d e f g h i j k l m n o p q; do
                code+="<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td>  <td> $m </td>  <td> $n </td>  <td> $o </td>  <td> $p </td> <td> $q </td> </tr>"
        done < /tmp/Filtertyp.log
fi

if test "$ship_typ" -eq "3"; then
        code+="<tr> <th>date</th> <th>type</th> <th>mmsi</th> <th>status</th> <th>status_text</th> <th>turn</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>maneuver</th> <th>maneuver_text</th> <th>raim</th> <th>radio</th> </tr>"
        while IFS="|" read a b c d e f g h i j k l m n o p q; do
                code+="<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td>  <td> $m </td>  <td> $n </td>  <td> $o </td>  <td> $p </td> <td> $q </td> </tr>"
        done < /tmp/Filtertyp.log
fi

if test "$ship_typ" -eq "5"; then
  code+="<tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>imo</th> <th>callsign</th> <th>shipname</th> <th>shiptype</th> <th>shiptype_text</th> <th>to_bow</th> <th>to_stern</th> <th>to_port</th> <th>to_starboard</th> <th>epfd</th> <th>eta</th> <th>epfd_text</th> <th>month</th> <th>day</th> <th>hour</th> <th>minute</th> <th>draught</th> <th>destination</th> <th>dte</th> </tr>"
        while IFS="|" read a b c d e f g h i j k l m n o p q r s t u v; do
                code+="<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td>  <td> $m </td> <td> $n </td> <td> $o </td> <td> $p </td> <td> $q </td> <td> $r </td>  <td> $s </td> <td> $t </td> <td> $u </td>  <td> $v </td> </tr>"
        done < /tmp/Filtertyp.log
fi

if test "$ship_typ" -eq "18"; then
        code+="<tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>speed</th> <th>accuracy</th> <th>lon</th> <th>lat</th> <th>course</th> <th>heading</th> <th>second</th> <th>raim</th> <th>radio</th> </tr>"
        while IFS="|" read a b c d e f g h i j k l; do
                code+="<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td> </tr>"
        done < /tmp/Filtertyp.log
fi

if test "$ship_typ" -eq "24"; then
        code+="<tr> <th>datum</th> <th>type</th> <th>mmsi</th> <th>partno</th> <th>part</th> <th>shiptype</th> <th>shiptype_text</th> <th>callsign</th> <th>mothership_mmsi</th> <th>vendorid</th> <th>model</th> <th>serial</th> <th>to_bow</th> <th>to_stern</th> <th>to_port</th> <th>to_starboard</th> </tr>"
        while IFS="|" read a b c d e f g h i j k l m n o p; do
                code+="<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td>  <td> $m </td>  <td> $n </td>  <td> $o </td>  <td> $p </td>  </tr>"
        done < /tmp/Filtertyp.log
fi

code+="</table></body></html>"

echo "$code"