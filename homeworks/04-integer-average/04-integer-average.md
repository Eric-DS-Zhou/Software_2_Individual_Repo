# [Homework 4: Integer Average][hw4]

- **Name**: Eric Zhou
- **Dot Number**: zhou. 4898
- **Due Date**: Jan 20 @ 4:10 PM EST

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

Consider the following contract specification for the static method average.
Please note that, both in the specification and in the Java programming
language, the integer-division (' / ') operator's result is obtained by
truncating toward zero. Hence, (-3 / 2) = -1 and (9 / 2) = 4 . It is like
"rounding", except that the quotient given as the result is not necessarily
the closest integer to the correct rational quotient: it is the first-encountered
integer closer to zero than the correct rational quotient.

```java
/**
 * Returns the integer average of two given {@code int}s.
 *
 * @param j
 *            the first of two integers to average
 * @param k
 *            the second of two integers to average
 * @return the integer average of j and k
 * @ensures average = (j+k)/2
 */
public static int average(int j, int k) {...}
```

Answer the following questions.

### Problem 1

> Provide an argument justifying the following claim: The average (as defined here)
> of two Java ints i and j is representable as an int, regardless of the lower and
> upper bounds on the value of an int.

In my opinion, the claim is correct. We can know that for any two int value j and k, the average of (j + k)/2 should always be between the minimum and the maximum value of int. Although if we directly compute j + k may overflow, we can rewrite it as k/2 + j/2 + (j%2 +k%2)/2. Therefore, i and j can always be representable as int, regardless of the lower and upper bounds on the value of an int.

### Problem 2

> Provide an implementation of the average method with int as the only type you use
> (except, perhaps, for boolean). Note: return (j+k)/2; does not implement the contract
> specification. Some of the test cases shown below will reveal defects in this obvious
> implementation. Your challenge is to figure out a way or ways to work around the fact
> that, if a sum is non-representable as an int (has overflowed), then Java arranges
> that the value provided at run-time is wrong. In other words, each arithmetic operation
> has a precondition that requires that the result is representable in its type. Your
> challenge includes making sure that this precondition is always satisfied. As you find
> ways to do so, you'll also need to work out difficulties involved with the truncating
> going in the wrong direction, as compared with the truncation direction established in
> the contract specification. (By the way, because it is mathematics, the expressions in
> contract specifications always mean the right answer; in contract specifications, there
> is no overflow.) Each of the following is a valid test case for the average method.

|     | j                 | k                     | return                |
| --- | ----------------- | --------------------- | --------------------- |
| 1   | Integer.MAX_VALUE | Integer.MAX_VALUE - 1 | Integer.MAX_VALUE - 1 |
| 2   | Integer.MIN_VALUE | Integer.MIN_VALUE + 1 | Integer.MIN_VALUE + 1 |
| 3   | Integer.MIN_VALUE | Integer.MIN_VALUE     | Integer.MIN_VALUE     |
| 4   | Integer.MAX_VALUE | Integer.MAX_VALUE     | Integer.MAX_VALUE     |
| 5   | 5                 | 8                     | 6                     |
| 6   | -5                | -8                    | -6                    |
| 7   | 11                | -4                    | 3                     |
| 8   | -3                | 2                     | 0                     |
| 9   | 3                 | 5                     | 4                     |
| 10  | -3                | -5                    | -4                    |

```java
/**
 * Returns the integer average of two given {@code int}s.
 *
 * @param j
 *            the first of two integers to average
 * @param k
 *            the second of two integers to average
 * @return the integer average of j and k
 * @ensures average = (j+k)/2
 */
public static int average(int j, int k) {
    int q = j / 2 + k / 2;
    int r = j % 2 + k % 2;
    int adjust = r / 2
    return q + adjust;
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

[hw4]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/integer-average.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
