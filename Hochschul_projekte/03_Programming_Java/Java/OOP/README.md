# OOP - Objektorientierte Programmierung

Dieses Verzeichnis enthält Übungen und Projekte zur objektorientierten Programmierung in Java.

## Projekte

### Conway's Game of Life
Eine Implementierung von Conway's Game of Life als objektorientiertes Programm.

**Dateien:**
- `Life.java` - Hauptklasse für die Game of Life Simulation
- `Stone.java` - Repräsentiert eine einzelne Zelle im Spielfeld
- `Life1001.java` - Alternative Life-Implementierung mit einfacheren Regeln
- `Life10.java` - Testklasse für Life1001

### Rationale Zahlen
Eine Klasse zur Darstellung und Bearbeitung rationaler Zahlen (Brüche).

**Dateien:**
- `Rational.java` - Klasse für rationale Zahlen mit Kürzungsfunktion

### Hauptprogramm
**Dateien:**
- `All_Ausführer.java` - Hauptprogramm, das verschiedene OOP-Beispiele ausführt

## Kompilierung und Ausführung

Alle Klassen befinden sich im Package `srcb`. Um die Programme zu kompilieren und auszuführen:

```bash
# Kompilieren
javac -d bin *.java

# Ausführen
java -cp bin srcb.All_Ausführer
```

## Konzepte

Die Projekte demonstrieren folgende OOP-Konzepte:
- Klassen und Objekte
- Konstruktoren
- Methoden
- Kapselung (private/public)
- Arrays von Objekten
- Rekursion (GGT-Berechnung)
