# Floating-Point Pitfalls

A short note on why `0.1 + 0.2` is not `0.3`, because it comes up in every data and quant interview.

## The one sentence

IEEE 754 doubles store an approximation, not the number — `0.1` has no exact binary representation, so arithmetic on it rounds.

```python
>>> 0.1 + 0.2
0.30000000000000004
>>> 0.1 + 0.2 == 0.3
False
```

## Three traps that actually bite

**1. Never compare floats with `==`.** Accumulate error makes "equal" comparisons fail. Use a tolerance (or `math.isclose` in Python):

```python
import math
math.isclose(0.1 + 0.2, 0.3)          # True
abs((0.1 + 0.2) - 0.3) < 1e-9          # True
```

**2. Subtraction of nearly-equal numbers destroys precision.** `1e16 + 1 - 1e16` rounds to `0`, not `1`, because the `1` is below the representable spacing at that magnitude:

```python
>>> 1e16 + 1 - 1e16
0.0
```

This is catastrophic cancellation, and it's why stable formulas reorder operations.

**3. Money is not a float.** Bank balances, prices, and quantities in Rands must be stored as integers (cents) or `Decimal`, never `double`. The banking examples in this repo print with two decimals, which is presentation; the storage should be exact.

```python
from decimal import Decimal
Decimal("0.10") + Decimal("0.20")     # Decimal('0.30') — exact
```

## How to talk about it in an interview

"Floating point is an approximation with a fixed number of bits. You get about 15–17 significant digits, errors accumulate, and comparisons need a tolerance. For money you use exact types; for scientific numbers you use floats and accept the rounding." That's the whole answer.
