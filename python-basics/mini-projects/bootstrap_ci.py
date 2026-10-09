"""Bootstrap confidence interval for the mean.

Resample the data with replacement many times, compute the mean of each
resample, and take the 2.5th and 97.5th percentiles as the confidence
interval. Non-parametric: it makes no assumption that the data is normal,
which is exactly why it exists.
"""

import random

from normalize import percentile
from statistics_basic import mean


def bootstrap_confidence_interval(values, samples=1000, seed=42, alpha=0.05):
    rng = random.Random(seed)
    n = len(values)

    resampled_means = []
    for _ in range(samples):
        resample = [values[rng.randrange(n)] for _ in range(n)]
        resampled_means.append(mean(resample))

    low = percentile(resampled_means, 100 * alpha / 2)
    high = percentile(resampled_means, 100 * (1 - alpha / 2))
    return low, high
