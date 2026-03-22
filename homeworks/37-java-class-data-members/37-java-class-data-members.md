# [Homework 37: Java Class/Static Data Members - EmailAccount][hw37]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 23 @ 4:10 PM EST

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

> Complete the class EmailAccount1 that implements the EmailAccount interface.
> In addition to the requirements explicitly stated in the interface, note the following:
> - The integers used in email addresses follow the standard OSU naming strategy.
>   That is, the smallest positive integer that makes an address unique is used.
>   For example, if the first two email accounts instantiated are for Alice Scarlet
>   and Bob Gray, both would have a "1" in their email address since the last names
>   are sufficient to distinguish them. Only if a second account with a last name of
>   Scarlet (or Gray) is instantiated would a "2" be used for the new account's email
>   address.
> - It is possible to have several people with the same last name (e.g., Alice Scarlet
>   and Jane Scarlet) and even several people with the same full name (e.g., three Bob
>   Gray accounts, each getting its separate email address gray.1, gray.2, and gray.3).
> - The names provided to the constructor can use arbitrary case (e.g., Scarlet or SCARLET
>   or ScArLeT). Whatever case was used by the client should be used in the strings returned
>   by name and toString. However, the email address should only include lower case letters.
> - Numbers that have been used previously for some email address cannot be reused for
>   the same last name.

```java

/**
 * Implementation of {@code EmailAccount}.
 *
 * @author Eric Zhou
 *
 */
public final class EmailAccount1 implements EmailAccount {

    /*
     * Private members --------------------------------------------------------
     */

    Private String firstName;
    Private String lastName;
    Private String emailAddress;
    Private static final Map<String, Integer> map = new Map1L<String, Integer>();

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * Constructor.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public EmailAccount1(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

        String lowerLast = lastName.toLowerCase();
        int number = 0;

        if(map.hasKey(lowerLast)) {
            number = map.value(lowerLast) + 1;
            map.replaceValue(lowerLast, number);
        } else {
            number = 1;
            map.add(lowerLast, number);
        }

        this.emailAddress = lowerLast + "." + number + "@osu.edu";

    }

    /*
     * Methods ----------------------------------------------------------------
     */

    @Override
    public String name() {

        String result = this.firstName + " " + this.lastName;
        return result;

    }

    @Override
    public String emailAddress() {

        String result = this.emailAddress;
        return result;

    }

    @Override
    public String toString() {

        String result = "Name: " + this.name() + ", Email: " + this.emailAddress();
        return result;

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

[hw37]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/email-accounts/email-accounts.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
