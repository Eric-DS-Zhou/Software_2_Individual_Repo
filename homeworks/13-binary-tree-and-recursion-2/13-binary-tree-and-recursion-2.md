# [Homework 13: Binary Tree and Recursion 2][hw13]

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

This homework is an extension of the previous lab, and you
will have to option to include it in your lab through the
additional activities.

### Problem 1

> Write a recursive body for the following static, generic
> method that returns a String representation of a given
> BinaryTree<T>. You cannot use the BinaryTree toString method
> in your solution. Note that the BinaryTree must be restored,
> i.e., its outgoing value must be the same as its incoming value.

```java
/**
 * Returns the {@code String} prefix representation of the given
 * {@code BinaryTree<T>}.
 *
 * @param <T>
 *            the type of the {@code BinaryTree} node labels
 * @param t
 *            the {@code BinaryTree} to convert to a {@code String}
 * @return the prefix representation of {@code t}
 * @ensures treeToString = [the String prefix representation of t]
 */
public static <T> String treeToString(BinaryTree<T> t) {
    // TODO: fill out
}
```

> The prefix representation of the empty tree is "()", and the
> prefix representation of a non-empty BinaryTree<T> is the string
> concatenation of the root, followed by '(', then by the prefix
> representation of the left subtree, the prefix representation
> of the right subtree, and finally ')'. Here are five examples
> of prefix representations of some BinaryTree<Character>s. See
> if you can figure out and draw the binary trees being described.

- ()
- a(()())
- a(b(()())c(()()))
- a(()b(()()))
- a(()b(c(()())()))

### Problem 2

> Write a recursive body for the following static method that
> copies and returns a given BinaryTree<Integer>. Note that the
> given BinaryTree must be restored, i.e., its outgoing value must
> be the same as its incoming value.

```java
/**
 * Returns a copy of the the given {@code BinaryTree}.
 *
 * @param t
 *            the {@code BinaryTree} to copy
 * @return a copy of the given {@code BinaryTree}
 * @ensures copy = t
 */
public static BinaryTree<Integer> copy(BinaryTree<Integer> t) {
    // TODO: fill out
}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw13]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/binary-tree2.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
