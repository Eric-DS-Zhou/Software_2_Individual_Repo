# [Homework 1: Reading Formal Contract Specifications][hw1]

- **Name**: Eric Zhou
- **Dot Number**: zhou. 4898
- **Due Date**: Jan 14 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 20 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

Below you will find the list of problems for this homework assignment.

### Problem 1

> (Nothing to turn in for this question) Add a recent, clear photo
of yourself to both your Zoom profile and to your Carmen profile.

### Problem 2

> Consider the following contract specification for the static method
> smooth.

```java
/**
 * No informal description here for obvious reasons...
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

> Answer the following questions.

#### Problem 2A

> Suppose seq1 = < 2, 4, 6 >, seq2 = < -5, 12 >. What are the values
> of seq1 and seq2 after the call smooth(seq1, seq2)?

|seq1| = 3

|seq2| = |seq1| - 1 = 2

1. a = < >, i = 2, j = 4, b = < 6 >

   c = < >, (i+j)/2 = 3, d = < >, s2 = < 3, ? >

2. a = < 2 >, i = 4, j = 6, b = < >

   c = < 3 >, (i+j)/2 = 5, d = < >, s2 = < 3, 5 >

Therefore, seq1 = < 2, 4, 6 >, seq2 = < 3, 5 >.

#### Problem 2B

> Suppose seq1 = < 7 >, seq2 = < 13, 17, 11 >. What are the values of
> seq1 and seq2 after the call smooth(seq1, seq2)?

|seq1| = 1

|seq2| = |seq1| - 1 = 0

Therefore, seq1 = < 7 >, seq2 = < >.

#### Problem 2C

> Suppose seq1 = < >, seq2 = < >. What are the values of seq1 and seq2
> after the call smooth(seq1, seq2)?

|seq1| = 0

From the @requires, we can know that |seq1| should >= 1. It cannot fulfill the prerequisite of the method. Therefore, we cannot know the output, it can be anything.

#### Problem 2D

> Explain informally, but precisely, what the specs of smooth say about
> the method's behavior. In other words, explain in English what smooth
> is supposed to do.

The method assumes that s1 is non-empty and leaves it unchanged. In addition, it replaces s2 with a sequnce of length |s1| - 1, where each element at k in s2 will be changed to the average of the elemnts at positions k and k+1 from s1.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw1]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/smooth-contract.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
