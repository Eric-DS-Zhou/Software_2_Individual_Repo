# [Homework 15: Insertion Sort][hw15]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

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

> Implement the static method insertInOrder declared below
> that inserts an entry, x, into a sorted queue, q, in the
> appropriate position to keep the queue sorted. Use the int
> order.compare(T, T) method to compare entries and find the
> correct insertion point.

```java
/**
 * Inserts the given {@code T} in the {@code Queue<T>} sorted according to
 * the given {@code Comparator<T>} and maintains the {@code Queue<T>}
 * sorted.
 *
 * @param <T>
 *            type of {@code Queue} entries
 * @param q
 *            the {@code Queue} to insert into
 * @param x
 *            the {@code T} to insert
 * @param order
 *            the {@code Comparator} defining the order for {@code T}
 * @updates q
 * @requires <pre>
 * IS_TOTAL_PREORDER([relation computed by order.compare method])  and
 * IS_SORTED(q, [relation computed by order.compare method])
 * </pre>
 * @ensures <pre>
 * perms(q, #q * <x>)  and
 * IS_SORTED(q, [relation computed by order.compare method])
 * </pre>
 */
private static <T> void insertInOrder(Queue<T> q, T x, Comparator<T> order) {...}
```

### Problem 2

> Implement the instance method sort declared below that sorts
> a Queue<T> (this) using the "insertion sort" algorithm according
> to the given order. This algorithm repeatedly calls dequeue until
> this is empty, placing the entries into a temporary queue with
> insertInOrder, and then finally transferring this temporary object
> into this.

```java
/**
 * Sorts {@code this} according to the ordering provided by the
 * {@code compare} method from {@code order}.
 *
 * @param order
 *            ordering by which to sort
 * @updates this
 * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
 * @ensures <pre>
 * perms(this, #this)  and
 * IS_SORTED(this, [relation computed by order.compare method])
 * </pre>
 */
public void sort(Comparator<T> order) {...}
```

### Problem 3

> For the trace in this question, please assume the presence
> in the same class of the following static nested class:

```java
/**
 * Integer greater-than-or-equal-to Comparator. This effect is achieved by
 * reversing the natural ordering provided by interface Comparable's
 * compareTo, which Integer implements as less-than-or-equal-to.
 */
private static class IntegerGE implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
```

> Complete (and print with your homework) the following tracing table.
> Recalling how much we care that you use correct punctuation when you
> write objects' values, we urge you to practice doing so. For example,
> after the 5th statement one of the six correct ways of showing the
> value of the SortingMachine is: sm = (false, ≥, {0, -1, 2}). There
> are six (or three factorial, 3!) correct ways because the order in
> which we show the three elements of the multiset does not matter.
> Note the use of rounded parentheses, commas, and curly braces. It
> is a good idea to consult the mathematical model for SortingMachineKernel
> and make a connection between it and the notation used in the correct
> answer shown here just above. Of course, it is also a good idea to
> consult the contract for each method or constructor called.

| Statement                                                               | Variable Values     |
| ----------------------------------------------------------------------- | ------------------- |
| `SortingMachine<Integer> sm = new SortingMachine1L<>(new IntegerGE());` |                     |
|                                                                         | sm = `?`            |
| `sm.add(0);`                                                            |                     |
|                                                                         | sm = `?`            |
| `sm.add(2);`                                                            |                     |
|                                                                         | sm = `?`            |
| `sm.add(-1);`                                                           |                     |
|                                                                         | sm = `?`            |
| `sm.changeToExtractionMode();`                                          |                     |
|                                                                         | sm = `?`            |
| `int i = sm.removeFirst();`                                             |                     |
|                                                                         | sm = `?`<br>i = `?` |
| `sm.clear();`                                                           |                     |
|                                                                         | sm = `?`<br>i = `?` |

> For completeness, here are the math definitions used in the contracts above.

```java
/**
 * @mathdefinitions <pre>
 * IS_TOTAL_PREORDER (
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y, z: T
 *   ((r(x, y) or r(y, x))  and
 *    (if (r(x, y) and r(y, z)) then r(x, z)))
 *
 * IS_SORTED (
 *   s: string of T,
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y: T where (<x, y> is substring of s) (r(x, y))
 * </pre>
 */
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw15]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/queue-insertion-sort.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
