# [Homework 10: Hashing and Implementing Mod][hw10]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Feb 5 @ 4:10 PM EST

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

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> Provide an implementation for the following static method mod that
> computes the modulo function using "clock arithmetic".

```java
/**
 * Computes {@code a} mod {@code b} as % should have been defined to work.
 *
 * @param a
 *            the number being reduced
 * @param b
 *            the modulus
 * @return the result of a mod b, which satisfies 0 <= {@code mod} < b
 * @requires b > 0
 * @ensures <pre>
 * 0 <= mod  and  mod < b  and
 * there exists k: integer (a = k * b + mod)
 * </pre>
 */
public static int mod(int a, int b) {
    int mod = a;

    while(mod < 0) {
        mod = mod + b;
    }

    while(mod >= b){
        mod = mod - b;
    }

    return mod;
}
```

> Note that, although you can use the remainder operator % in your
> solution, the following is not a correct implementation.

```java
public static int mod(int a, int b) {
    return a % b;
}
```

> If you are not sure why not, see the CSE 2221 lab where this was
> discussed (Sections 3. Debugging Oddity and Additional Activities).

### Problem 2

> Consider the set of integer {432, 17, 54, –788, –101, 84, 0, –6, –195, 90}
> and a hash table of size 10. Answer the following questions.

#### Problem 2A

> There are many implementations of hashCode that might seem reasonable
> when the argument type is Integer. For example, if you don't know anything
> in advance about the Integer values that might be likely to be hashed,
> then the implementation for hashCode that just returns the integer itself
> is quite reasonable (and, as it happens, this is the actual implementation
> provided by java.lang.Integer in the standard Java library). Show how the
> elements of the set above are distributed among the buckets by this hash
> function.

| Bucket | Integers Hashed |
| ------ | --------------- |
| 0      | 0, 90           |
| 1      |                 |
| 2      | 432, -788       |
| 3      |                 |
| 4      | 54, 84, -6      |
| 5      | -195            |
| 6      |                 |
| 7      | 17              |
| 8      |                 |
| 9      | -101            |

#### Problem 2B

> Write any qualitatively different implementation of hashCode when the
> argument type is Integer that might seem "reasonable" (without thinking
> in advance about the particular elements of the set above). Then show
> how the elements of the set above are distributed among the buckets by
> this hash function.

```java
@Override
public int hashCode() {
    int h = this.intValue();
    if (h < 0) {
        h = -h;
    }
    h = h % 10;
    return h;
}
```

| Bucket | Integers Hashed |
| ------ | --------------- |
| 0      | 0, 90           |
| 1      | -101            |
| 2      | 432             |
| 3      |                 |
| 4      | 54, 84          |
| 5      | -195            |
| 6      | -6              |
| 7      | 17              |
| 8      | -788            |
| 9      |                 |

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw10]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/mod-hashing.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
