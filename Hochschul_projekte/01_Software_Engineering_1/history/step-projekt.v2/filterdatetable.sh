#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

path=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/path=//g' | sed 's/%2F/\//g')
ship_date=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/ship_date=//g')


echo "<!DOCTYPE html><html lang='de'><head><meta charset='UTF-8'><title>Filtered By Date</title><style>table, th, td {border:1px solid black;}</style></head><body><table>"

grep  "$ship_date" $path > /tmp/djqhqjhkdk.jkhdsbasdsndsa
while IFS="|" read  a b c d e f g h i j k l m n o p q r s t u v;
do

echo "<tr> <td> $a </td> <td> $b </td> <td> $c </td> <td> $d </td> <td> $e </td> <td> $f </td> <td> $g </td> <td> $h </td> <td> $i </td> <td> $j </td> <td> $k </td> <td> $l </td><td> $m </td><td> $n </td><td> $o </td><td> $p </td><td> $q </td><td> $r </td><td> $s </td><td> $t </td><td> $u </td><td> $v </td> </tr>"
done < /tmp/djqhqjhkdk.jkhdsbasdsndsa
echo "</table></body></html>"