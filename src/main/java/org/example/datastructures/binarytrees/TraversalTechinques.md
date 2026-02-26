# Binary Tree Traversal Techniques - Detailed Comparison

## Overview
The three depth-first search (DFS) traversal techniques differ in the **order** in which they visit nodes: root, left subtree, and right subtree.

---

## 1. **Pre-order Traversal**
**Order: Root → Left → Right**

### How it works:
1. Visit (process) the root node first
2. Recursively traverse the left subtree
3. Recursively traverse the right subtree

### Example Tree:
```
       1
      / \
     2   3
    / \
   4   5
```
**Pre-order result: 1 → 2 → 4 → 5 → 3**

### Code Pattern:
```java
void preOrder(Node node) {
    if (node == null) return;
    System.out.println(node.data);  // Visit root FIRST
    preOrder(node.leftNode);
    preOrder(node.rightNode);
}
```

### When to use:
- **Creating a copy of the tree** - You need to process parent before children
- **Serializing a tree** - Save the tree structure in a way that allows reconstruction
- **Expression trees** - Evaluate prefix expressions
- **Building a tree from its structure**

---

## 2. **In-order Traversal**
**Order: Left → Root → Right**

### How it works:
1. Recursively traverse the left subtree
2. Visit (process) the root node
3. Recursively traverse the right subtree

### Example Tree:
```
       1
      / \
     2   3
    / \
   4   5
```
**In-order result: 4 → 2 → 5 → 1 → 3**

### Code Pattern:
```java
void inOrder(Node node) {
    if (node == null) return;
    inOrder(node.leftNode);
    System.out.println(node.data);  // Visit root in MIDDLE
    inOrder(node.rightNode);
}
```

### When to use:
- **Binary Search Trees (BSTs)** - Returns elements in **sorted order** (most important!)
- **Finding the k-th smallest/largest element** in a BST
- **Validating if a tree is a valid BST**
- **Expression trees** - Evaluate infix expressions
- **Printing tree elements in sorted order**

---

## 3. **Post-order Traversal**
**Order: Left → Right → Root**

### How it works:
1. Recursively traverse the left subtree
2. Recursively traverse the right subtree
3. Visit (process) the root node

### Example Tree:
```
       1
      / \
     2   3
    / \
   4   5
```
**Post-order result: 4 → 5 → 2 → 3 → 1**

### Code Pattern:
```java
void postOrder(Node node) {
    if (node == null) return;
    postOrder(node.leftNode);
    postOrder(node.rightNode);
    System.out.println(node.data);  // Visit root LAST
}
```

### When to use:
- **Deleting a tree** - Children are deleted before parent (memory cleanup)
- **Calculating tree height** - Need to know children's heights first
- **Calculating tree size** - Need to count all nodes in subtrees first
- **Post-fix expression evaluation**
- **Folder deletion in file systems** - Delete files before deleting folders
- **Postorder dependency resolution** - Dependencies before dependents

---

## Quick Comparison Table

| Traversal | Order | Key Use Case |
|-----------|-------|--------------|
| **Pre-order** | Root → Left → Right | Copy tree, Serialize/Deserialize, Prefix expressions |
| **In-order** | Left → Root → Right | **BST sorted order**, Validate BST, Infix expressions |
| **Post-order** | Left → Right → Root | Delete tree, Calculate height/size, Postfix expressions |

---

## Visual Summary

```
Tree:         1
             / \
            2   3
           / \
          4   5

Pre-order:  [1] [2] [4] [5] [3]   ← Process parent first
In-order:   [4] [2] [5] [1] [3]   ← Left-Root-Right (sorted in BST)
Post-order: [4] [5] [2] [3] [1]   ← Process parent last
```

---

## Real-World Example: Why In-order for BSTs?

If you have a BST with values: 5, 3, 7, 2, 4, 6, 8

**In-order traversal gives:** 2 → 3 → 4 → 5 → 6 → 7 → 8 (sorted!)

This is because the BST property ensures:
- All values in left subtree < root
- All values in right subtree > root
- In-order naturally follows the sorted order

This makes in-order the **most useful traversal for BSTs**.
