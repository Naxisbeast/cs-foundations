"""Returns, cumulative return, max drawdown, and annualised volatility.

Given a price series, compute the numbers a quant actually quotes: daily
returns, cumulative growth, the worst peak-to-trough drop, and volatility
scaled to a year. Pure Python; the standard deviation comes from
statistics_basic.
"""

from statistics_basic import stddev


def daily_returns(prices):
    return [(prices[i] / prices[i - 1]) - 1 for i in range(1, len(prices))]


def cumulative_return(prices):
    return (prices[-1] / prices[0]) - 1


def max_drawdown(prices):
    """Worst peak-to-trough drop, as a fraction of the peak (0 = none)."""
    peak = prices[0]
    worst = 0.0
    for price in prices:
        peak = max(peak, price)
        drawdown = (peak - price) / peak
        worst = max(worst, drawdown)
    return worst


def annualised_volatility(prices, trading_days=252):
    return stddev(daily_returns(prices)) * (trading_days ** 0.5)
