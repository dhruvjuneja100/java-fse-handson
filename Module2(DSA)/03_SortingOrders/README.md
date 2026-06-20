# Exercise 3: Sorting Customer Orders

## 1. Understand Sorting Algorithms

- **Bubble Sort**: Repeatedly steps through the list, comparing adjacent elements
  and swapping them if they're in the wrong order. Simple but slow — O(n²) in the
  average and worst case.
- **Insertion Sort**: Builds the sorted list one element at a time by inserting
  each new element into its correct position among the already-sorted elements.
  O(n²) worst case, but efficient (O(n)) for nearly-sorted data.
- **Quick Sort**: A divide-and-conquer algorithm that picks a "pivot," partitions
  the array into elements less than and greater than the pivot, and recursively
  sorts each partition. O(n log n) average case, O(n²) worst case (rare, with poor
  pivot choices), and very fast in practice due to cache-friendly in-place operation.
- **Merge Sort**: Also divide-and-conquer — splits the array in half, recursively
  sorts each half, then merges the sorted halves. Guaranteed O(n log n) in all
  cases, stable, but requires O(n) extra space.

## 4. Analysis

| Algorithm  | Best Case  | Average Case | Worst Case | Space   | Stable? |
|------------|------------|---------------|------------|---------|---------|
| Bubble Sort| O(n)       | O(n²)         | O(n²)      | O(1)    | Yes     |
| Quick Sort | O(n log n) | O(n log n)    | O(n²)      | O(log n)| No (typically) |

**Why Quick Sort is generally preferred over Bubble Sort:**
- Quick Sort's average-case O(n log n) vastly outperforms Bubble Sort's O(n²) as
  order volume grows — sorting 1 million orders with Bubble Sort would take roughly
  1,000,000² ≈ 10¹² comparisons in the worst case, versus roughly 1,000,000 × 20 ≈
  2×10⁷ for Quick Sort.
- Quick Sort sorts in-place with low memory overhead (O(log n) for the recursion
  stack), making it practical for large datasets.
- Bubble Sort is mainly useful for teaching purposes or tiny/near-sorted datasets;
  it's rarely used in production systems.
