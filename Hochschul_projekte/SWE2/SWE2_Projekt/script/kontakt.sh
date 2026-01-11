#!/usr/bin/env bash

echo "Content-Type: text/html"
echo ""

nname=$(echo "$QUERY_STRING" | cut -d'&' -f'1' | sed "s/name=//g")
aadresse=$(echo "$QUERY_STRING" | cut -d'&' -f'2' | sed "s/adresse=//g")
nnummer=$(echo "$QUERY_STRING" | cut -d'&' -f'3' | sed "s/nummer=//g")
nnachricht=$(echo "$QUERY_STRING" | cut -d'&' -f'4' | sed "s/nachricht=//g")

echo "$nname|$aadresse|$nnummer|$nnachricht" >> kontakt.csv
