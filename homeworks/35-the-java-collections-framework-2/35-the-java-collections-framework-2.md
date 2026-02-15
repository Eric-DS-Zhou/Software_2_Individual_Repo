# [Homework 35: The Java Collections Framework 2][hw35]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 90 minutes
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

> Write the body of the following static method, which, given a
> components.map.Map<String, Integer> representing employee names and
> corresponding salaries, raises (by the given percentage) the salary
> of every employee whose name starts with the given initial. Note that
> only simple integer arithmetic is needed to satisfy the postcondition.

```java
/**
 * Raises the salary of all the employees in {@code map} whose name starts
 * with the given {@code initial} by the given {@code raisePercent}.
 *
 * @param map
 *            the name to salary map
 * @param initial
 *            the initial of names of employees to be given a raise
 * @param raisePercent
 *            the raise to be given as a percentage of the current salary
 * @updates map
 * @requires [the salaries in map are positive]  and  raisePercent > 0
 * @ensures <pre>
 * DOMAIN(map) = DOMAIN(#map)  and
 * [the salaries of the employees in map whose names start with the given
 *  initial have been increased by raisePercent percent (and truncated to
 *  the nearest integer); all other employees have the same salary]
 * </pre>
 */
private static void giveRaise(components.map.Map<String, Integer> map,
        char initial, int raisePercent) {...}
```

### Problem 2

> Write the body of the following static method. It has the exact
> same contract as the previous one, but uses only standard Java
> components, including java.util.Map<String, Integer>.

```java
/**
 * Raises the salary of all the employees in {@code map} whose name starts
 * with the given {@code initial} by the given {@code raisePercent}.
 *
 * @param map
 *            the name to salary map
 * @param initial
 *            the initial of names of employees to be given a raise
 * @param raisePercent
 *            the raise to be given as a percentage of the current salary
 * @updates map
 * @requires <pre>
 * [the salaries in map are positive]  and  raisePercent > 0  and
 * [the dynamic types of map and of all objects reachable from map
 *  (including any objects returned by operations (such as entrySet() and,
 *  from there, iterator()), and so on, recursively) support all
 *  optional operations]
 * </pre>
 * @ensures <pre>
 * DOMAIN(map) = DOMAIN(#map)  and
 * [the salaries of the employees in map whose names start with the given
 *  initial have been increased by raisePercent percent (and truncated to
 *  the nearest integer); all other employees have the same salary]
 * </pre>
 */
private static void giveRaise(java.util.Map<String, Integer> map,
        char initial, int raisePercent) {...}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw35]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/java-collections-framework2.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
