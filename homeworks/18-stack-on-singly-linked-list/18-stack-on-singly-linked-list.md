# [Homework 18: Stack Implementation with Singly-Linked List][hw18]

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

> Carefully review the Queue2 implementation of Queue kernel represented
> as a singly-linked list of Nodes. In particular, look at the representation
> fields (and the convention and correspondence) and the code in createNewRep
> and the constructor, and draw a picture (in the style used in the Linked Data
> Structures slides) of the Queue2 representation right after the constructor
> is executed.

### Problem 2

> Carefully review the Stack2 skeleton of Stack kernel represented as a
> singly-linked list of Nodes. In particular, look at the representation fields
> and the convention and correspondence, and draw a picture (in the style used
> in the Linked Data Structures slides) of the representation a Stack2 object
> should have right after the constructor is executed.

### Problem 3

> Complete the implementation of the Stack kernel represented as a singly-linked
> list of Nodes in the skeleton provided, Stack2. You need to write bodies for
> the private method createNewRep and for the kernel methods push, pop, and length.
>
> Note that although the Stack2 implementation is similar to the Queue2 implementation,
> there are two significant differences: (1) the Queue2 representation has three
> fields (instance variables): preFront, rear, and length, while Stack2 only has two
> fields: top and length; (2) the singly-linked list representing Queue2 has one extra
> "smart" node at the front of the list, while the singly-linked list representing
> Stack2 does not include this extra node.

```java
import java.util.Iterator;
import java.util.NoSuchElementException;

import components.stack.Stack;
import components.stack.StackSecondary;

/**
 * {@code Stack} represented as a singly linked list, done "bare-handed", with
 * implementations of primary methods.
 *
 * <p>
 * Execution-time performance of all methods implemented in this class is O(1).
 *
 * @param <T>
 *            type of Stack entries
 * @convention <pre>
 * $this.length >= 0  and
 * if $this.length == 0 then
 *   [$this.top is null]
 * else
 *   [$this.top is not null]  and
 *   [$this.top points to the first node of a singly linked list
 *    containing $this.length nodes]  and
 *   [next in the last node of that list is null]
 * </pre>
 * @correspondence this = [data in $this.length nodes starting at $this.top]
 */
public class Stack2<T> extends StackSecondary<T> {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Node class for singly linked list nodes.
     */
    private final class Node {

        /**
         * Data in node.
         */
        private T data;

        /**
         * Next node in singly linked list, or null.
         */
        private Node next;

    }

    /**
     * Top node of singly linked list.
     */
    private Node top;

    /**
     * Number of nodes in singly linked list, i.e., length = |this|.
     */
    private int length;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        // TODO - fill in body

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Stack2() {
        this.createNewRep();
    }

    /*
     * Standard methods removed to reduce clutter...
     */

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void push(T x) {
        assert x != null : "Violation of: x is not null";

        // TODO - fill in body

    }

    @Override
    public final T pop() {
        assert this.length() > 0 : "Violation of: this /= <>";

        // TODO - fill in body

    }

    @Override
    public final int length() {

        // TODO - fill in body

    }

    /*
     * Iterator code removed to reduce clutter...
     */

}
```

### Problem 4

> Develop a complete test plan for the Stack2 constructor and kernel methods
> you implemented and enter them in StackTest.

```java
import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    // TODO - add test cases for constructor, push, pop, and length

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

[hw18]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/stack-with-linked-list/stack-with-linked-list.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
