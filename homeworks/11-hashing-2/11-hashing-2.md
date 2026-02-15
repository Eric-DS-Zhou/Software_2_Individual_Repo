# [Homework 11: Hashing 2][hw11]

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

Below you'll find the problems for today's homework.

### Problem 1

> Suppose you are implementing the following class representing
> 7-digit phone numbers in the form "XXX-XXXX" for a phone in the
> immediate OSU area. That is, you may assume the length of the
> PhoneNumber value is 8 and that each "X" is a digit '0'-'9'.

```java
/**
 * Simple class representing a 7-digit phone number in the form "XXX-XXXX"
 * for a phone in the immediate OSU area.
 */
public class PhoneNumber {
 
    /**
     * The phone number representation.
     */
    private String rep;
 
    /**
     * Constructor. {@code pNum} must be in the form "XXX-XXXX" where each
     * "X" is a digit '0'-'9'.
     */
    public PhoneNumber(String pNum) {
        this.rep = pNum;
    }
 
    ...
 
    @Override
    public int hashCode() {
 
        // TODO - fill in body
 
    }
 
    ...
}
```

> Write the code to implement the hashCode instance method.
> You can use the Character.digit(char ch, int radix) method to
> convert a "digit" character ch into the corresponding numeric
> value in the specified radix.

### Problem 2

> Some people have phone numbers such as 292-OHIO. Certain solutions
> to the previous problem couldn't necessarily be applied to the
> PhoneNumber value "292-OHIO" because it has non-digits. Furthermore,
> even if your particular implementation could be applied to this
> PhoneNumber value, it almost certainly would not do "the right thing"
> in an application program because the hash function probably would not
> give the same integer result as it does for the numeric version of the
> phone number, "292-6446".

#### Problem 2A

> Explain exactly what problem this would cause; i.e., explain what
> problem would arise if "292-OHIO" and "292-6446" were both considered
> legal phone numbers and your hash function from the previous problem
> could be applied to both of them, and therefore you actually decided
> to use that hash function for both of them.

#### Problem 2B

> Explain how you could change the hash function to correct this
> problem; i.e., explain what the hash function would have to do
> to handle phone numbers like "292-OHIO" and "292-6446" in a proper
> way.

#### Problem 2C

> While you're at it, you might as well also handle smoothly the case
> where the phone number is typed in as "292-ohio". Explain how you
> could further change the hash function to handle this situation, too.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw11]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/mod-hashing.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
