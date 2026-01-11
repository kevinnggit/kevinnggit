#!/usr/bin/bash
unique_id=$(date +'%Y-%m-%d-%s%N')
while IFS="|" read a b c d e f g h i j k l m n o p q r s t u v; do
  echo $unique_id
  if [ "$b" -ne "18" ] && [ "$b" -ne "24" ]; then
    mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "INSERT INTO shipnamemmsi (datum, name, mmsi, id_dsatz) VALUES ('$a', '$f', '$c', '$unique_id')"
    mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "INSERT INTO ship_positions (datum, mmsi, latitude, longitude, id_dsatz) VALUES ('$a', '$c', '$i', '$j', '$unique_id')"
  fi
done < /tmp/actual.log
mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "INSERT INTO id_datensatz VALUES ('$unique_id')"

echo "" > /tmp/actual.log

