"""
Skript zur Analyse und Visualisierung verschiedener diskreter Wahrscheinlichkeitsverteilungen.
Dieses Skript löst Aufgaben zur Hypergeometrischen, Binomial- und Poisson-Verteilung
und visualisiert die Wahrscheinlichkeitsmass Funktionen (PMF).

Autor: Kevin Nguefack
"""

import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import hypergeom, binom, poisson

# ---------------------------------------------------------
# Aufgabe 1: Hypergeometrische Verteilung
# Szenario: Urnenmodell ohne Zurücklegen.
# Parameter:
#   N = 5 (Gesamtanzahl der Elemente)
#   M = 3 (Anzahl der "Erfolge" in der Grundgesamtheit)
#   n = 4 (Anzahl der Züge)
# ---------------------------------------------------------
N, M, n = 5, 3, 4
x = np.arange(0, n + 1)
pmf_h = hypergeom.pmf(x, N, M, n)

plt.figure()
plt.stem(x, pmf_h, basefmt=' ')
plt.title('Aufgabe 1: Hypergeometrische Verteilung H(N=5, M=3, n=4)')
plt.xlabel('x (Anzahl Erfolge)')
plt.ylabel('P(X=x) (Wahrscheinlichkeit)')
plt.grid(True)

# ---------------------------------------------------------
# Aufgabe 2: Binomialverteilung
# Szenario: Ziehen mit Zurücklegen (Bernoulli-Experiment).
# Parameter:
#   n = 4 (Anzahl der Versuche)
#   p = 1/6 (Erfolgswahrscheinlichkeit, z.B. Würfeln einer 6)
# ---------------------------------------------------------
n2, p2 = 4, 1/6
x2 = np.arange(0, n2 + 1)
pmf_b = binom.pmf(x2, n2, p2)

plt.figure()
plt.stem(x2, pmf_b, basefmt=' ')
plt.title('Aufgabe 2: Binomialverteilung B(n=4, p=1/6)')
plt.xlabel('x (Anzahl Erfolge)')
plt.ylabel('P(X=x)')
plt.grid(True)

# ---------------------------------------------------------
# Aufgabe 3: Poisson-Verteilung
# Szenario: Modellierung seltener Ereignisse über die Zeit.
# Parameter:
#   Λ (Lambda) = Durchschnittliche Rate
#   Fälle: 1 Minute (Λ=2) und 3 Minuten (Λ=6)
# ---------------------------------------------------------
for Λ, label in [(2, '1 Min'), (6, '3 Min')]:
    k = np.arange(0, 20)
    pmf_p = poisson.pmf(k, Λ)
    plt.figure()
    plt.stem(k, pmf_p, basefmt=' ')
    plt.title(f'Aufgabe 3: Poisson-Verteilung(Λ={Λ}) – {label}')
    plt.xlabel('k (Anzahl Ereignisse)')
    plt.ylabel('P(X=k)')
    plt.grid(True)

plt.show()
