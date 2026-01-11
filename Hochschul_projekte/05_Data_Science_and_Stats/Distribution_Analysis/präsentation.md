# Vortrag: Der zentrale Grenzwertsatz  
**Warum die Normalverteilung überall auftaucht**  

---

## 1. Einführung  
- **Motivation**  
  - Oft interessiert uns die Verteilung von Summen oder Durchschnitten unabhängiger Einzelwerte.  
  - Beispiele: Durchschnittliche Messfehler, Mittelwert von Umfrageergebnissen, Ergebnis mehrerer Zufallsprozesse.  
- **Erinnerung** (Vorlesung 2)  
  - Erwartungswert \(E(X)\) und Varianz \(\mathrm{Var}(X)\) als zentrale Lage- und Streuungs­maße.  
  - Für unabhängige \(X_i\):  
    \[
      E\Bigl(\sum_{i=1}^n X_i\Bigr)
      = \sum_{i=1}^n E(X_i), 
      \quad
      \mathrm{Var}\Bigl(\sum_{i=1}^n X_i\Bigr)
      = \sum_{i=1}^n \mathrm{Var}(X_i).
    \]

---

## 2. Statement des Zentralen Grenzwertsatzes  
> **ZGS (vereinfachte Formulierung):**  
> Seien \(X_1,\dots,X_n\) unabhängige Zufallsvariablen mit gleichem Mittelwert \(\mu\) und Varianz \(\sigma^2\). Dann gilt für den standardisierten Mittelwert  
> \[
> Z_n 
> = \frac{\sum_{i=1}^n X_i - n\mu}{\sigma\sqrt{n}}
> \;\xrightarrow{d}\; N(0,1)
> \quad (n\to\infty).
> \]  
> *„Konvergenz in Verteilung“ bedeutet: Die Verteilungsfunktion von \(Z_n\) nähert sich der Standardnormalverteilung an.*  

---

## 3. Anschauliche Beweisidee  
1. **Momentenerzeugende Funktionen (MGF)**  
   - MGF von Summe \(M_{S_n}(t)=\prod_{i=1}^n M_{X_i}(t)\).  
   - Standardisierung auf Mittelwert 0 und Varianz 1 führt bei \(n\to\infty\) zur MGF der Normalverteilung.  
2. **Taylor-Entwicklung**  
   - Log-MGF \(\ln M_{X}(t)\approx \mu t + \tfrac12\sigma^2t^2 + O(t^3)\).  
   - Summierung \(n\)-fach hebt nur lineare und quadratische Terme hervor, höhere Terme verschwinden im Grenzwert.  
3. **Kernaussage**  
   - Egal, wie die Ursprungsverteilung aussieht (sofern \(\mu,\sigma^2<\infty\)), die standardisierte Summe wird „glockenförmig“.

---

## 4. Numerische Demonstration  
Wir simulieren \(\bar X_n = \frac1n\sum_{i=1}^nX_i\) für zwei Ausgangsverteilungen und \(n=\{1,5,30\}\).

```python
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as st

def demo(dist, dist_name, n_list=[1,5,30], trials=10000):
    plt.figure(figsize=(10,6))
    for n in n_list:
        # Ziehe trials Stichproben der Größe n
        samples = dist(size=(trials, n))
        means   = samples.mean(axis=1)
        # Histogramm
        plt.hist(means, bins=50, density=True, alpha=0.5, label=f"n={n}")
        # Überlagere Normaldichte N(μ,σ²/n)
        mu = dist_mean
        sigma = dist_std / np.sqrt(n)
        x = np.linspace(means.min(), means.max(), 200)
        plt.plot(x, st.norm.pdf(x, mu, sigma), 'k--')
    plt.title(f"Simulation: Zentraler Grenzwertsatz für {dist_name}")
    plt.xlabel("Stichprobenmittelwert")
    plt.ylabel("Dichte")
    plt.legend()
    plt.show()

# 1) Gleichverteilung U(0,1)
dist_mean, dist_std = 0.5, np.sqrt(1/12)
demo(lambda size: np.random.rand(*size), "U(0,1)")

# 2) Exponentialverteilung Exp(λ=1)
dist_mean, dist_std = 1.0, 1.0
demo(lambda size: np.random.exponential(scale=1.0, size=size), "Exp(1)")
