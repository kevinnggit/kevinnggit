#!/usr/bin/env bash

if [[ $1 == "/tmp/cur.log" ]]; then
    #erstelle neue PDF mit Current daten
    touch /tmp/kdmd
    echo "Content-Type: application/pdf"
    echo

    # Setze das Arbeitsverzeichnis für LaTeX
    export TEXMFVAR=/var/www/html/docker-step2023-team-06-web/

    # Erstelle ein temporäres Verzeichnis
    mkdir -p /tmp/latex-$$ && rm -rf /tmp/latex-$$/*
    cp -r /var/www/html/docker-step2023-team-06-web/* /tmp/latex-$$
    cd /tmp/latex-$$

    # Erstelle LaTeX-Dokument aus der CSV-Datei
    awk -F',' '{print "\\item " $1 ", " $2 ", " $3 ", " $4 ", " $5 ", " $6 ", " $7 ", " $8 ", " $9 ", " $10 ", " $11 ", " $12 ", " $13 ", " $14 ", " $15 ", " $16 ", " $17}' $1 > content.tex

    # Annahme: Es gibt eine LaTeX-Template-Datei namens 'template.tex'
    cat << 'EOF' > cur.tex
    \documentclass{article}
    \begin{document}
    \title{Cur Data}
    \maketitle
    \begin{enumerate}
    \input{content.tex}
    \end{enumerate}
    \end{document}
EOF

    # Kompiliere das LaTeX-Dokument
    latexmk -interaction=nonstopmode cur.tex &> latexmk.log

    # Kopiere das generierte PDF zum gewünschten Speicherort
    cp cur.pdf /var/www/html/docker-step2023-team-06-web/

    # Räume temporäre Dateien auf
    rm -rf /tmp/latex-$$
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/cur.pdf"></head><body></body></html>'    
else
    echo '<!doctype html><html><head><meta charset="utf-8"><title>Webseite</title><meta http-equiv="refresh" content="0;url=https://informatik.hs-bremerhaven.de/docker-step2023-team-06-web/log.pdf"></head><body></body></html>'    
fi