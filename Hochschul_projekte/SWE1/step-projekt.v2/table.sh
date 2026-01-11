#!/usr/bin/env bash

echo "<!DOCTYPE html><html><head><title>Tabelle</title></head><body><table border='1'>"
if test "$1" = "/tmp/cur.log" ; then

cat $1 | while IFS="|" read datum type a b c d e f g h i j k l m n o p q r s t; do

echo "<tr><td>$datum</td><td>$type</td><td>$a</td><td>$b</td><td>$c</td><td>$d</td><td>$e</td><td>$f</td><td>$g</td><td>$h</td><td>$i</td><td>$j</td><td>$k</td><td>$l</td><td>$m</td><td>$n</td><td>$o</td><td>$p</td><td>$q</td><td>$r</td><td>$s</td><td>$t</td></tr>"
done

 else

tail -n 1000 "$1" | while IFS="|" read datum type a b c d e f g h i j k l m n o p q r s t; do

echo "<tr><td>$datum</td><td>$type</td><td>$a</td><td>$b</td><td>$c</td><td>$d</td><td>$e</td><td>$f</td><td>$g</td><td>$h</td><td>$i</td><td>$j</td><td>$k</td><td>$l</td><td>$m</td><td>$n</td><td>$o</td><td>$p</td><td>$q</td><td>$r</td><td>$s</td><td>$t</td></tr>"
done

fi

echo "</table></body></html>"