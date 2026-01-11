#!/usr/bin/env bash

rm -rf /tmp/run.dat
i=0
while test $i -lt 1000; do
    i=$((i + 10))
    start=$(date +%s)
    x=0
    while test $x -lt $i; do
        curl -s -o /dev/null "https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cgi-bin/step-project/ship/handler.sh?dataId=%2Ftmp%2Fcur.log&type=sort.sh"
        x=$((x + 1))
    done
    echo "$i $(($(date +%s) - $start))" >> /tmp/run.dat
done


gnuplot lasttest.gp