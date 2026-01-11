set terminal pngcairo size 2048,1024 font 'Verdana,32'
set output '/var/www/html/docker-step2023-team-06-web/lasttest.png'
set title 'Lasttest'
set xlabel 'Anzahl aufrufe'
set ylabel 'Sekunden'


plot '/tmp/run.dat' using 1:2 \
  with linespoints \