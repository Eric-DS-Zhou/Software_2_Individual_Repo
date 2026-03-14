# [Homework 29: Evaluation of Boolean Expressions][hw29]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 1 @ 4:10 PM EST

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

The following problems will give you practice with statements and recursion.

### Problem 1

> Consider the following grammar for Boolean expressions.
>
>       bool-expr	→ T |
>                   → F |
>                   → NOT ( bool-expr ) |
>                   → ( bool-expr binary-op bool-expr )
>       binary-op	→ AND | OR
>
> The recursive descent parser to evaluate syntactically valid
> Boolean expressions has a single method corresponding to the
> bool-expr start symbol of this grammar. A tokenizer is used to
> convert the input into a queue of tokens (Queue<String>) given
> as the argument to the parser. The tokenizer takes care of the
> binary-op non-terminal symbol by returning "AND" and "OR" as single
> tokens. You can assume that the input is syntactically valid, so
> that no error checking is necessary. Here is a sample value for
> #tokens. It represents a a boolean expression whose parse tree
> only has height 3. Other incoming values can be more complicated.
> Note that, as terminal symbols, parentheses can be part of a boolean
> expression. The given sample value represents the boolean expression:
>
>       NOT ( F )
>
> A possible sample value promised for #tokens could be:
>
>       <"NOT", "(", "F", ")", "### END OF INPUT ###">
>
> In this case the outgoing value of tokens should be:
>
>       <"### END OF INPUT ###">
>
> Do not test for equality against "### END OF INPUT ###"
> or test against the length of tokens. Another sample value for
> the same boolean expression could be:
>
>       <"NOT", "(", "F", ")", ")", "### END OF INPUT ###">
>
> In this latter case the outgoing value of tokens should be:
>
>       <")", "### END OF INPUT ###">
>
> Finally, yet another sample value for the same boolean expression could be:
>
>       <"NOT", "(", "F", ")">
>
> In this last case the outgoing value of tokens should be:
>
>       <>
>
> Write the code for the following method making sure you use the
> grammar above as a guide (as discussed in class and in Recursive-Descent Parsing).

```java
/**
 * Evaluates a Boolean expression and returns its value.
 *
 * @param tokens
 *            the {@code Queue<String>} that starts with a bool-expr string
 * @return value of the expression
 * @updates tokens
 * @requires [a bool-expr string is a prefix of tokens]
 * @ensures <pre>
 * valueOfBoolExpr =
 *   [value of longest bool-expr string at start of #tokens]  and
 * #tokens = [longest bool-expr string at start of #tokens] * tokens
 * </pre>
 */
public static boolean valueOfBoolExpr(Queue<String> tokens) {
    String token = tokens.front();
    boolean value;

    if (token.equals("T")) {
        tokens.dequeue();
        value = true;
    } else if (token.equals("F")) {
        tokens.dequeue();
        value = false;
    } else if (token.equals("NOT")) {
        tokens.dequeue();
        tokens.dequeue();
        boolean result = valueOfBoolExpr(tokens);
        tokens.dequeue();
        value = !result;
    } else {
        tokens.dequeue();
        boolean left = valueOfBoolExpr(tokens);
        String op = tokens.dequeue();
        boolean right = valueOfBoolExpr(tokens);
        if (op.equals("AND")) {
            value = left && right;
        } else {
            value = left || right;
        }
        tokens.dequeue();
    }

    return value;
}
```

> As practice for the final exam (recursive-descent parsers will not be
> a topic for the upcoming second midterm exam), you should first write the
> code without any assistance from Eclipse. However, if you would like to
> test your code, you can paste it in this BooleanExpressionEvaluator.java
> skeleton file. You may also want to develop a JUnit test fixture to test
> your parser as extra practice. For this homework, just turn in a print-out
> of the code for valueOfBoolExpr.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw29]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/boolean-expression-evaluator/boolean-expression-evaluator.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
