#!/bin/bash

echo "Content-type: application/json"
echo ""

sql="SELECT id_dsatz FROM id_datensatz ORDER BY id_dsatz DESC LIMIT 1;"
letzte_id=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "$sql")

sql="SELECT mmsi, name FROM shipnamemmsi WHERE name != 'undefined' AND name != 'nan' AND name != 'fastright' AND name REGEXP '^[A-Z]+$' GROUP BY name ASC;"
mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "$sql" > mmsiname.csv

sql="SELECT sp.mmsi, sp.datum, sp.latitude, sp.longitude, sp.id_dsatz 
     FROM ship_positions sp 
     WHERE sp.datum >= NOW() - INTERVAL 1 HOUR 
     AND latitude REGEXP '^-?[0-9]+\\.[0-9]+$' 
     AND longitude REGEXP '^-?[0-9]+\\.[0-9]+$';"
#sql="SELECT sp.mmsi, sp.datum, sp.latitude, sp.longitude, sp.id_dsatz FROM ship_positions sp WHERE sp.id_dsatz = '$letzte_id' AND latitude REGEXP '^-?[0-9]+\\.[0-9]+$' AND longitude REGEXP '^-?[0-9]+\\.[0-9]+$';"
result=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "$sql")

echo "["
first=true
echo "$result" | while IFS=$'\t' read -r mmsi datum latitude longitude id_dsatz; do
    shipname="Unbekannter Name"
    while IFS=$'\t' read -r csv_mmsi csv_name; do
        if [ "$csv_mmsi" = "$mmsi" ]; then
            shipname="$csv_name"
            break
        fi
    done < mmsiname.csv

    if [ "$first" = true ]; then
        first=false
    else
        echo ","
    fi

    echo "{"
    echo "\"mmsi\":\"$mmsi\","
    echo "\"shipname\":\"$shipname\","
    echo "\"id_dsatz\":\"$id_dsatz\","
    echo "\"datum\":\"$datum\","
    echo "\"latitude\":\"$latitude\","
    echo "\"longitude\":\"$longitude\""
    echo "}"
done

echo "]"
