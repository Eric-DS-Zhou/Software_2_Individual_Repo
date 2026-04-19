# [Homework 7: Sequence Implementation on Stack][hw7]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Jan 27 @ 4:10 PM EST

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

> Implement the following method that, given two stacks and an
> integer, moves entries between the two stacks so that the length
> of the first stack is equal to the given integer. Note that, as
> the ensures clause states, rev(leftStack) * rightStack must not
> be changed by the method.

```java
/**
 * Shifts entries between {@code leftStack} and {@code rightStack}, keeping
 * reverse of the former concatenated with the latter fixed, and resulting
 * in length of the former equal to {@code newLeftLength}.
 *
 * @param <T>
 *            type of {@code Stack} entries
 * @param leftStack
 *            the left {@code Stack}
 * @param rightStack
 *            the right {@code Stack}
 * @param newLeftLength
 *            desired new length of {@code leftStack}
 * @updates leftStack, rightStack
 * @requires <pre>
 * 0 <= newLeftLength  and
 * newLeftLength <= |leftStack| + |rightStack|
 * </pre>
 * @ensures <pre>
 * rev(leftStack) * rightStack = rev(#leftStack) * #rightStack  and
 * |leftStack| = newLeftLength}
 * </pre>
 */
private static <T> void setLengthOfLeftStack(Stack<T> leftStack,
        Stack<T> rightStack, int newLeftLength) {
            while (leftStack.length() > newLeftLength){
                rightStack.push(leftStack.pop());
            }

            while (leftStack.length() < newLeftLength){
                leftStack.push(rightStack.pop());
            }
        }
```

> Note that setLengthOfLeftStack is a static, generic method:
> it is parameterized by the type T of the entries in the stacks.
> You can use the type T wherever you need to declare a variable
> that refers to an object of type T.

### Problem 2

> Develop a complete test plan for the Sequence constructor
> and kernel methods (add, remove, and length) and enter
> them in [SequenceTest][sequence-test].

```java
import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Eric Zhou
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // test case for constructor
    @Test
    public void testConstructorEmpty() {
        Sequence<String> sTest = this.constructorTest();
        Sequence<String> sRef = this.constructorRef();
        assertEquals(sRef, sTest);
    }

    // test case for add

    //add element to empty construtor
    @Test
    public void testConstructorNoEmpty() {
        Sequence<String> sTest = this.createFromArgsTest();
        Sequence<String> sRef = this.createFromArgsRef();

        sTest.add(0, "a");
        sRef.add(0, "a");

        assertEquals(sRef, sTest);
    }

    //add element in front
    @Test
    public void testAddFront() {
        Sequence<String> sTest = this.createFromArgsTest("b", "c");
        Sequence<String> sRef = this.createFromArgsRef("b", "c");

        sTest.add(0, "a");
        sRef.add(0, "a");

        assertEquals(sRef, sTest);
    }

    //add element in middle
    @Test
    public void testAddMiddle() {
        Sequence<String> sTest = this.createFromArgsTest("b", "c");
        Sequence<String> sRef = this.createFromArgsRef("b", "c");

        sTest.add(1, "a");
        sRef.add(1, "a");

        assertEquals(sRef, sTest);
    }

    //add element at end
    @Test
    public void testAddEnd() {
        Sequence<String> sTest = this.createFromArgsTest("b", "c");
        Sequence<String> sRef = this.createFromArgsRef("b", "c");

        sTest.add(2, "a");
        sRef.add(2, "a");

        assertEquals(sRef, sTest);
    }

    //test cases for remove

    //remove the front
    @Test
    public void testRemoveFront() {
        Sequence<String> sTest = this.createFromArgsTest("a", "b", "c");
        Sequence<String> sRef = this.createFromArgsRef("a", "b", "c");

        String removeTest = sTest.remove(0);
        String removeRef = sRef.remove(0);

        assertEquals(sRef, sTest);
        assertEquals(removeRef, removeTest);
    }

    //remove the middle
    @Test
    public void testRemoveMiddle() {
        Sequence<String> sTest = this.createFromArgsTest("a", "b", "c");
        Sequence<String> sRef = this.createFromArgsRef("a", "b", "c");

        String removeTest = sTest.remove(1);
        String removeRef = sRef.remove(1);

        assertEquals(sRef, sTest);
        assertEquals(removeRef, removeTest);
    }

    //remove the end
    @Test
    public void testRemoveEnd() {
        Sequence<String> sTest = this.createFromArgsTest("a", "b", "c");
        Sequence<String> sRef = this.createFromArgsRef("a", "b", "c");

        String removeTest = sTest.remove(2);
        String removeRef = sRef.remove(2);

        assertEquals(sRef, sTest);
        assertEquals(removeRef, removeTest);
    }

    //test cases for length

    //empty
    @Test
    public void testLengthEmpty() {
        Sequence<String> sTest = this.createFromArgsTest();
        Sequence<String> sRef = this.createFromArgsRef();

        assertEquals(sRef.length(), sTest.length());
    }

    //not empty
    @Test
    public void testLengthNotEmpty() {
        Sequence<String> sTest = this.createFromArgsTest("a", "b", "c");
        Sequence<String> sRef = this.createFromArgsRef("a", "b", "c");

        assertEquals(sRef.length(), sTest.length());
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

[hw7]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/sequence-on-stack/sequence-on-stack.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[sequence-test]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/sequence-on-stack/SequenceTest.java
