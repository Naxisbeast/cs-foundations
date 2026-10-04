# Hybrid Sort Crossover Study

`SortCrossover.java` turns academic-assignments assignment 7 into an actual experiment: it parametrises the hybrid sort's insertion-sort cutoff and measures where the crossover really is. Run it with:

```bash
javac -d out benchmarks/SortCrossover.java && java -cp out SortCrossover
```

## Time by size (random data, ms)

| n | insertion | plain quick | hybrid (cutoff 10) |
|---|---:|---:|---:|
| 100 | 0.07 | 0.04 | 0.03 |
| 1,000 | 2.34 | 0.39 | 0.11 |
| 5,000 | 6.35 | 0.57 | 0.68 |
| 10,000 | 27.99 | 0.83 | 0.76 |
| 50,000 | 594.74 | 4.45 | 4.07 |

## Threshold sweep at n = 10,000

| threshold | hybrid time (ms) |
|---|---:|
| 0 | 0.79 |
| 5 | 0.76 |
| 10 | 0.74 |
| 20 | 0.68 |
| 40 | 0.66 |
| 100 | 0.69 |

## Best / average / worst case at n = 10,000

| input | plain quick | hybrid (10) |
|---|---:|---:|
| random | 0.81 | 0.72 |
| sorted | 63.49 | 62.51 |
| reverse | 59.81 | 59.82 |

## What the experiment actually says

**1. The crossover is very low.** Insertion sort is already slower than quicksort at n = 100 (0.07 vs 0.04 ms) and falls apart quadratically from there. Its O(n²) makes it a small-subarray tool, and the cutoff of 10 sits safely inside that zone. The classic "insertion sort wins on tiny inputs" claim is true only for very small n.

**2. The exact threshold barely matters.** Sweeping 0 → 100 at n = 10,000 changes the time by ~15%, within measurement noise. The cutoff is a constant-factor tweak, not a complexity change. Assignment 7's threshold of 10 is fine; 20 or 40 would be equally defensible.

**3. The honest finding — the hybrid does not fix the worst case.** On sorted or reverse input, Lomuto partitioning with a last-element pivot hits its O(n²) path: ~63 ms at n = 10,000 versus ~0.8 ms on random data. The insertion cutoff only helps small subarrays; it does nothing for a bad pivot. **If I redid assignment 7, I'd use a random or median-of-three pivot** — that is the fix that actually matters, and it's the answer I'd give in an interview when asked what I'd change.
