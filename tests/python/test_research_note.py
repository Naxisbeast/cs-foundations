"""pytest tests for the two-asset research note."""

from pathlib import Path

from correlation import pearson_correlation
from research_note import load_prices

DATA = Path(__file__).resolve().parents[2] / "data" / "prices.csv"


class TestResearchNote:
    def test_load_prices_reads_every_row(self):
        asset_a, asset_b = load_prices(DATA)
        assert len(asset_a) == 250
        assert len(asset_b) == 250

    def test_assets_are_positively_correlated_by_construction(self):
        asset_a, asset_b = load_prices(DATA)
        assert pearson_correlation(asset_a, asset_b) > 0.3

    def test_metrics_are_sane(self):
        from returns_analysis import annualised_volatility, max_drawdown
        from risk_metrics import sharpe_ratio

        asset_a, _ = load_prices(DATA)
        assert 0.0 < max_drawdown(asset_a) < 0.5
        assert 0.0 < annualised_volatility(asset_a) < 1.0
        assert sharpe_ratio(asset_a) > 0.0
