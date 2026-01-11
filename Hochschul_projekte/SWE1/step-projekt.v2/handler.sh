#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

path=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/dataId=//g')
types=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/type=//g')

if test "$path" = "current"; then
        path="/tmp/cur.log"
elif test "$path" = "saveData"; then
        path="/home/docker-step2023-team-06/data/step-project/shipData.log"
fi

if test $types = "sort"; then
        ./sort.sh $path
elif test $types = "pdf"; then
        ./pdf.sh $path
elif test $types = "table"; then
        ./table.sh $path
elif test $types = "filterdate"; then
        ./filterdate.sh $path
elif test $types = "filtertyp"; then
        ./filtertypus.sh $path
elif test $types = "raw"; then
        ./displayraw.sh $path
fi