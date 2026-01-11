#!/usr/bin/env bash

echo "Content-type: text/html"
echo ""

dataId=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed 's/dataId=//g')
type=$(echo "$QUERY_STRING" | cut -d'&' -f2 | sed 's/type=//g')


path["log"]="/home/docker-step2023-team-06/data/step-project/shipData.log"
handler["pdf"]="pdf.sh"
handler["table"]="table.sh"
handler["sort"]="sort.sh"
handler["filterdate"]="filterdate.sh"
handler["filtertypus"]="filtertypus.sh"
handler["rawdata"]="displayraw.sh"

if [ "$type" = "pdf" ]; then
    ./${handler[$type]} ${path[$dataId]}
elif [ "$type" = "table" ]; then
    ./${handler[$type]} ${path[$dataId]}
elif [ "$type" = "sort" ]; then
    ./${handler[$type]} ${path["log"]}
elif [ "$type" = "filterdate" ]; then
    ./${handler[$type]} ${path["log"]}
elif [ "$type" = "filtertypus" ]; then
    ./${handler[$type]} ${path["log"]}
elif [ "$type" = "rawdata" ]; then
    ./${handler[$type]} ${path[$dataId]}
else
    echo "Ungültiger 'type'-Parameter"
fi