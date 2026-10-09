"""pytest tests for the risk-adjusted metrics."""

import pytest

from risk_metrics import (historical_value_at_risk, rolling_volatility,
                          sharpe_ratio)


class TestRiskMetrics:
    def test_sharpe_of_upward_series_beats_noisy_flat(self):
        upward = [100, 101, 102, 103, 104, 105]
        noisy = [100, 103, 97, 102, 98, 101]
        assert sharpe_ratio(upward) > sharpe_ratio(noisy)

    def test_sharpe_of_flat_series_is_zero(self):
        assert sharpe_ratio([100, 100, 100, 100]) == 0.0

    def test_rolling_volatility_matches_returns_length(self):
        prices = [100, 102, 99, 101, 103, 100]
        assert len(rolling_volatility(prices)) == len(prices) - 1

    def test_via_known_series(self):
        # Returns of [100, 200, 100, 200, 100] are 1.0, -0.5, 1.0, -0.5.
        prices = [100, 200, 100, 200, 100]
        assert historical_value_at_risk(prices, percentile=5) == pytest.approx(0.5)
