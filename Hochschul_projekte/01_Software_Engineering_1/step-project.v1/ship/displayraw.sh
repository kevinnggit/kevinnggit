#!/usr/bin/env bash

code='<!DOCTYPE html><html lang="de"><head>'

if [[ $1 == "/tmp/cur.log" ]]; then
    code+='<meta http-equiv="refresh" content="20">'
fi
code+='<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Raw</title></head><body><main>'
code+='<pre>'
cat $1
code+='</pre>'
code+="</main></body></html>"
echo $code