#!/usr/bin/bash

rm -f result.json

sorted_data=$(sort -t '|' -k2 /tmp/data_positions.csv)

echo "[" > result.json

last_id=""

while IFS='|' read -r date id lat lon timestamp; do
    if [ "$id" != "$last_id" ]; then

        if [ "$last_id" != "" ]; then
            echo "    ]
  }," >> result.json
        fi

        echo "  {
    \"id\": \"$id\",
    \"positions\": [" >> result.json
        last_id="$id"
    fi

    echo "      {
        \"lat\": \"$lat\",
        \"lon\": \"$lon\"
      }," >> result.json

done <<< "$sorted_data"

echo "    ]
  }
]" >> result.json

sed -i '$!b;n;s/,$//' result.json
