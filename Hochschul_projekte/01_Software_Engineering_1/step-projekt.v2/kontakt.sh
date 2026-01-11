#!usr/bin/env bash

name=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/name=//g")
kontakt=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/kontakt=//g")
anliegen=$(echo "$QUERY_STRING" | cut -d'&' -f1 | sed "s/anliegen=//g")

timestamp=$(date +'%Y-%m-%d %H:%M:%S')

csv_file="/home/docker-step2023-team-06/data/step-project/kontakt.csv"
echo "$timestamp, $name, $kontakt, $anliegen" >> "$csv_file"