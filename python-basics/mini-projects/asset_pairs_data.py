"""Generates the two-asset price series used by the research note.

Writes data/prices.csv with columns day, asset_a, asset_b. Seeded and
deterministic, so the committed CSV is reproducible and every analysis
built on it is too. asset_b shares part of asset_a's daily return, which
is what makes the correlation positive and the note interesting.
"""

import csv
import pathlib
import random


def generate_prices(days=250, seed=11):
    rng = random.Random(seed)
    asset_a = [100.0]
    asset_b = [80.0]
    for _ in range(days - 1):
        a_return = rng.gauss(0.001, 0.015)
        asset_a.append(asset_a[-1] * (1 + a_return))
        b_return = 0.7 * a_return + rng.gauss(0.0005, 0.01)
        asset_b.append(asset_b[-1] * (1 + b_return))
    return asset_a, asset_b


def write_csv(path, asset_a, asset_b):
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(path, "w", newline="") as file:
        writer = csv.writer(file)
        writer.writerow(["day", "asset_a", "asset_b"])
        for i in range(len(asset_a)):
            writer.writerow([i + 1, round(asset_a[i], 2), round(asset_b[i], 2)])


def main():
    asset_a, asset_b = generate_prices()
    out = pathlib.Path(__file__).resolve().parents[2] / "data" / "prices.csv"
    write_csv(out, asset_a, asset_b)
    print(f"wrote {out} with {len(asset_a)} rows")


if __name__ == "__main__":
    main()
