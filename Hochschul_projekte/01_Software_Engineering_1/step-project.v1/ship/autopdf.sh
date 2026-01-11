#!/usr/bin/env bash

# Setze den Content-Type für die Ausgabe auf PDF
#echo "Content-Type: application/pdf"
#echo

# Setze das Arbeitsverzeichnis für LaTeX
export TEXMFVAR=/var/www/html/docker-step2023-team-06-web/

# Erstelle ein temporäres Verzeichnis
mkdir -p /tmp/latex-$$ && rm -rf /tmp/latex-$$/*
cp -r /var/www/html/docker-step2023-team-06-web/* /tmp/latex-$$
cd /tmp/latex-$$

# Erstelle LaTeX-Dokument aus der CSV-Datei
awk -F',' '{print "\\item " $1 ", " $2 ", " $3 ", " $4 ", " $5 ", " $6 ", " $7 ", " $8 ", " $9 ", " $10 ", " $11 ", " $12 ", " $13 ", " $14 ", " $15 ", " $16 ", " $17}' /var/www/html/docker-step2023-team-06-web/shipData.log | tail -1000 > content.tex

# Annahme: Es gibt eine LaTeX-Template-Datei namens 'template.tex'
cat << 'EOF' > log.tex
\documentclass{article}
\begin{document} 
\title{Ship Data}
\maketitle
\begin{enumerate}
    \input{content.tex}
\end{enumerate}
\end{document}
EOF

# Kompiliere das LaTeX-Dokument
latexmk -interaction=nonstopmode log.tex &> latexmk.log

# Kopiere das generierte PDF zum gewünschten Speicherort
cp log.pdf /var/www/html/docker-step2023-team-06-web/

# Räume temporäre Dateien auf

rm -rf /tmp/latex-$$ 