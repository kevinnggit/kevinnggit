#!/usr/bin/env bash

echo "Content-type: text/plain"
echo ""

#sortDate genTab filterData createPDF
action=$(echo "$QUERY_STRING" | sed "s/formType=//g" )
echo $action

echo HELOOOOOO