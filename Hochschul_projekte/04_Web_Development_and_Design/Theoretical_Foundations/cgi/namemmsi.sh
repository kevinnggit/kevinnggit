#!/usr/bin/env bash

#mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e " drop table shipnamemmsi;"
 #mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e " drop table ship_positions;"
  mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e " drop table id_datensatz;"
   #mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "create table shipnamemmsi (datum long, name varchar(256), mmsi long, id_dsatz long);"
   #mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "create table ship_positions (datum long, mmsi long, latitude double, longitude double, id_dsatz long);"
   mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "create table id_datensatz (id_dsatz long);"

    #unique_id=$(pwgen 15 1)
    unique_id=$(date +%Y%m%d%H%M%S)
 while IFS="|" read a b c d e f g h i j k l m n o p q r s t u v; do
 if test "$b" -ne "5" && test "$b" -ne "24"; then

   mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "insert into shipnamemmsi (datum, name, mmsi, id_dsatz) values (`date +%Y%m%d`, '$f', '$c', '$unique_id')";
   mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "insert into ship_positions (datum, mmsi, latitude, longitude, id_dsatz) values (`date +%Y%m%d`, '$c', '$i', '$j', '$unique_id')";
 fi
 done < /tmp/actual.log

 mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "insert into id_datensatz values ('$unique_id')"
 echo "" > /tmp/actual.log
