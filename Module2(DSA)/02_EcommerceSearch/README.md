# Exercise 2: E-commerce Platform Search Function

## 1. Understand Asymptotic Notation

**Big O notation** describes how an algorithm's running time (or space) grows as
the input size `n` grows, ignoring constant factors and lower-order terms. It lets
us compare algorithms independent of hardware or implementation details, focusing on
how they *scale*.

**Best, average, and worst case for search:**

| Algorithm      | Best Case | Average Case | Worst Case |
|----------------|-----------|---------------|------------|
| Linear Search  | O(1) — item is first | O(n) | O(n) — item is last or absent |
| Binary Search  | O(1) — item is the middle element | O(log n) | O(log n) |

- Linear search's best case happens when the target is found immediately.
- Binary search's worst case is still only O(log n) because it halves the search
  space every comparison, but it **requires the data to be sorted** first.

## 4. Analysis

- Linear search: O(n) time, works on unsorted data, no preprocessing cost.
- Binary search: O(log n) time, but requires sorted data — sorting itself costs
  O(n log n) if the data isn't already sorted.
- **Which is more suitable for an e-commerce platform?** Binary search is far
  better for large, mostly-static catalogs (e.g., search by productId) because the
  one-time cost of keeping the catalog sorted (or indexed) is paid back many times
  over by every subsequent O(log n) search. For catalogs that change constantly or
  are searched by free-text/category (not a strict sort key), a hash-based index or
  full-text search engine is typically used instead of either of these — but for
  classic search-by-key, binary search wins at scale.
