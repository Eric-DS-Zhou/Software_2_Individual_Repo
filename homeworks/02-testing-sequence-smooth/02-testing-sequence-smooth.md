# [Homework 2: Testing Sequence Smooth][hw2]

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

Below you will find the list of problems for this homework assignment.

### Problem 1

> Develop a complete test plan for the following static method smooth.

```java
/**
 * Smooths a given {@code Sequence<Integer>}.
 *
 * @param s1
 *            the sequence to smooth
 * @param s2
 *            the resulting sequence
 * @replaces s2
 * @requires |s1| >= 1
 * @ensures <pre>
 * |s2| = |s1| - 1  and
 *  for all i, j: integer, a, b: string of integer
 *      where (s1 = a * <i> * <j> * b)
 *    (there exists c, d: string of integer
 *       (|c| = |a|  and
 *        s2 = c * <(i+j)/2> * d))
 * </pre>
 */
public static void smooth(Sequence<Integer> s1, Sequence<Integer> s2) {...}
```

<!-- TODO: consider listing off possible test cases -->

### Problem 2

> Code your test cases in the JUnit test fixture accessible from
> the link below. Make sure you have access to an electronic version
> of the completed file in closed lab. Turn in a printed copy as your
> homework.

```java
// TODO: Put test cases here.
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw2]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/smooth-test/smooth-test.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
