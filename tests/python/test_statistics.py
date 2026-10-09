"""pytest tests for the from-scratch statistics, checked against the stdlib."""

import statistics as stdlib

import pytest

from statistics_basic import mean, median, mode, stddev, variance


class TestStatisticsBasic:
    def test_mean(self):
        values = [1, 2, 3, 4, 5]
        assert mean(values) == stdlib.mean(values)

    def test_median_odd_and_even(self):
        assert median([3, 1, 2]) == 2
        assert median([4, 1, 2, 3]) == 2.5

    def test_mode(self):
        assert mode([1, 2, 2, 3, 3, 3]) == 3

    def test_variance_matches_stdlib(self):
        values = [2, 4, 6, 8, 10]
        assert variance(values) == pytest.approx(stdlib.variance(values))
        assert variance(values, sample=False) == pytest.approx(stdlib.pvariance(values))

    def test_stddev_matches_stdlib(self):
        values = [2, 4, 6, 8, 10]
        assert stddev(values) == pytest.approx(stdlib.stdev(values))
