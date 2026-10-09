"""Monte-carlo simulation - estimate pi, and a random-walk terminal VaR.

Two uses of the same idea: draw many random samples and measure the
outcome. Estimating pi by throwing points at a quarter-circle is the
classic demo; the random-walk terminals are the quant-flavoured one -
run many possible futures of a price and read the distribution off the
endpoints.
"""

import random


def estimate_pi(samples=100_000, seed=42):
    """Pi by counting random points inside a unit quarter-circle."""
    rng = random.Random(seed)
    inside = 0
    for _ in range(samples):
        x = rng.random()
        y = rng.random()
        if x * x + y * y <= 1.0:
            inside += 1
    return 4 * inside / samples


def random_walk_terminals(start=100.0, steps=100, volatility=0.02,
                          paths=1000, seed=7):
    """Ending prices of many seeded random walks, for a terminal VaR."""
    rng = random.Random(seed)
    terminals = []
    for _ in range(paths):
        price = start
        for _ in range(steps):
            price *= (1 + rng.gauss(0, volatility))
        terminals.append(price)
    return terminals
