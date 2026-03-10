# [Homework 26: Tokenizer][hw26]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Mar 26 @ 4:10 PM EST

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

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> Carefully review the slides on Tokenizing.

### Problem 2

> Complete the body of the following private static method.

```java
/**
 * Returns the first "word" (maximal length string of characters not in
 * {@code SEPARATORS}) or "separator string" (maximal length string of
 * characters in {@code SEPARATORS}) in the given {@code text} starting at
 * the given {@code position}.
 *
 * @param text
 *            the {@code String} from which to get the word or separator
 *            string
 * @param position
 *            the starting index
 * @return the first word or separator string found in {@code text} starting
 *         at index {@code position}
 * @requires 0 <= position < |text|
 * @ensures <pre>
 * nextWordOrSeparator =
 *   text[position, position + |nextWordOrSeparator|)  and
 * if entries(text[position, position + 1)) intersection entries(SEPARATORS) = {}
 * then
 *   entries(nextWordOrSeparator) intersection entries(SEPARATORS) = {}  and
 *   (position + |nextWordOrSeparator| = |text|  or
 *    entries(text[position, position + |nextWordOrSeparator| + 1))
 *      intersection entries(SEPARATORS) /= {})
 * else
 *   entries(nextWordOrSeparator) is subset of entries(SEPARATORS)  and
 *   (position + |nextWordOrSeparator| = |text|  or
 *    entries(text[position, position + |nextWordOrSeparator| + 1))
 *      is not subset of entries(SEPARATORS))
 * </pre>
 */
private static String nextWordOrSeparator(String text, int position) {...}
```

> This is a modified version of the method you wrote in a homework and lab in Software I.
> Feel free to reuse your own code (but not someone else's) for this homework. Note that
> the method here has one less parameter than in the Software I version. The "separators"
> are defined as a String constant as follows:


```java
/**
 * Definition of whitespace separators.
 */
private static final String SEPARATORS = " \t\n\r";
```

### Problem 3

> Complete the body of the following public static method. You should use
> nextWordOrSeparator in your solution because (except for END_OF_INPUT as
> explained below) "non-separator token" and "non-whitespace token" here mean
> "word" as used in nextWordOrSeparator.

```java
/**
 * Tokenizes the entire input getting rid of all whitespace separators and
 * returning the non-separator tokens in a {@code Queue<String>}.
 *
 * @param in
 *            the input stream
 * @return the queue of tokens
 * @updates in.content
 * @requires in.is_open
 * @ensures <pre>
 * tokens =
 *   [the non-whitespace tokens in #in.content] * <END_OF_INPUT>  and
 * in.content = <>
 * </pre>
 */
public static Queue<String> tokens(SimpleReader in) {...}
```

> The END_OF_INPUT token used in the ensures clause is defined as a
> String constant as follows:

```java
/**
 * Token to mark the end of the input. This token cannot come from the input
 * stream because it contains whitespace.
 */
public static final String END_OF_INPUT = "### END OF INPUT ###";
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw26]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/tokenizer.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[heapsort]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/heapsort.html
