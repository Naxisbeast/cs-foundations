"""pytest tests for the bootstrap confidence interval."""

from bootstrap_ci import bootstrap_confidence_interval
from statistics_basic import mean


class TestBootstrapCI:
    def test_true_mean_lies_within_interval(self):
        values = [5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
        low, high = bootstrap_confidence_interval(values)
        assert low < mean(values) < high

    def test_is_deterministic_with_seed(self):
        values = [1, 2, 3, 4, 5, 6]
        assert (bootstrap_confidence_interval(values, seed=1)
                == bootstrap_confidence_interval(values, seed=1))
