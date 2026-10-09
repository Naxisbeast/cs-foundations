"""Percentiles, z-scores, and min-max scaling - the three normalisations.

Different problems want different scales: a percentile tells you where a
value sits in its distribution, a z-score tells you how many standard
deviations from the mean it is, and min-max scaling maps a column into
[0, 1]. All three are a handful of lines.
"""

from statistics_basic import mean, stddev


def percentile(values, p):
    """The p-th percentile (0-100) using linear interpolation."""
    ordered = sorted(values)
    index = (p / 100) * (len(ordered) - 1)
    lower = int(index)
    upper = min(lower + 1, len(ordered) - 1)
    fraction = index - lower
    return ordered[lower] * (1 - fraction) + ordered[upper] * fraction


def z_score(value, values):
    return (value - mean(values)) / stddev(values)


def min_max_normalize(values):
    low = min(values)
    high = max(values)
    if high == low:
        return [0.0 for _ in values]   # a flat column has no range to scale
    return [(value - low) / (high - low) for value in values]
