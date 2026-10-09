"""Risk-adjusted metrics: Sharpe ratio, rolling volatility, value at risk.

Sharpe is the excess return per unit of risk, annualised. Rolling
volatility is the stddev over a trailing window, scaled to a year.
Historical VaR is the worst daily loss at a chosen percentile - the
"5% of days are worse than this" number, read straight off the history
with no distribution assumption.
"""

from statistics_basic import mean, stddev
from returns_analysis import daily_returns


def sharpe_ratio(prices, risk_free=0.0, trading_days=252):
    """Annualised excess return per unit of risk."""
    returns = daily_returns(prices)
    deviation = stddev(returns)
    if deviation == 0:
        return 0.0
    excess = mean(returns) - (risk_free / trading_days)
    return (excess / deviation) * (trading_days ** 0.5)


def rolling_volatility(prices, window=20, trading_days=252):
    """Annualised volatility over a trailing window, aligned to the returns."""
    returns = daily_returns(prices)
    result = []
    for i in range(len(returns)):
        start = max(0, i - window + 1)
        window_returns = returns[start:i + 1]
        if len(window_returns) < 2:
            result.append(0.0)   # a single point has no variance to measure
            continue
        result.append(stddev(window_returns) * (trading_days ** 0.5))
    return result


def historical_value_at_risk(prices, percentile=5):
    """Worst daily loss at the given percentile, as a positive fraction."""
    returns = sorted(daily_returns(prices))
    index = int(len(returns) * (percentile / 100))
    return -returns[index]
