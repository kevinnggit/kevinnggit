#!/usr/bin/env bash

#USER="tfw-2024-e"
#PASSWORD="2KqpNVPPra15LaddZq9p"
#HOST="mysql-server"
#DATABASE="tfw-2024-e_db"
#id="select id_dsatz from id_datensatz;"
#mysql -u$USER -p$PASSWORD -h$HOST $DATABASE -se "$id"

id_d=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select id_dsatz from id_datensatz;")

mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select * from shipnamemmsi where id_dsatz='$id_d';" | tr '\t' '|' > /tmp/data_namemmsi.csv
mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select * from ship_positions where id_dsatz='$id_d';" | tr '\t' '|' > /tmp/data_positions.csv
