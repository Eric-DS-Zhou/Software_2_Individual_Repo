# [Homework 17: Heapsort][hw17]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 60 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

The following problems will give you practice with heaps and heapsort.

### Problem 1

> Given the following heap, where the items are integers and the
> heap is ordered according to the <= relation:
>
>          2
>        /   \
>       5     6
>      / \   /
>     8   5 7
>
> Draw the five heaps resulting from removing each of the first five
> items in the ordering using the algorithm discussed in class (see slides
> 26-32 in Heaps and Heapsort).

### Problem 2

> Write the body of the following static method, which returns true if
> and only if the given BinaryTree<Integer>, t, satisfies the heap ordering
> property according to the <= relation. (Note that this says nothing about
> the shape of the tree, i.e., it should work whether or not t is a complete
> binary tree, and should not check whether it is.)

```java
/**
 * Checks if the given {@code BinaryTree<Integer>} satisfies the heap
 * ordering property according to the <= relation.
 *
 * @param t
 *            the binary tree
 * @return true if the given tree satisfies the heap ordering property;
 *         false otherwise
 * @ensures <pre>
 * satisfiesHeapOrdering = [t satisfies the heap ordering property]
 * </pre>
 */
private static boolean satisfiesHeapOrdering(BinaryTree<Integer> t) {...}
```

### Problem 3

> Draw and complete the commutativity diagram on slides 18-23 in More About Heaps.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw17]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/heapsort.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
