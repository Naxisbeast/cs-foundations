"""pytest tests for the from-scratch linear regression."""

import pytest

from linear_regression import fit_least_squares, generate_data, predict


class TestLinearRegression:
    def test_exact_fit_on_perfect_line(self):
        xs = [0, 1, 2, 3, 4]
        ys = [1, 3, 5, 7, 9]   # y = 2x + 1, exact
        slope, intercept = fit_least_squares(xs, ys)
        assert slope == pytest.approx(2.0)
        assert intercept == pytest.approx(1.0)

    def test_predict_uses_the_fitted_line(self):
        xs = [0, 1, 2]
        ys = [5, 7, 9]
        slope, intercept = fit_least_squares(xs, ys)
        assert predict(slope, intercept, 3) == pytest.approx(11.0)

    def test_matches_numpy_on_noisy_data(self):
        numpy = pytest.importorskip("numpy")
        xs, ys = generate_data(2.5, 10.0, seed=1)
        slope, intercept = fit_least_squares(xs, ys)
        np_slope, np_intercept = numpy.polyfit(xs, ys, 1)
        assert slope == pytest.approx(np_slope, abs=1e-6)
        assert intercept == pytest.approx(np_intercept, abs=1e-6)

    def test_identical_x_values_rejected(self):
        with pytest.raises(ValueError):
            fit_least_squares([1, 1, 1], [2, 3, 4])
