"""Merge sort — the Python mirror of MergeSort.java.

Time: O(n log n) for best, average, and worst. Space: O(n) for the merge
buffers. Stable because equal values come from the left half first.

This version returns a new sorted list instead of sorting in place — the
idiomatic Python approach, and slicing makes the merge much easier to
read than the index-juggling Java version does the same work.
"""


def sort(values):
    if len(values) <= 1:
        return values

    mid = len(values) // 2
    left = sort(values[:mid])
    right = sort(values[mid:])
    return merge(left, right)


def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result


if __name__ == "__main__":
    values = [5, 2, 9, 1, 7, 3]
    print("Sorted:", sort(values))
