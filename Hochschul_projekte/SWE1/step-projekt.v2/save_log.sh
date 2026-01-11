#!/usr/bin/env bash

# Pfad zur Quelldatei
source_file="/tmp/cur.log"

# Pfad zur Zieldatei
target_file="$HOME/data/step-project/shipData.log"

# Überprüfen, ob die Quelldatei existiert
if [ -e "$source_file" ]; then
    # Daten aus der Quelldatei in die Zieldatei kopieren
    cd "/tmp" | cat "cur.log" >> "$target_file"

    # Quelldatei leeren
    > "cur.log"

    echo "Daten erfolgreich aus $source_file genommen und in $target_file gespeichert."
else
    echo "Fehler: Die Quelldatei $source_file existiert nicht."
fi