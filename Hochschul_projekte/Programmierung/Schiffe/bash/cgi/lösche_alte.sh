#!/usr/bin/env bash

day_l=7

delete_7_days=$(date -d "-$day_l days" +%y-%m-%d\ %H:%M:%S)

mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "DELETE FROM shipnamemmsi WHERE datum = '$delete_7_days';"


mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "DELETE FROM ship_positions WHERE datum = '$delete_7_days';"


#mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "DELETE * FROM id_datensatz WHERE id_d < '$delete_7_days';"
