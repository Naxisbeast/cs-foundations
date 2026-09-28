"""Binary search over a sorted list — the Python mirror of BinarySearch.java.

Time: O(log n). Space: O(1) iterative, O(log n) for the recursive stack.

The mid point is low + (high - low) // 2. Python ints never overflow,
but the habit matters — in Java and C++ that subtraction is what keeps
huge arrays from breaking (low + high) / 2.
"""


def search(values, target):
    """Return the index of target, or -1."""
    low = 0
    high = len(values) - 1

    while low <= high:
        mid = low + (high - low) // 2
        if values[mid] == target:
            return mid
        if values[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def search_recursive(values, target):
    return _search_recursive(values, target, 0, len(values) - 1)


def _search_recursive(values, target, low, high):
    if low > high:
        return -1
    mid = low + (high - low) // 2
    if values[mid] == target:
        return mid
    if values[mid] < target:
        return _search_recursive(values, target, mid + 1, high)
    return _search_recursive(values, target, low, mid - 1)


if __name__ == "__main__":
    numbers = [2, 4, 6, 8, 10, 12, 14]
    print("Index of 8:", search(numbers, 8))
    print("Index of 7:", search(numbers, 7))
    print("Recursive index of 14:", search_recursive(numbers, 14))
