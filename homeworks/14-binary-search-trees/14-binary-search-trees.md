# [Homework 14: Binary Search Trees][hw14]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 30 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

> Consider the following definition IS_BST that defines binary
> search trees, and answer the questions below.

```java
/**
 * @mathdefinitions <pre>
 * IS_BST(
 *   tree: binary tree of T
 *  ): boolean satisfies
 *  [tree satisfies the binary search tree properties as described in the
 *   slides with the ordering reported by compareTo for T, including that
 *   it has no duplicate labels]
 * </pre>
 */
```

### Problem 1

> Write the body for the following static, generic method
> that searches a given binary search tree, t (of type
> BinaryTree<T>), for a given label, x (of type T), and
> returns true if it finds it, and false otherwise. Note
> that the BinaryTree must be restored, i.e., its outgoing
> value must be the same as its incoming value. Make sure
> your implementation takes advantage of the fact that the
> given tree is a binary search tree.


```java
/**
 * Returns whether {@code x} is in {@code t}.
 *
 * @param <T>
 *            type of {@code BinaryTree} labels
 * @param t
 *            the {@code BinaryTree} to be searched
 * @param x
 *            the label to be searched for
 * @return true if t contains x, false otherwise
 * @requires IS_BST(t)
 * @ensures isInTree = (x is in labels(t))
 */
public static <T extends Comparable<T>> boolean isInTree(BinaryTree<T> t, T x) {...}
```

> The isInTree method has a new and interesting property:
> the generic parameter T is required to extend Comparable<T>.
> The java.lang.Comparable<T> interface defines only one
> method, int compareTo(T), which allows us to compare two
> Ts to see if one is less than, equal to, or greater than
> the other, returning a negative, zero, or positive result,
> respectively. Make sure you use this method in your solution
> to allow you to search only one of the subtrees.

### Problem 2

> Using the binary search tree algorithms discussed in class
> and alphabetical order:

#### Problem 2A

> Draw the binary search tree that would result from inserting
> the following sequence of items into an initially empty binary
> search tree:
>
> Matt, Zeke, Pete, Lon, John, Mei, Larry, Bess, Merv, Adam, Kate

#### Problem 2B

> Draw the binary search tree resulting from removing Pete
> from the binary search tree in A.

#### Problem 2C

> Draw the binary search tree resulting from removing John
> from the binary search tree in B.

#### Problem 2D

> Draw the binary search tree resulting from removing Lon
> from the binary search tree in C.

#### Problem 2E

> Draw the binary search tree resulting from removing Matt
> from the binary search tree in D.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw14]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/binary-search-trees.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
