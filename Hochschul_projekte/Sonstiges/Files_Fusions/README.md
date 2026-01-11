# File Fusion

## Java Anwendung zum zusammenführen von Dateien

Diese Anwendung soll es ermöglichen, den Inhalt von zwei Dateien
in eine Ausgabe-Datei zu schreiben.
Die eingabe Dateien werden nacheinander eingelesen und deren Inhalt
zeilenweise in die Ausgabe Datei geschrieben.

## Ist-Zustand

Derzeit funktioniert die Anwendung nur mit Text-Dateien

## Funktionen

Einlesen von Dateien
Überprüfung der existenz und lesbarkeit der Dateien
zusammenfügen der Inhalte in eine neue Ausgabedatei
Fehlerbehandlund bei unslesbaren oder nicht vorhandenen Dateien

## Verwendung

1. Starten Sie die Anwendung
2. Geben Sie den Namen der Ersten Eingabedatei 
**Beachten Sie das es sich um den Pfad handelt**, bestätigen Sie mit
Enter und geben Sie den Namen der Zweiten Eingabedatei **Pfad**
3. Geben Sie den Namen der Ausgebedatei **ein einfacher Name, kein Pfad**
4. Die erstellte Datei erscheint unter "C:/Users/<usernane>/Desktop/"
                z.b: "C:/Users/kevin/Desktop/"

## Struktur

FilesFusionApplication.java: Hauptklasse
Empfang.java: Behandelt die Eingaben für Eingabedateinamen
DateiExist.java: Prüft die Existenz der Dateien und führt sie zusammen
