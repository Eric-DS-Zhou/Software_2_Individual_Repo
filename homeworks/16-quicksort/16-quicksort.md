# [Homework 16: Quicksort][hw16]

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

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> Implement the static method partition declared below that partitions
> a given queue, q, into two other queues, front and back. Entries from
> q no larger than the given partitioning entry, partitioner, are put in
> front, and entries from q larger than partitioner are put in back. Use
> the int order.compare(T, T) method to compare entries to partitioner
> and decide in which queue to put them. Pay attention to the parameter
> modes: clears for q and replaces for front and back.


```java
/**
 * Partitions {@code q} into two parts: entries no larger than
 * {@code partitioner} are put in {@code front}, and the rest are put in
 * {@code back}.
 *
 * @param <T>
 *            type of {@code Queue} entries
 * @param q
 *            the {@code Queue} to be partitioned
 * @param partitioner
 *            the partitioning value
 * @param front
 *            upon return, the entries no larger than {@code partitioner}
 * @param back
 *            upon return, the entries larger than {@code partitioner}
 * @param order
 *            ordering by which to separate entries
 * @clears q
 * @replaces front, back
 * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
 * @ensures <pre>
 * perms(#q, front * back)  and
 * for all x: T where (<x> is substring of front)
 *  ([relation computed by order.compare method](x, partitioner))  and
 * for all x: T where (<x> is substring of back)
 *  (not [relation computed by order.compare method](x, partitioner))
 * </pre>
 */
private static <T> void partition(Queue<T> q, T partitioner,
        Queue<T> front, Queue<T> back, Comparator<T> order) {...}
```

### Problem 2

> Implement the instance method sort declared below that sorts a Queue<T>
> (this) using the quicksort algorithm according to the given order.
> Quicksort is a recursive, divide and conquer algorithm. Basically it
> breaks the queue into two (smaller) queues, sorts the two smaller queues
> recursively, and finally assembles the sorted queue. Of course, if the
> original queue is either empty or it contains only one entry, it is
> already sorted and there is nothing to do. What specifically characterizes
> the quicksort algorithm is how the original queue is broken into two smaller
> queues: an entry of the original queue is used to partition the remaining
> entries between those no larger than the partitioning entry and those
> larger than the partitioning entry. After recursively sorting the two
> smaller queues, all that is left is to assemble the queue with the smaller
> entries, the partitioning entry, and the queue with the larger entries in
> this order back into the original queue (this). Follow the comments below
> to complete the quicksort implementation of sort.


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
public void sort(Comparator<T> order) {
    if (this.length() > 1) {
        /*
         * Dequeue the partitioning entry from this
         */
 
        /*
         * Partition this into two queues as discussed above
         * (you will need to declare and initialize two new queues)
         */
 
        /*
         * Recursively sort the two queues
         */
 
        /*
         * Reconstruct this by combining the two sorted queues and the
         * partitioning entry in the proper order
         */
 
    }
}
```

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

[hw16]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/queue-quicksort.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
