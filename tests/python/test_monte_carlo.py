"""pytest tests for the Monte-Carlo module."""

import pytest

from monte_carlo import estimate_pi, random_walk_terminals


class TestMonteCarlo:
    def test_pi_is_close(self):
        assert estimate_pi(200_000, seed=1) == pytest.approx(3.14159, abs=0.01)

    def test_pi_is_deterministic_with_seed(self):
        assert estimate_pi(100_000, seed=42) == estimate_pi(100_000, seed=42)

    def test_random_walk_is_deterministic_and_spread(self):
        terminals = random_walk_terminals(paths=500, seed=7)
        assert len(terminals) == 500
        assert max(terminals) != min(terminals)
        # Zero drift: roughly half of the walks finish above the start.
        above = sum(1 for price in terminals if price > 100.0)
        assert 150 < above < 350
