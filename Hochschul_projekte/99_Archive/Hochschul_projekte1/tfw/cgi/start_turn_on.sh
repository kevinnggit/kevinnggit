#!/usr/bin/env bash


time=$(ls -l /tmp/cur.log | cut -d' ' -f8)
timesec=$(date -d $timestamp +'%s')
actualtime=$(date '+%H:%M')
actualtimesec=$(date -d $curtimestamp +'%s')
diff=$(($actualtimesec - $timesec))

if test $diff -gt 180; then
        ./turn_on_reciver.sh
else
        echo "laeuft noch $(date)" >> /speicher/running.log
fi