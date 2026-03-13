# [Homework 28: Evaluation of Arithmetic Expressions][hw28]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Mar 31 @ 4:10 PM EST

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

> Consider the following grammar for arithmetic expressions.
> It is similar to the one discussed in class.
>
>       expr        → term { + term | - term }
>       term        → factor { * factor | / factor }
>       factor      → ( expr ) | digit-seq
>       digit-seq   → digit { digit }
>       digit       → 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
>
> The recursive descent parser to evaluate syntactically valid arithmetic
> expressions has five methods corresponding to each of the five non-terminal
> symbols of this grammar. A tokenizer is not used for this parser. Instead,
> each method gets input characters from a StringBuilder parameter called source.
> You can assume that the source argument does not contain any white space or any
> other characters not part of the expression except for at least one "sentinel"
> character after the end of the expression to mark the end. In other words, any
> proper prefix of the argument can contain only characters from the set
> {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '+', '-', '*', '/'}.
> You can further assume that the input is syntactically valid, so that no error
> checking is necessary.
>
> Here are few more hints:
>
> - A string s1 being a proper prefix of a string s2 means both that the
>   length of s1 is strictly less than (less than but not equal to) the length
>   of s2 and that s1 is a prefix of s2.
> - The instance methods charAt(int) and deleteCharAt(int) defined in StringBuilder
>   will be useful to manipulate the input.
> - The static methods isDigit(char) and digit(char, int) in class Character can be
>   used to check if a character is a digit and to convert a digit character into the
>   corresponding integer value, respectively.
>
> Write the code for the following 5 methods making sure you use the grammar above
> as a guide (as discussed in class and in Recursive-Descent Parsing).

```java
/**
 * Evaluates an expression and returns its value.
 *
 * @param source
 *            the {@code StringBuilder} that starts with an expr string
 * @return value of the expression
 * @updates source
 * @requires <pre>
 * [an expr string is a proper prefix of source, and the longest
 * such, s, concatenated with the character following s, is not a prefix
 * of any expr string]
 * </pre>
 * @ensures <pre>
 * valueOfExpr =
 *   [value of longest expr string at start of #source]  and
 * #source = [longest expr string at start of #source] * source
 * </pre>
 */
public static int valueOfExpr(StringBuilder source) {
    int value = valueOfTerm(source);

    while (source.charAt(0) == '+' || source.charAt(0) == '-') {
        char op = source.charAt(0);
        source.deleteCharAt(0);
        int nextValue = valueOfTerm(source);

        if (op == '+') {
            value = value + nextValue;
        } else {
            value = value - nextValue;
        }
    }

    return value;
}
 
/**
 * Evaluates a term and returns its value.
 *
 * @param source
 *            the {@code StringBuilder} that starts with a term string
 * @return value of the term
 * @updates source
 * @requires <pre>
 * [a term string is a proper prefix of source, and the longest
 * such, s, concatenated with the character following s, is not a prefix
 * of any term string]
 * </pre>
 * @ensures <pre>
 * valueOfTerm =
 *   [value of longest term string at start of #source]  and
 * #source = [longest term string at start of #source] * source
 * </pre>
 */
private static int valueOfTerm(StringBuilder source) {
    int value = valueOfFactor(source);

    while (source.charAt(0) == '*' || source.charAt(0) == '/') {
        char op = source.charAt(0);
        source.deleteCharAt(0);
        int nextValue = valueOfFactor(source);

        if (op == '*') {
            value = value * nextValue;
        } else {
            value = value / nextValue;
        }
    }

    return value;
}
 
/**
 * Evaluates a factor and returns its value.
 *
 * @param source
 *            the {@code StringBuilder} that starts with a factor string
 * @return value of the factor
 * @updates source
 * @requires <pre>
 * [a factor string is a proper prefix of source, and the longest
 * such, s, concatenated with the character following s, is not a prefix
 * of any factor string]
 * </pre>
 * @ensures <pre>
 * valueOfFactor =
 *   [value of longest factor string at start of #source]  and
 * #source = [longest factor string at start of #source] * source
 * </pre>
 */
private static int valueOfFactor(StringBuilder source) {
    int value = 0;

    if (source.charAt(0) == '(') {
        source.deleteCharAt(0);
        value = valueOfExpr(source);
        source.deleteCharAt(0);
    } else {
        value = valueOfDigitSeq(source);
    }

    return value;
}
 
/**
 * Evaluates a digit sequence and returns its value.
 *
 * @param source
 *            the {@code StringBuilder} that starts with a digit-seq string
 * @return value of the digit sequence
 * @updates source
 * @requires <pre>
 * [a digit-seq string is a proper prefix of source, which
 * contains a character that is not a digit]
 * </pre>
 * @ensures <pre>
 * valueOfDigitSeq =
 *   [value of longest digit-seq string at start of #source]  and
 * #source = [longest digit-seq string at start of #source] * source
 * </pre>
 */
private static int valueOfDigitSeq(StringBuilder source) {
    int value = valueOfDigit(source);

    while (Character.isDigit(source.charAt(0))) {
        value = value * 10 + valueOfDigit(source);
    }

    return value;
}
 
/**
 * Evaluates a digit and returns its value.
 *
 * @param source
 *            the {@code StringBuilder} that starts with a digit
 * @return value of the digit
 * @updates source
 * @requires 1 < |source|  and  [the first character of source is a digit]
 * @ensures <pre>
 * valueOfDigit = [value of the digit at the start of #source]  and
 * #source = [digit string at start of #source] * source
 * </pre>
 */
private static int valueOfDigit(StringBuilder source) {
    int value = Character.digit(source.charAt(0), 10);
    source.deleteCharAt(0);

    return value;
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

[hw28]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/expression-evaluator.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[heapsort]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/heapsort.html
