#!/usr/bin/env bash


timestamp=$(ls -l /tmp/cur.log | cut -d' ' -f8)
curtimestamp=$(date '+%H:%M')
timestampsek=$(date -d $timestamp +'%s')
curtimestampsek=$(date -d $curtimestamp +'%s')
dif=$(($curtimestampsek - $timestampsek))

if test $dif -gt 300; then
        ~/startcollectdata.sh
else
        echo "Still Running $(date)" >> ~/stillrunninglog.log
fi