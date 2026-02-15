# [Homework 32: WaitingLine Family Interface Design][hw32]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

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

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> For this homework, you will design the interfaces for a new component family,
> WaitingLine. WaitingLine is trying to capture the idea of a waiting line like
> you might encounter at a restaurant. Customers upon arriving at the restaurant
> have their name added to the end of the waiting line; they can ask for their
> position in the waiting line and perhaps later decide to leave and ask to be
> removed from the waiting line. Customers are seated in the order in which they
> are added to the waiting line. Note that a restaurant is just one example of
> where such a waiting line may be useful. There are many other situations where
> waiting lines occur and your components should be applicable to such other
> situations as well. WaitingLine is similar to Queue in that it provides a FIFO
> (first-in-first-out) order of processing, but differs from Queue in the following
> significant ways:
>
> - The entries in a WaitingLine must be unique.
> - It must be possible to remove a given entry known to be in a WaitingLine.
> - It must be possible to find the position of a given entry in a WaitingLine.
>
> Starting from the interfaces Standard, QueueKernel, and Queue, design new interfaces
> WaitingLineKernel and WaitingLine to capture the behavior of a waiting line. For this
> homework, turn in PDF print-outs of the WaitingLineKernel.java and WaitingLine.java files.

```java
public interface WaitingLineKernel<T> extends Standard<WaitingLine<T>>, Iterable<T> {

}
```

```java
public interface WaitingLine<T> extends WaitingLineKernel<T> {

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

[hw32]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/waiting-line-interfaces/waiting-line-interfaces.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
