# Präsentation: Der zentrale Grenzwertsatz

**Warum die Normalverteilung überall auftaucht**

---

## 1. Motivation
- Viele Fragestellungen benutzen **Durchschnittswerte** oder **Summen** unabhängiger Beobachtungen (Temperaturen, Umfrageergebnisse, Messfehler).
- Ohne Zentralen Grenzwertsatz (ZGS) müsste man für jede Ausgangsverteilung eigene Formeln aufstellen.
- Mit ZGS reicht bei ausreichend großer Stichprobe die **Normalverteilung** als Approximation.

---

## 2. Aussage des ZGS
> **Formulierung:** Sind $X_1,\dots,X_n$ unabhängige Zufallsvariablen mit Erwartungswert $\mu$ und Varianz $\sigma^2 < \infty$, dann gilt
> \[
> Z_n = \frac{\sum_{i=1}^n X_i - n\mu}{\sigma\sqrt n}
> \;\xrightarrow{d}\; N(0,1) \quad (n\to\infty).
> \]
> Durch **Standardisierung** besitzt $Z_n$ Mittelwert $0$ und Varianz $1$.

- **Konvergenz in Verteilung**: Die Verteilungsfunktion von $Z_n$ nähert sich der Standardnormalverteilung an.
- Gilt unabhängig von der Form der Ausgangsverteilung (sofern Varianz endlich).

---

## 3. Beweisidee (Skizze)
1. **Momentenerzeugende Funktionen**: Für $S_n=\sum X_i$ gilt $M_{S_n}(t)=M_X(t)^n$.
2. **Taylor-Entwicklung**: $\ln M_X(t) = \mu t + \tfrac12 \sigma^2 t^2 + O(t^3)$.
3. **Grenzwert**: Höhere Terme werden bei $n\to\infty$ vernachlässigbar, sodass die MGF von $Z_n$ gegen $e^{t^2/2}$ konvergiert – die MGF von $N(0,1)$.

---

## 4. Numerische Demonstration (Python)
```python
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as st

def demo(dist_func, name, mu, sigma, ns=(1, 5, 30), trials=10000):
    plt.figure(figsize=(8, 5))
    for n in ns:
        samples = dist_func(size=(trials, n)).mean(axis=1)
        plt.hist(samples, bins=50, density=True, alpha=0.4, label=f"n={n}")
        x = np.linspace(samples.min(), samples.max(), 200)
        plt.plot(x, st.norm.pdf(x, mu, sigma/np.sqrt(n)), "k--")
    plt.title(f"ZGS-Demonstration für {name}")
    plt.xlabel("Stichprobenmittelwert")
    plt.ylabel("Dichte")
    plt.legend()
    plt.show()

# Gleichverteilung U(0,1)
demo(lambda size: np.random.rand(*size), "U(0,1)", mu=0.5, sigma=np.sqrt(1/12))
# Exponentialverteilung Exp(1)
demo(lambda size: np.random.exponential(1, size=size), "Exp(1)", mu=1.0, sigma=1.0)
```

Bei $n=1$ entspricht die Verteilung des Mittels der Ausgangsverteilung.
Mit $n=5$ zeigt sich eine Glockenform, und bei $n=30$ ist die Normalapproximation sehr genau.

---

## 5. Anwendungsbeispiele
- **Messtechnik**: Fehlerfortpflanzung in Messketten → Gaußsche Fehlerverteilung.
- **Sozial- und Wirtschaftswissenschaften**: Durchschnittseinkommen, Umfrageergebnisse.
- **Biostatistik**: Mittelwerte aus Laborparametern oder klinischen Studien.
- **Qualitätskontrolle**: $\overline X$- und $R$-Kontrollkarten in der Prozessüberwachung.
- **Finanzwesen**: Aggregierte Renditen vieler kleiner, unabhängiger Transaktionen.

---

## 6. Grenzen der Anwendung
- Sehr schiefe Verteilungen erfordern größere Stichprobenumfänge.
- Verteilungen mit unendlicher Varianz (z. B. Pareto mit $\alpha\le 2$) verletzen die Voraussetzungen.
- In der Praxis gilt häufig: $n \ge 30$ genügt für eine gute Approximation.

---

## 7. Fazit
Der zentrale Grenzwertsatz macht die Normalverteilung zu einer universellen Sprache der Statistik:
- Er erklärt, warum Mittelwerte verschiedenster Prozesse oft normalverteilt sind.
- Er bildet die Grundlage vieler statistischer Verfahren und erlaubt verlässliche Approximationen.

Damit lassen sich Wahrscheinlichkeiten, Konfidenzintervalle und Teststatistiken selbst ohne exakte Kenntnis der Ausgangsverteilung effizient berechnen.
