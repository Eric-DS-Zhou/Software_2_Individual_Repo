# [Homework 5: Standard Java Lists][hw5]

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

Below you'll find the problems for today's assignment.

### Problem 1

> Look up the online documentation for java.util.List, a standard Java
> container component (in the style of our Queue, Stack, Sequence, etc.).

### Problem 2

> Carefully read the following sections of the documentation:
> - the top-level description of the List component at the start of the page, and
> - the detailed descriptions of the methods add(E e), remove(int index), get(int index), and size().

### Problem 3

> Complete the following tracing table:

<!-- TODO: replace '?' marks with values -->

| Statement                                              | Variable Values       |
| ------------------------------------------------------ | --------------------- |
| `List<Integer> list = new SomeListImplementation<>();` |                       |
|                                                        | list = `?`            |
| `list.add(7);`                                         |                       |
|                                                        | list = `?`            |
| `list.add(-12);`                                       |                       |
|                                                        | list = `?`            |
| `list.add(3);`                                         |                       |
|                                                        | list = `?`            |
| `int x = list.size();`                                 |                       |
|                                                        | list = `?`<br>x = `?` |
| `x = list.get(1);`                                     |                       |
|                                                        | list = `?`<br>x = `?` |
| `x = list.remove(0);`                                  |                       |
|                                                        | list = `?`<br>x = `?` |
| `x = list.remove(1);`                                  |                       |
|                                                        | list = `?`<br>x = `?` |
| `x = list.size();`                                     |                       |
|                                                        | list = `?`<br>x = `?` |

### Problem 4

> You may have observed that the add(E e) and remove(int index)
> methods are marked as optional operations. Briefly discuss the
> benefits vs. pitfalls of this design decision.

<!-- TODO: discuss -->

### Problem 5

> Consider this quote from the java.util.List description:
>
>   Some list implementations have restrictions on the elements that
>   they may contain. For example, some implementations prohibit null
>   elements, and some have restrictions on the types of their elements.
>
> Briefly discuss the benefits vs. pitfalls of this design decision.

<!-- TODO: discuss -->

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw5]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/java-util-list.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
