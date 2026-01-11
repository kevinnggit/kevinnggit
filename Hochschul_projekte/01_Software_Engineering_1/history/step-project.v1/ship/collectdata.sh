#!/usr/bin/env bash

tmux new-session -d -s collectData 'ncat rhodes 8082 >> /tmp/cur.log'
