#usr/bin/env bash


echo "Content-type: text/html"
echo ""

log_dat="log_dat.csv"
num_zeilen=100
counter=1
while [ $(wc -l < "$log_dat") -gt 0 ]; do
output_dat="shipDat_${counter}.log"

code="<!DOCTYPE html><head><title>All saved datas</title></head><body><h1>Table</h1><table border='1'><tr><th>datum</th> <th>type</th> <th>c</th> <th>d</th> <th>e</th> <th>f</th> <th>g</th> <th>h</th> <th>i</th> <th>j</th> <th>k</th> <th>l</th> <th>m</th> <th>n</th> <th>o</th> <th>p</th> <th>q</th> <th>r</th></tr>"
echo "$code" > "$output_dat"

sed -n "1,${num_zeilen} s/|/<\/td><td>/g; s/^/<tr><td>/; s/$/<\/td><\/tr>/p" "$log_dat" >> "$output_dat"


#cat "$log_dat" | while IFS="|" read -r datum type c d e f g h i j k l m n o p q r; do
#echo "<tr>"
#echo "<td>$datum</td><td>$type</td><td>$c</td><td>$d</td> <td>$e</td> <td>$f</td> <td>$g</td> <td>$h</td> <td>$i</td> <td>$j</td> <td>$k</td> <td>$l</td> <td>$m</td> <td>$n</td> <td>$o</td> <td>$p</td> <td>$q</td> <td>$r</td>"
#echo "</tr>"
#done < "$log_dat"


code+="</table></body></html>"
echo "$code+" >> "$output_dat"

sed -i "1,${num_zeilen}d" "$log_dat"
((counter++))

done

for (i = 1; i < counter; i++); do
    data="shipDat_${i}.log"
    echo "<h2>$i</h2>"
cat "$data"
done