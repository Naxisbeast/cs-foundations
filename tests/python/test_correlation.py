"""pytest tests for the Pearson correlation, checked against NumPy."""

import pytest

from correlation import pearson_correlation


class TestCorrelation:
    def test_perfect_positive(self):
        xs = [1, 2, 3, 4, 5]
        ys = [2, 4, 6, 8, 10]
        assert pearson_correlation(xs, ys) == pytest.approx(1.0)

    def test_perfect_negative(self):
        xs = [1, 2, 3, 4, 5]
        ys = [5, 4, 3, 2, 1]
        assert pearson_correlation(xs, ys) == pytest.approx(-1.0)

    def test_flat_series_returns_zero(self):
        assert pearson_correlation([1, 2, 3, 4, 5], [3, 3, 3, 3, 3]) == 0.0

    def test_matches_numpy(self):
        numpy = pytest.importorskip("numpy")
        rng = numpy.random.default_rng(7)
        xs = rng.normal(size=100)
        ys = 2.0 * xs + rng.normal(size=100) * 0.5
        ours = pearson_correlation(list(xs), list(ys))
        np_corr = numpy.corrcoef(xs, ys)[0, 1]
        assert ours == pytest.approx(np_corr, abs=1e-9)
