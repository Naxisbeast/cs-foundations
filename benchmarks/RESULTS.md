# Benchmark Results

Captured from `Benchmark.java` on this machine (Windows 11, JDK 23). These are illustrative timings, not rigorous benchmarks — JIT warm-up, machine load, and array sizes all move the numbers — but they show the *shape* of the complexity claims in [`notes/time-complexity.md`](../notes/time-complexity.md).

## Fibonacci — O(2^n) recursive vs O(n) memoized

| Version | Fibonacci(40) | Time |
|---|---|---|
| recursive | 102334155 | 488 ms |
| memoized | 102334155 | <1 ms |
| **speedup** | | **~488×** |

The recursive version recomputes every overlapping subproblem; the memoized version stores each answer once. The gap grows exponentially with `n` — at `n = 50` recursive would take hours.

## Sorting — repo `MergeSort` vs JDK `Arrays.sort`, n = 100,000

| Input | MergeSort | Arrays.sort |
|---|---|---|
| random | 22 ms | 23 ms |
| already sorted | 10 ms | 2 ms |
| reverse sorted | 7 ms | 3 ms |

Both are O(n log n); the JDK sort pulls ahead on nearly-sorted input because TimSort exploits existing order and the JIT has tuned it far beyond a teaching implementation. On random data they are effectively tied at this size.

## Run it yourself

```bash
javac -d out data-structures/sorting/MergeSort.java benchmarks/Benchmark.java
java -cp out Benchmark
```
