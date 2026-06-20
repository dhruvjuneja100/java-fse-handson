# Exercise 7: Financial Forecasting

## 1. Understand Recursive Algorithms

**Recursion** is when a method solves a problem by calling itself on a smaller
version of the same problem, until it reaches a "base case" that can be answered
directly without further recursion. It's useful for problems that are naturally
self-similar — like compound growth, where next year's value depends on this
year's value in exactly the same way every year.

For financial forecasting, predicting a future value after `n` years of compound
growth fits recursion well:

```
futureValue(n) = futureValue(n - 1) * (1 + growthRate)
futureValue(0) = presentValue   <- base case
```

## 4. Analysis

**Time complexity:** The naive recursive solution makes exactly one recursive call
per year, so it runs in **O(n)** time and uses **O(n)** stack space (one stack
frame per year of recursion).

**Optimizing the recursive solution:**
- **Avoid recomputation / memoize:** Not strictly necessary here since each call to
  `futureValue(n)` only depends on `futureValue(n-1)` (no overlapping
  sub-problems like Fibonacci has), so there's nothing to memoize in the single-rate
  case — but if the algorithm were extended to explore *multiple* growth-rate
  scenarios that share sub-paths, memoization (caching results in a HashMap keyed
  by year/rate) would avoid redundant recursive calls.
- **Convert to an iterative loop:** Since each step only depends on the previous
  result, an iterative loop computes the same answer in O(n) time but O(1) space,
  avoiding the recursion call-stack overhead entirely — generally preferred for
  large `n` to avoid stack overflow.
- **Use the closed-form formula:** Compound growth has a direct formula,
  `futureValue = presentValue * (1 + rate)^n`, computable in O(log n) time using
  fast exponentiation (or O(1) with `Math.pow`), which is far more efficient than
  either the recursive or iterative step-by-step approach when only the final value
  (not the year-by-year trajectory) is needed.
