"""Moving averages - simple (SMA) and exponential (EMA).

A rolling mean smooths a series; an EMA weights recent points more. These
are the bread and butter of trend indicators, and both are small enough
to write by hand: SMA is a sliding window, EMA is a single-pass recursion.

The first window - 1 values of an SMA are None because there is not yet
enough data, which mirrors how real charting libraries handle the warm-up.
"""


def simple_moving_average(series, window):
    result = []
    for i in range(len(series)):
        if i < window - 1:
            result.append(None)
            continue
        result.append(sum(series[i - window + 1:i + 1]) / window)
    return result


def exponential_moving_average(series, span):
    alpha = 2 / (span + 1)
    result = []
    ema = None
    for value in series:
        ema = value if ema is None else alpha * value + (1 - alpha) * ema
        result.append(ema)
    return result
