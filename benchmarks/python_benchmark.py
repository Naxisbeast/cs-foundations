"""Timing harness for the Python data structures.

Measures how our implementations scale against Python's built-ins and
writes benchmarks/python_results.csv plus a plot. The point is to test
the Big O claims in notes/time-complexity.md against a stopwatch, not
just repeat them.

Run:  python benchmarks/python_benchmark.py
"""

import csv
import sys
import time
from pathlib import Path

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "python-basics/data-structures"))

from stack import Stack
from queue import Queue
from binary_search import search
from merge_sort import sort as merge_sort

SIZES = [1_000, 10_000, 100_000, 1_000_000]


def measure(fn, *args):
    start = time.perf_counter()
    fn(*args)
    return time.perf_counter() - start


def stack_ops(n):
    stack = Stack()
    for i in range(n):
        stack.push(i)
    for _ in range(n):
        stack.pop()


def queue_ops(n):
    queue = Queue()
    for i in range(n):
        queue.enqueue(i)
    for _ in range(n):
        queue.dequeue()


def time_sorting():
    rows = []
    for n in SIZES:
        data = list(range(n, 0, -1))                       # reverse-sorted input
        rows.append((n, "merge_sort", measure(lambda d: merge_sort(d), data)))
        rows.append((n, "sorted()", measure(lambda d: sorted(d), data)))
    return rows


def time_search():
    rows = []
    for n in SIZES:
        data = list(range(n))
        target = n - 1
        rows.append((n, "binary_search", measure(lambda: search(data, target))))
        rows.append((n, "list.index", measure(lambda: data.index(target))))
    return rows


def time_stack_queue():
    rows = []
    for n in SIZES:
        rows.append((n, "stack push+pop", measure(stack_ops, n)))
        rows.append((n, "queue enqueue+dequeue", measure(queue_ops, n)))
    return rows


def write_csv(filename, rows):
    with open(filename, "w", newline="", encoding="utf-8") as file:
        writer = csv.writer(file)
        writer.writerow(["n", "operation", "seconds"])
        writer.writerows(rows)


def plot(result_sets, filename):
    titles = ["Sorting", "Search", "Stack / Queue"]
    fig, axes = plt.subplots(1, 3, figsize=(14, 4))

    for ax, title, rows in zip(axes, titles, result_sets):
        operations = sorted({row[1] for row in rows})
        for operation in operations:
            points = [row for row in rows if row[1] == operation]
            xs = [row[0] for row in points]
            ys = [row[2] for row in points]
            ax.plot(xs, ys, marker="o", label=operation)
        ax.set_xscale("log")
        ax.set_yscale("log")
        ax.set_xlabel("n")
        ax.set_ylabel("seconds")
        ax.set_title(title)
        ax.legend(fontsize=8)
        ax.grid(True, which="both", alpha=0.3)

    fig.tight_layout()
    fig.savefig(filename, dpi=120)
    print(f"wrote {filename}")


def main():
    sorting = time_sorting()
    searching = time_search()
    stack_queue = time_stack_queue()
    all_rows = sorting + searching + stack_queue

    csv_path = ROOT / "benchmarks" / "python_results.csv"
    png_path = ROOT / "benchmarks" / "python_scaling.png"
    write_csv(csv_path, all_rows)
    plot([sorting, searching, stack_queue], png_path)

    print("\n=== timings (seconds) ===")
    for n, operation, seconds in all_rows:
        print(f"{n:>9}  {operation:<22} {seconds:.4f}")


if __name__ == "__main__":
    main()
