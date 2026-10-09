# Quant Toolkit — Python

A small set of pure-Python modules for the numbers a data or quant role actually works with. No pandas, no numpy in the math itself — the tests check the results against the stdlib and NumPy so the implementations are proven, not guessed.

| Module | Computes | Tests against |
|---|---|---|
| `statistics_basic.py` | mean, median, mode, variance, stddev | stdlib `statistics` |
| `moving_average.py` | simple (SMA) and exponential (EMA) averages | hand-computed values |
| `returns_analysis.py` | daily returns, cumulative return, max drawdown, annualised volatility | known series |
| `correlation.py` | Pearson correlation | `numpy.corrcoef` |
| `normalize.py` | percentiles, z-scores, min-max scaling | known distributions |
| `momentum_signal.py` | an end-to-end SMA-crossover demo over synthetic prices | deterministic output |
| `risk_metrics.py` | Sharpe ratio, rolling volatility, historical value-at-risk | known series |
| `bootstrap_ci.py` | bootstrap confidence interval for the mean | determinism + coverage |
| `monte_carlo.py` | pi estimation and random-walk terminal distribution | seeded determinism |
| `asset_pairs_data.py` | generates the two-asset `data/prices.csv` used by the note | reproducible output |
| `research_note.py` | a two-asset report: returns, drawdown, Sharpe, correlation | sane ranges |

## Why from scratch

Same reason as the linear regression: knowing that variance is *a sum of squared deviations divided by n − 1* means you know when to trust it and when to suspect it. Every one of these is a few lines of sums, and the test suite proves each line against the library version.

## Run

```bash
python python-basics/mini-projects/momentum_signal.py    # the end-to-end demo
python -m pytest tests/python                            # the whole suite
```

## The numbers to quote

- **Max drawdown** is the worst peak-to-trough drop as a fraction of the peak — the number risk people actually care about.
- **Annualised volatility** is daily stddev scaled by sqrt(252) — the number of trading days in a year.
- **A z-score of −1.5** means "one and a half standard deviations below the mean", which is the same story in any dataset.
