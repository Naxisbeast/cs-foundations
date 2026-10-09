"""pytest tests for the returns and drawdown analysis."""

import pytest

from returns_analysis import (annualised_volatility, cumulative_return,
                              daily_returns, max_drawdown)


class TestReturnsAnalysis:
    def test_daily_returns(self):
        prices = [100, 110, 99]
        returns = daily_returns(prices)
        assert returns[0] == pytest.approx(0.10)
        assert returns[1] == pytest.approx(-0.10, abs=1e-9)

    def test_cumulative_return(self):
        assert cumulative_return([100, 110, 121]) == pytest.approx(0.21)

    def test_max_drawdown(self):
        # Peak 110, trough 90: worst drop is (110 - 90) / 110.
        assert max_drawdown([100, 110, 90]) == pytest.approx(20 / 110)

    def test_no_drawdown_for_monotonic_rise(self):
        assert max_drawdown([100, 110, 130]) == 0.0

    def test_volatility_is_positive(self):
        assert annualised_volatility([100, 101, 99, 102, 100]) > 0
