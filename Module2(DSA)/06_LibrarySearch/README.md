# Exercise 6: Library Management System

## 1. Understand Search Algorithms

- **Linear Search**: Checks each book one by one, comparing titles, until a match
  is found or the list is exhausted. Works on data in any order. O(n).
- **Binary Search**: Repeatedly halves the search space by comparing the target
  title against the middle element. Requires the books to already be sorted by
  title. O(log n).

## 4. Analysis

| Algorithm     | Requires Sorted Data? | Time Complexity |
|---------------|------------------------|------------------|
| Linear Search | No                     | O(n)             |
| Binary Search | Yes                    | O(log n)         |

**When to use each:**
- **Linear search** is preferable when the catalog is small, changes very
  frequently (new books added/removed constantly, making it costly to keep
  re-sorting), or is searched by a field that isn't sorted (like genre or author
  in an unsorted list).
- **Binary search** is preferable for large, relatively static catalogs that are
  already maintained in sorted order (e.g., titles kept alphabetically sorted in
  the database) — the O(log n) lookup pays off heavily as the library's collection
  grows into the thousands or millions of titles.
