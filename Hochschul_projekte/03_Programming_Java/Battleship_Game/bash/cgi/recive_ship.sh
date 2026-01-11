#!/usr/bin/env bash

ncat --recv-only -e collector_ship.sh rhodes 8082 &
