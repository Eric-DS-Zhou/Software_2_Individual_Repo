# [Homework 27: Context-Free Grammars][hw27]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Mar 27 @ 4:10 PM EST

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

> For this homework, you do not have to type and print your answers given
> that it includes drawings of derivation trees. However, your homework should
> still be done in a professional manner and your answers should be clear and
> readable.

### Problem 1

> Using the grammar for real-number constants discussed in class, write a set
> of rewrite rules for signed real-number constants that allow an optional sign
> at the front of the constants. Use signed-real-const as the new start symbol.
> You can reuse as much or as little of the real-number constant grammar rules as
> you deem appropriate. Examples of valid signed real-number constants are:
>
>       -3.56, +17.E09, 4.95

    <signed-real-constant> =>   <real constant> |
                              + <real constant> |
                              - <real constant>
    <real-constant> => <digit-seq> . <digit-seq>  |
                       <digit-seq> . <digit-seq><exponent> |
                       <digit-seq> . |
                       <digit-seq> . <exponent>
    <exponent> => E <digit-seq>   |
                  E + <digit-seq> |
                  E - <digit-seq>
    <digit-seq> => <digit><digit-seq> |
               <digit>
    <digit> => 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

### Problem 2

> Using the following rewrite rules for Boolean expressions, give a derivation
> for the Boolean expression (NOT((F AND T)) OR F). Also draw a derivation tree
> corresponding to the derivation.
>
>       bool-exp    → T |
>                   → F |
>                   → NOT ( bool-exp ) |
>                   → ( bool-exp AND bool-exp ) |
>                   → ( bool-exp OR bool-exp )

    bool-exp
    => ( bool-exp OR bool-exp )
    => ( NOT ( bool-exp ) OR bool-exp )
    => ( NOT ( ( bool-exp AND bool-exp ) ) OR bool-exp )
    => ( NOT ( ( F AND bool-exp ) ) OR bool-exp )
    => ( NOT ( ( F AND T ) ) OR bool-exp )
    => ( NOT ( ( F AND T ) ) OR F )

![Problem 2](problem2.png)

### Problem 3

> Using the following rewrite rules for Boolean expressions, find two different
> derivation trees for the Boolean expression NOT(T OR T AND F).
>
>       bool-exp    → T |
>                   → F |
>                   → NOT ( bool-exp ) |
>                   → bool-exp AND bool-exp |
>                   → bool-exp OR bool-exp

`TYPE ONE`: ![Problem 3 - Type 1](Problem3_Type1.png)

`TYPE TWO`: ![Problem 3 - Type 2](Problem3_Type2.png)

### Problem 4

> Using the following rewrite rules for arithmetic expressions, draw a derivation
> tree for the expression 5*3+1+4.
>
>       expr        → expr add-op term | term
>       term        → term mult-op factor | factor
>       factor      → ( expr ) | digit-seq
>       add-op      → + | -
>       mult-op     → * | DIV | MOD
>       digit-seq   → digit digit-seq | digit
>       digit       → 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

![Problem 4](Problem4.png)

### Problem 5

> Using the following rewrite rules for arithmetic expressions, draw a derivation
> tree for the expression 5*3+1+4.
>
>       expr        → term { add-op term }
>       term        → factor { mult-op factor }
>       factor      → ( expr ) | digit-seq
>       add-op      → + | -
>       mult-op     → * | DIV | MOD
>       digit-seq   → digit digit-seq | digit
>       digit       → 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
>
> **Note**: A pair of new special symbols ('{' and '}') is used in the rewrite rules
> above. The meaning of {...} is that the string of nonterminal and terminal symbols
> appearing between { and } can be repeated 0 or more times. For instance, the first
> rewrite rule:
>
>       expr    → term { add-op term }
>
> is equivalent to the following (infinite) set of rewrite rules:
>
>       expr    → term |
>               → term add-op term |
>               → term add-op term add-op term |
>               → term add-op term add-op term add-op term |
>               → ...

![Problem 5](Problem5.png)

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw27]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/context-free-grammars.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
