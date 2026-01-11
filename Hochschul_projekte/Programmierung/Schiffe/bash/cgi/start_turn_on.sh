#!/usr/bin/env bash


timestamp=$(ls -l /tmp/cur.log | cut -d' ' -f8)
timesec=$(date -d $timestamp +'%s')
actualtime=$(date '+%H:%M')
actualtimesec=$(date -d $curtimestamp +'%s')
diff=$(($actualtimesec - $timesec))

if test $diff -gt 60; then
        ./turn_on_reciver.sh
        echo "$(date): Wurde wieder gestartet" >> /tmp/running.log
else
        echo "$(date): Läuft noch" >> /tmp/running.log
fi
