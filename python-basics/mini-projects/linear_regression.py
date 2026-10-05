"""Simple linear regression from scratch, compared against NumPy.

Fits y = slope * x + intercept by least squares using only pure Python -
sums and mean-subtraction - then checks the same fit with numpy.polyfit.
The point is to show what the library is doing underneath: the closed-form
solution is a few sums, not magic.
"""


def fit_least_squares(xs, ys):
    """Return (slope, intercept) for y = slope * x + intercept."""
    n = len(xs)
    mean_x = sum(xs) / n
    mean_y = sum(ys) / n

    numerator = sum((x - mean_x) * (y - mean_y) for x, y in zip(xs, ys))
    denominator = sum((x - mean_x) ** 2 for x in xs)
    if denominator == 0:
        raise ValueError("all x values are identical - the line is vertical")

    slope = numerator / denominator
    intercept = mean_y - slope * mean_x
    return slope, intercept


def predict(slope, intercept, x):
    return slope * x + intercept


def generate_data(slope, intercept, count=50, noise=5.0, seed=42):
    """A line with some uniform noise, for testing the fit."""
    import random

    rng = random.Random(seed)
    xs = [float(i) for i in range(count)]
    ys = [slope * x + intercept + rng.uniform(-noise, noise) for x in xs]
    return xs, ys


def main():
    import numpy as np

    xs, ys = generate_data(2.5, 10.0)
    slope, intercept = fit_least_squares(xs, ys)
    np_slope, np_intercept = np.polyfit(xs, ys, 1)

    print(f"pure Python:   y = {slope:.4f}x + {intercept:.4f}")
    print(f"numpy.polyfit: y = {np_slope:.4f}x + {np_intercept:.4f}")
    print(f"slope within {abs(slope - np_slope):.2e}, "
          f"intercept within {abs(intercept - np_intercept):.2e}")


if __name__ == "__main__":
    main()
