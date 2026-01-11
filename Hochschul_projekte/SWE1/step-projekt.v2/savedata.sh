#!/usr/bin/env bash

cat /tmp/cur.log >> /home/docker-step2023-team-06/data/step-project/shipData.log
echo "" > /tmp/cur.log

cd /usr/lib/cgi-bin/step-project/ship/
./autopdf.sh