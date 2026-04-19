# [Homework 3: Sequence Smooth as a Function][hw3]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Jan 16 @ 4:10 PM EST

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

Consider one more time the following contract specification for the static method smooth.

```java
/**
 * Smooths a given {@code Sequence<Integer>}.
 *
 * @param s1
 *            the sequence to smooth
 * @param s2
 *            the resulting sequence
 *
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

Answer the following questions.

### Problem 1

> Redesign the method so that it is a function that returns the new
> (smoothed) sequence instead of replacing a parameter. You need to
> modify the method header and update the formal contract to reflect
> the changes.

```java
/**
 * Return the final smoothed sequence of the given {@code Sequence<Integer>}.
 *
 * @param s1
 *            the sequence to smooth
 * @return    the final smoothed sequence
 *
 * @requires |s1| >= 1
 * @ensures <pre>
 * |smooth(s1)| = |s1| - 1  and
 *  for all i, j: integer, a, b: string of integer
 *      where (s1 = a * <i> * <j> * b)
 *    (there exists c, d: string of integer
 *       (|c| = |a|  and
 *        smooth(s1) = c * <(i+j)/2> * d))
 * </pre>
 */
public static Sequence<Integer> smooth(Sequence<Integer> s1) {...}
```

### Problem 2

> Provide two distinct implementations of the newly designed smooth
> method, one recursive and one iterative (i.e., not using recursion).
> While you may use method entry, do not use any other method that is
> introduced in the enhanced interface Sequence. Among the methods still
> permitted for your use are all those inherited by or introduced in
> SequenceKernel, including add, remove, and length.

### Recursive

```java
public static Sequence<Integer> smoothRecur(Sequence<Integer> s1) {
    Sequence<Integer> result = s1.newInstance();
    if (s1.length() > 1){
        int first = s1.remove(0);
        int second = s1.entry(0);
        result = smoothRecur(s1);
        result.add(0, (first + second) / 2);
        s1.add(0, first);
    }
    return result;
}
```

### Iterative

```java
public static Sequence<Integer> smoothIter(Sequence<Integer> s1) {
    Sequence<Integer> result = s1.newInstance();
    for(int i = 0; i < s1.length() - 1; i++){
        int avg = (s1.entry(i) + s1.entry(i+1)) / 2;
        result.add(result.length(), avg);
    }
    return result;
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

[hw3]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/smooth-function.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
