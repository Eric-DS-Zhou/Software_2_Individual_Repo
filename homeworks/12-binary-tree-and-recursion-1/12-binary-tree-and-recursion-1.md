# [Homework 12: Binary Tree and Recursion 1][hw12]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 45 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> Write a recursive body for the following static, generic method
> that computes and returns the size of a given BinaryTree<T>.
> You can use any of the BinaryTree methods except for the iterator
> and the size kernel method. Note that the BinaryTree must be
> restored, i.e., its outgoing value must be the same as its incoming
> value.

```java
/**
 * Returns the size of the given {@code BinaryTree<T>}.
 *
 * @param <T>
 *            the type of the {@code BinaryTree} node labels
 * @param t
 *            the {@code BinaryTree} whose size to return
 * @return the size of the given {@code BinaryTree}
 * @ensures size = |t|
 */
public static <T> int size(BinaryTree<T> t) {...}
```

### Problem 2

> Provide a second implementation of the size method above but
> this time make it an iterative (non-recursive) solution. You
> cannot use the size kernel method in your solution.

```java
/**
 * Returns the size of the given {@code BinaryTree<T>}.
 *
 * @param <T>
 *            the type of the {@code BinaryTree} node labels
 * @param t
 *            the {@code BinaryTree} whose size to return
 * @return the size of the given {@code BinaryTree}
 * @ensures size = |t|
 */
public static <T> int size(BinaryTree<T> t) {...}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw12]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/binary-tree1.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
