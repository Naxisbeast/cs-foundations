"""pytest tests for the moving average module."""

from moving_average import exponential_moving_average, simple_moving_average


class TestMovingAverage:
    def test_sma_of_known_series(self):
        series = [1, 2, 3, 4, 5]
        assert simple_moving_average(series, 3) == [None, None, 2.0, 3.0, 4.0]

    def test_sma_window_larger_than_series_is_all_none(self):
        assert simple_moving_average([1, 2], 5) == [None, None]

    def test_ema_first_value_is_first_price(self):
        series = [10, 20, 30]
        assert exponential_moving_average(series, span=5)[0] == 10

    def test_ema_follows_the_trend(self):
        series = [1, 2, 3, 4, 5]
        ema = exponential_moving_average(series, span=3)
        assert ema[-1] > ema[0]
        assert all(value is not None for value in ema)
