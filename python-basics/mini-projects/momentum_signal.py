"""A tiny momentum strategy: SMA crossover on synthetic prices.

Generates a trending price series, holds when the short SMA is above the
long SMA, and compares the strategy's cumulative return and max drawdown
to buy-and-hold. A toy, not something you would trade - it exists to tie
the moving-average, returns, and drawdown modules together end to end,
and to show the three numbers a quant would actually quote.
"""

import random

from moving_average import simple_moving_average
from returns_analysis import cumulative_return, max_drawdown


def generate_prices(days=200, start=100.0, drift=0.001, volatility=0.02, seed=42):
    """A seeded random-walk-with-trend, so every run is reproducible."""
    rng = random.Random(seed)
    prices = [start]
    for _ in range(days - 1):
        change = rng.gauss(drift, volatility)
        prices.append(prices[-1] * (1 + change))
    return prices


def sma_cross_signals(prices, short_window, long_window):
    """1 when the short SMA is above the long SMA (hold), else 0 (flat)."""
    short = simple_moving_average(prices, short_window)
    long = simple_moving_average(prices, long_window)
    signals = []
    for i in range(len(prices)):
        if short[i] is None or long[i] is None:
            signals.append(0)      # flat until both averages exist
        elif short[i] > long[i]:
            signals.append(1)
        else:
            signals.append(0)
    return signals


def strategy_equity(prices, signals):
    """Equity curve of the strategy: flat days earn 0, hold days earn the daily return."""
    equity = [100.0]
    for i in range(1, len(prices)):
        daily = (prices[i] / prices[i - 1]) - 1 if signals[i] == 1 else 0.0
        equity.append(equity[-1] * (1 + daily))
    return equity


def main():
    prices = generate_prices()
    signals = sma_cross_signals(prices, short_window=5, long_window=20)
    equity = strategy_equity(prices, signals)

    print("Momentum signal over a synthetic price series (seeded, reproducible):")
    print(f"  buy-and-hold return:   {cumulative_return(prices):+.2%}")
    print(f"  strategy return:       {cumulative_return(equity):+.2%}")
    print(f"  strategy max drawdown: {max_drawdown(equity):.2%}")


if __name__ == "__main__":
    main()
