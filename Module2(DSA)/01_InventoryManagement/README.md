# Exercise 1: Inventory Management System

## 1. Understand the Problem

**Why data structures and algorithms matter here:**
A warehouse can hold thousands to millions of distinct products. If products were
stored in a plain unindexed list, finding, updating, or deleting a single product
would require scanning every entry (O(n) per operation). At scale this is too slow
for real-time operations like checkout, restocking, or low-stock alerts. The right
data structure turns these into near-instant (O(1) or O(log n)) operations, which is
the difference between a system that scales to one warehouse and one that scales to
a nationwide chain.

**Suitable data structures:**
- **ArrayList** – good when you mostly iterate over all products in order (e.g.,
  generating a full inventory report) and don't look products up by ID often.
- **HashMap<productId, Product>** – ideal when products are looked up, updated, or
  deleted by a unique key (productId) frequently, since hashing gives average O(1)
  access instead of scanning.
- **TreeMap** – useful if you need products kept in sorted order (e.g., by ID or
  name) while still getting O(log n) lookups.

For this exercise we use a **HashMap**, since the dominant operations — add, update,
delete by productId — are exactly what hash maps are optimized for.

## 4. Analysis

| Operation | HashMap (avg case) | HashMap (worst case) | ArrayList (unsorted) equivalent |
|-----------|--------------------|-----------------------|----------------------------------|
| Add       | O(1)               | O(n) (hash collisions / resize) | O(1) amortized |
| Update    | O(1)               | O(n)                  | O(n) (must find index first) |
| Delete    | O(1)               | O(n)                  | O(n) (must find + shift elements) |
| Search    | O(1)               | O(n)                  | O(n) |

**Optimizations:**
- Choose a good initial capacity / load factor for the HashMap to minimize resizing
  and collisions.
- Use a well-distributed hash for productId (Integer's default hashCode is fine).
- If frequent range queries or sorted iteration are needed, maintain a secondary
  sorted index (e.g., a TreeMap or a sorted List of IDs) alongside the HashMap.
- Batch writes (e.g., bulk add during a stock delivery) to avoid repeated resizing.
