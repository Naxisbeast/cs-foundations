"""A two-asset research note, built with the quant toolkit.

Loads data/prices.csv, computes returns, max drawdown, Sharpe, annualised
volatility, and the correlation between the two assets, then prints a
short report. This is the toolkit applied end to end to a real (if
synthetic) dataset - the same shape of analysis a data or quant role
would run on actual prices.
"""

import csv
import pathlib

from correlation import pearson_correlation
from returns_analysis import annualised_volatility, cumulative_return, max_drawdown
from risk_metrics import sharpe_ratio


def load_prices(path):
    asset_a = []
    asset_b = []
    with open(path, newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            asset_a.append(float(row["asset_a"]))
            asset_b.append(float(row["asset_b"]))
    return asset_a, asset_b


def main():
    path = pathlib.Path(__file__).resolve().parents[2] / "data" / "prices.csv"
    asset_a, asset_b = load_prices(path)

    print("Two-asset research note")
    print("=======================")
    for name, prices in (("asset_a", asset_a), ("asset_b", asset_b)):
        print(f"{name}: cumulative {cumulative_return(prices):+.2%}, "
              f"max drawdown {max_drawdown(prices):.2%}, "
              f"sharpe {sharpe_ratio(prices):.2f}, "
              f"annualised vol {annualised_volatility(prices):.2%}")
    print(f"correlation: {pearson_correlation(asset_a, asset_b):.3f}")


if __name__ == "__main__":
    main()
