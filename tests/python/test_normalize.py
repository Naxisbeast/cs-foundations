"""pytest tests for the percentile, z-score, and min-max normalisation."""

import pytest

from normalize import min_max_normalize, percentile, z_score


class TestNormalize:
    def test_percentile_endpoints_and_middle(self):
        values = [10, 20, 30, 40]
        assert percentile(values, 0) == 10
        assert percentile(values, 100) == 40
        assert percentile(values, 50) == pytest.approx(25)

    def test_z_score_of_mean_is_zero(self):
        values = [2, 4, 6, 8, 10]
        assert z_score(6, values) == pytest.approx(0.0)

    def test_min_max_scales_to_zero_one(self):
        assert min_max_normalize([10, 20, 30]) == [0.0, 0.5, 1.0]

    def test_flat_column_scales_to_zeros(self):
        assert min_max_normalize([7, 7, 7]) == [0.0, 0.0, 0.0]
