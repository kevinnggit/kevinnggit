import numpy as np
import matplotlib.pyplot as plt


def plot_normal(mu, sigma, intervals, title):
    """
    Plot the normal distribution N(mu, sigma^2) and shade given intervals.

    Parameters:
    - mu: Mean of the distribution
    - sigma: Standard deviation
    - intervals: List of tuples (a, b) defining intervals to shade
    - title: Title of the plot
    """
    x = np.linspace(mu - 4 * sigma, mu + 4 * sigma, 400)
    y = (1 / (sigma * np.sqrt(2 * np.pi))) * np.exp(-0.5 * ((x - mu) / sigma) ** 2)

    plt.figure()
    plt.plot(x, y, linewidth=2)
    for a, b in intervals:
        mask = (x > a) & (x <= b)
        plt.fill_between(x[mask], y[mask], alpha=0.3)

    plt.title(title)
    plt.xlabel("x")
    plt.ylabel("f(x)")
    plt.grid(True)
    plt.show()


# Aufgabe 1: N(2,9) mit Intervallen (0,5) und (6,11)
plot_normal(mu=2, sigma=3, intervals=[(0, 5), (6, 11)], title="Aufgabe 1: Dichte N(2,9) mit schattierten Intervallen")

# Aufgabe 2: N(5,9) mit Intervallen (2,10) und (5,10)
plot_normal(mu=5, sigma=3, intervals=[(2, 10), (5, 10)], title="Aufgabe 2: Dichte N(5,9) mit schattierten Intervallen")
