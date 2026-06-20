# Exercise 4: Employee Management System

## 1. Understand Array Representation

Arrays store elements in a **contiguous block of memory**, with each element
occupying a fixed amount of space. Because the memory is contiguous, the address
of any element can be calculated directly as:

```
address = base_address + (index * element_size)
```

This is why array indexing is O(1) — the system can jump straight to any index
without scanning.

**Advantages:**
- O(1) random access by index.
- Cache-friendly: contiguous memory means sequential access patterns are very fast.
- Simple and memory-efficient (no extra pointer/overhead per element, unlike linked
  structures).

**Disadvantages:**
- Fixed size (in raw arrays) — must know capacity in advance or resize manually.
- Insertion/deletion in the middle requires shifting elements: O(n).

## 4. Analysis

| Operation | Time Complexity | Why |
|-----------|------------------|-----|
| Add (at end, space available) | O(1) | Just place at next free index |
| Add (array full) | O(n) | Must resize/copy to a larger array |
| Search (by ID, unsorted) | O(n) | Must scan until found |
| Traverse (print all) | O(n) | Must visit every element once |
| Delete | O(n) | Must find element, then shift all subsequent elements left |

**Limitations of arrays / when to use them:**
- Best when the number of employees is relatively stable and lookups are mostly by
  position/index, or when you need fast iteration and minimal memory overhead.
- Poor choice when employees are added/removed frequently in large volumes, since
  shifting elements on delete/insert is O(n). In that case, a linked list, ArrayList
  with amortized growth, or a HashMap (for ID-based lookup) is usually a better fit.
