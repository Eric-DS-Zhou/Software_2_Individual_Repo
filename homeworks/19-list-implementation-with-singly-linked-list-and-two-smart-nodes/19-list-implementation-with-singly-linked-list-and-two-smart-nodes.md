# [Homework 19: List Implementation with Singly-Linked List and Two Smart Nodes][hw19]

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

### Problem 1

> Review the ListKernel and List interfaces and make sure you are
> comfortable with the List mathematical model and the contracts
> of all the kernel methods (and some of the secondary ones). To
> aid in this task, we provide the following exercise. Complete
> (and print with your homework) the following tracing table.
> Recalling how much we care that you use correct punctuation when
> you write objects' values, we urge you to practice doing so. For
> example, after the 7th statement the value of list is (<2, -1>,
> <0, 1>). Note the use of rounded parentheses, commas, and angle
> brackets.

| Statement                              | Variable Values       |
| -------------------------------------- | --------------------- |
| `List<Integer> list = new List1L<>();` |                       |
|                                        | list = `?`            |
| `list.addRightFront(1);`               |                       |
|                                        | list = `?`            |
| `list.addRightFront(0);`               |                       |
|                                        | list = `?`            |
| `list.addRightFront(2);`               |                       |
|                                        | list = `?`            |
| `list.advance();`                      |                       |
|                                        | list = `?`            |
| `list.addRightFront(-1);`              |                       |
|                                        | list = `?`            |
| `list.advance();`                      |                       |
|                                        | list = `?`            |
| `list.moveToFinish();`                 |                       |
|                                        | list = `?`            |
| `list.retreat();`                      |                       |
|                                        | list = `?`            |
| `int i = list.rightFront();`           |                       |
|                                        | list = `?`<br>i = `?` |
| `list.moveToStart();`                  |                       |
|                                        | list = `?`<br>i = `?` |

### Problem 2

> Implement the List<T> secondary instance method retreat declared
> below. This must be a layered implementation using only the
> ListKernel methods.

```java
/**
 * Retreats the position in {@code this} by one.
 *
 * @updates this
 * @requires this.left /= <>
 * @ensures <pre>
 * this.left * this.right = #this.left * #this.right  and
 * |this.left| = |#this.left| - 1
 * </pre>
 */
public void retreat() {...}
```

### Problem 3

> Review the Linked Data Structures II slides. In particular, make sure
> you completely understand the pictures of the representation of List
> implemented as a singly-linked list of nodes with one "smart" node at
> the start (slides 14-16) and the modified representation with two "smart"
> nodes, one at the start and another at the end (slides 19-20).

### Problem 4

> Review the List2 implementation of List kernel represented as a
> singly-linked list of Nodes with one smart node. Pay particular
> attention to the representation fields, the convention, and the
> correspondence. In the lab, you will be asked to modify this
> implementation so that it uses an additional smart node at the end
> of the singly-linked list.

### Problem 5

> Study the Implementing an Iterator slides and review the iterator
> implementation, List2Iterator, a nested class in List2. If you have
> any questions, make sure to ask them in class during the lab.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw19]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/list-with-two-smart-nodes/list-with-two-smart-nodes.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
