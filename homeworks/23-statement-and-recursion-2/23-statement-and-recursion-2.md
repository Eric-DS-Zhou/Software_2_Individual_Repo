# [Homework 23: Statement and Recursion 2][hw23]

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

The following problems will give you practice with statements and recursion.

### Problem 1

> Using recursion, complete the body of the following static method.

```java
/**
 * Refactors the given {@code Statement} so that every IF_ELSE statement
 * with a negated condition (NEXT_IS_NOT_EMPTY, NEXT_IS_NOT_ENEMY,
 * NEXT_IS_NOT_FRIEND, NEXT_IS_NOT_WALL) is replaced by an equivalent
 * IF_ELSE with the opposite condition and the "then" and "else" BLOCKs
 * switched. Every other statement is left unmodified.
 *
 * @param s
 *            the {@code Statement}
 * @updates s
 * @ensures <pre>
 * s = [#s refactored so that IF_ELSE statements with "not"
 *   conditions are simplified so the "not" is removed]
 * </pre>
 */
public static void simplifyIfElse(Statement s) {
    switch (s.kind()) {
        case BLOCK: {
 
            // TODO - fill in case
 
            break;
        }
        case IF: {
 
            // TODO - fill in case
 
            break;
        }
        case IF_ELSE: {
 
            // TODO - fill in case
 
            break;
        }
        case WHILE: {
 
            // TODO - fill in case
 
            break;
        }
        case CALL: {
            // nothing to do here...can you explain why?
            break;
        }
        default: {
            // this will never happen...can you explain why?
            break;
        }
    }
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

[hw23]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/statement2.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
