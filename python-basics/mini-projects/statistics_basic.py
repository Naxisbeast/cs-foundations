"""Basic statistics from scratch - mean, median, mode, variance, stddev.

Pure Python, no libraries for the math itself. The tests compare every
result against the stdlib `statistics` module. The point is the same one
as the linear regression: the "easy" statistics are a few sums and a
division, and knowing that means knowing when to trust them.

sample=True divides variance by (n - 1); sample=False divides by n.
"""


def mean(values):
    return sum(values) / len(values)


def median(values):
    ordered = sorted(values)
    n = len(ordered)
    mid = n // 2
    if n % 2 == 1:
        return ordered[mid]
    return (ordered[mid - 1] + ordered[mid]) / 2


def mode(values):
    """The most frequent value. Returns None for a uniform list."""
    counts = {}
    for value in values:
        counts[value] = counts.get(value, 0) + 1
    best = None
    best_count = 0
    for value, count in counts.items():
        if count > best_count:
            best = value
            best_count = count
    return best


def variance(values, sample=True):
    average = mean(values)
    squared_deviations = sum((value - average) ** 2 for value in values)
    denominator = len(values) - 1 if sample else len(values)
    return squared_deviations / denominator


def stddev(values, sample=True):
    return variance(values, sample) ** 0.5
