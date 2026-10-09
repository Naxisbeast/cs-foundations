"""Pearson correlation from scratch, compared with NumPy in the tests.

Correlation measures how two series move together, on a -1..1 scale. The
formula is the covariance divided by the product of the standard
deviations - pure sums again, which is why it costs a few lines instead
of a library call.
"""


def pearson_correlation(xs, ys):
    n = len(xs)
    mean_x = sum(xs) / n
    mean_y = sum(ys) / n

    covariance = sum((x - mean_x) * (y - mean_y) for x, y in zip(xs, ys))
    std_x = (sum((x - mean_x) ** 2 for x in xs)) ** 0.5
    std_y = (sum((y - mean_y) ** 2 for y in ys)) ** 0.5

    if std_x == 0 or std_y == 0:
        return 0.0   # a flat series has no correlation to measure
    return covariance / (std_x * std_y)
