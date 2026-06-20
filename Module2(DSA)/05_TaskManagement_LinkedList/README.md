# Exercise 5: Task Management System

## 1. Understand Linked Lists

- **Singly Linked List (SLL):** Each node holds data plus a single pointer to the
  next node. Traversal is one-directional (head → tail). Simple and memory-light
  per node, but you can't move backward without restarting from the head.
- **Doubly Linked List (DLL):** Each node holds data plus pointers to both the
  next AND previous nodes. This allows traversal in both directions and O(1)
  removal of a node once you have a reference to it (no need to find its
  predecessor), at the cost of extra memory per node for the second pointer.

We implement a **Singly Linked List** here since tasks are mainly added, removed,
and traversed front-to-back (e.g., processing a task queue).

## 4. Analysis

| Operation | Time Complexity | Why |
|-----------|------------------|-----|
| Add at head | O(1) | Just create a new node and point it at the old head |
| Add at tail | O(n) (O(1) if a tail pointer is maintained) | Must traverse to the end unless tail is tracked |
| Search | O(n) | Must traverse from head until found |
| Traverse | O(n) | Must visit every node |
| Delete | O(n) | Must traverse to find the node and its predecessor |

**Advantages of linked lists over arrays for dynamic data:**
- No fixed capacity — grows and shrinks one node at a time without needing to
  resize/copy an entire backing array.
- O(1) insertion/removal at the head (and at the tail, if a tail pointer is kept),
  versus O(n) shifting required for arrays.
- More efficient when the number of tasks fluctuates unpredictably and frequently,
  since there's no wasted pre-allocated space and no costly resize operations.
- Trade-off: linked lists lose O(1) random access by index (which arrays have) and
  use more memory per element due to storing pointers.
