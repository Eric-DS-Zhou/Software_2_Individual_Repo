# [Homework 5: Standard Java Lists][hw5]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Jan 21 @ 4:10 PM EST

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
>
> - the top-level description of the List component at the start of the page, and
> - the detailed descriptions of the methods add(E e), remove(int index), get(int index), and size().

### Problem 3

> Complete the following tracing table:

| Statement                                              | Variable Values       |
| ------------------------------------------------------ | --------------------- |
| `List<Integer> list = new SomeListImplementation<>();` |                       |
|                                                        | list = <>            |
| `list.add(7);`                                         |                       |
|                                                        | list = <7>            |
| `list.add(-12);`                                       |                       |
|                                                        | list = <7, -12>            |
| `list.add(3);`                                         |                       |
|                                                        | list = <7, -12, 3>            |
| `int x = list.size();`                                 |                       |
|                                                        | list = <7, -12, 3> <br>x = 3 |
| `x = list.get(1);`                                     |                       |
|                                                        | list = <7, -12, 3> <br>x = -12 |
| `x = list.remove(0);`                                  |                       |
|                                                        | list = <-12, 3> <br>x = 7 |
| `x = list.remove(1);`                                  |                       |
|                                                        | list = <-12> <br>x = 3 |
| `x = list.size();`                                     |                       |
|                                                        | list = <-12> <br>x = 1 |

### Problem 4

> You may have observed that the add(E e) and remove(int index)
> methods are marked as optional operations. Briefly discuss the
> benefits vs. pitfalls of this design decision.

The benefit of marking them as optional operations is that it increases flexibiliy, so that the developer can decide whether operate them or not.

The pitfall of this decision is that the clients should check the documentation before using them. They cannot assume that these operations are always supported. It may reduce code portability

### Problem 5

> Consider this quote from the java.util.List description:
>
> Some list implementations have restrictions on the elements that
> they may contain. For example, some implementations prohibit null
> elements, and some have restrictions on the types of their elements.
>
> Briefly discuss the benefits vs. pitfalls of this design decision.

The benefit is that it can keep the code safe. It can prevent invalid elements from being added. With the restriction, the methods could be operated correctly.

The pitfall is that the clients should check the documentation before operating. For example, when we use null element or some special value, it may cause some mistakes or throw some exceptions.

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
