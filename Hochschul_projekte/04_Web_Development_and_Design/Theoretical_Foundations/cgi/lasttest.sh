#!/usr/bin/env bash

begin=$(date +%s%N)
anzahl=5000

for i in $(seq $anzahl); do
  echo "$i Anfragen starten"
  curl https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/html/index.html &> /dev/null
done
wait
ende=$(date +%s%N)
echo "$anzahl anfragen"

ms=$(( (ende-begin)/1000000 ))

echo "Dauer in ms: $ms"
echo "Dauer in sekunden: $(( $ms/1000  ))"

for j in $(seq 10); do
  echo "$j $ms"
done > quadrat.dat
