# Assignment 07: Hybrid Sorting Algorithm

## Topic / Concept Focus

This learning exercise focused on hybrid sorting, array manipulation, operation counting, and time complexity analysis.

The implementation in `src/HybridSort.java` combines:

- Quick Sort for the main sorting process
- Insertion Sort for small subarrays

The program switches to Insertion Sort when the current subarray size is smaller than the threshold value of `10`.

## Task Summary

The task was about sorting an integer dataset using a hybrid sorting approach instead of relying on only one sorting algorithm.

In my own words, the idea was to use Quick Sort for larger sections of the array because it is usually efficient, then switch to Insertion Sort for smaller sections because insertion sort can be simple and effective on small subarrays.

The program also tracks the number of comparisons and swaps so that the sorting process can be discussed in terms of performance, not just final output.

## Data Structures And Algorithms Used

- Integer array
- Hybrid Quick Sort
- Insertion Sort
- Partitioning around a pivot
- Comparison counting
- Swap counting
- Best-case, average-case, and worst-case complexity analysis

## Main Implementation Details

| Item | Details |
|---|---|
| Source file | `src/HybridSort.java` |
| Main dataset size | 22 integers |
| Hybrid threshold | `10` |
| Main algorithm | Quick Sort |
| Small-subarray algorithm | Insertion Sort |
| Pivot choice | Last element of the current subarray |
| Reported comparisons | `64` for the included dataset |
| Reported swaps | `45` for the included dataset |

## Sample Dataset

```text
34 7 23 32 5 62 15 1 90 45 12 3 57 100 78 93 11 56 78 0 5 36
```

## Sample Output

```text
Sorted Array:
0 1 3 5 5 7 11 12 15 23 32 34 36 45 56 57 62 78 78 90 93 100

Total Comparisons: 64
Total Swaps: 45
```

## Time Complexity

| Case | Complexity | Explanation |
|---|---|---|
| Best case | O(n log n) | Quick Sort partitions the array reasonably evenly. |
| Average case | O(n log n) | Typical Quick Sort behaviour with balanced enough partitions. |
| Worst case | O(n^2) | Poor pivot choices can create very unbalanced partitions. |

The Insertion Sort part is used only for small subarrays below the threshold. This keeps the implementation simple while showing how a hybrid approach can combine the strengths of two algorithms.

## What I Learned

- How Quick Sort divides an array using a pivot.
- How Insertion Sort can be useful for small sections of data.
- How a hybrid algorithm can switch strategies based on input size.
- How comparisons and swaps help explain algorithm performance.
- Why best-case, average-case, and worst-case complexity can be different.

## How I Would Improve It Now

- Make the threshold easier to experiment with from user input or a constant section.
- Add more datasets, such as already sorted, reverse-sorted, and random arrays.
- Separate sorting logic from output/reporting logic.
- Add unit tests for the sorting result and operation counters.
- Compare the hybrid sort against plain Quick Sort and plain Insertion Sort.

## Source Files

```text
src/
`-- HybridSort.java
```

This folder contains a cleaned learning summary and source code only. It does not include private submission screenshots, academic portal details, student numbers, or original university instruction PDFs.
