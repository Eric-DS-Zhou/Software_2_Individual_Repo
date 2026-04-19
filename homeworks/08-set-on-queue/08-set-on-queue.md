# [Homework 8: Set Implementation on Queue][hw8]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Jan 29 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 45 minutes
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

> Implement the following method that, given a queue and an
> entry of type T, searches for the given entry in the given
> queue and, if it finds it, moves that entry to the front of
> the queue.

```java
/**
 * Finds {@code x} in {@code q} and, if such exists, moves it to the front
 * of {@code q}.
 *
 * @param <T>
 *            type of {@code Queue} entries
 * @param q
 *            the {@code Queue} to be searched
 * @param x
 *            the entry to be searched for
 * @updates q
 * @ensures <pre>
 * perms(q, #q)  and
 * if <x> is substring of q
 *  then <x> is prefix of q
 * </pre>
 */
private static <T> void moveToFront(Queue<T> q, T x) {
    Queue<T> left = new Queue1L<>();
    Queue<T> right = new Queue1L<>();

    int n = q.length();
    boolean found = false;

    for (int i = 0; i < n; i++){
        T y = q.dequeue();
        if (!found && y.equals(x)){
            left.enqueue(y);
            found = true;
        } else {
            right.enqueue(y);
        }
    }

    q.append(left);
    q.append(right);
}
```

> Note that moveToFront is a static, generic method: it is parameterized
> by the type T of the entries in the queue. You can use the type T
> wherever you need to declare a variable that refers to an object of
> type T.、

> Pay attention to the contract. There is no requires clause. If you have
> trouble reading and understanding the *ensures* clause, be sure to ask for
> help.

### Problem 2

> Develop a complete test plan for the Set constructor and kernel methods:
> add, remove, removeAny, contains, and size and enter them in [SetTest][set-test].
> You can find some more information on how to effectively test removeAny
> [here][remove-any].

```java
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Eric Zhou
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }


    //test case for constructor

    @Test
    public void testConstuctor(){
        Set<String> ref = this.constructorRef();
        Set<String> test = this.constructorTest();

        assertEquals(ref, test);
    }

    //test cases for add

    //add in empty set
    @Test
    public void testAddEmpty(){
        Set<String> ref = this.createFromArgsRef("a");
        Set<String> test = this.constructorTest();

        test.add("a");

        assertEquals(ref, test);
    }

    //add in nonempty set
    @Test
    public void testAddNonEmpty(){
        Set<String> ref = this.createFromArgsRef("a", "b", "c");
        Set<String> test = this.createFromArgsTest("a", "b");

        test.add("c");

        assertEquals(ref, test);
    }

    //test cases for remove

    //empty after remove
    @Test
    public void testEmptyAfterRemoved(){
        Set<String> ref = this.constructorRef();
        Set<String> test = this.createFromArgsTest("a");

        String removed = test.remove("a");

        assertEquals("a", removed);
        assertEquals(ref, test);
    }

    //normal remove
    @Test
    public void testRemoveNormal(){
        Set<String> ref = this.createFromArgsRef("a", "c");
        Set<String> test = this.createFromArgsTest("a", "b", "c");

        String removed = test.remove("b");

        assertEquals("b", removed);
        assertEquals(ref, test);
    }

    //test cases for removeAny

    //only one element
    @Test
    public void testRemoveAnyOnlyOne(){
        Set<String> ref = this.constructorRef();
        Set<String> test = this.createFromArgsTest("a");

        String removed = test.removeAny();

        assertEquals("a", removed);
        assertEquals(ref, test);
    }

    //normal removeAny
    @Test
    public void testRemoveAnyNormal(){
        Set<String> test = this.createFromArgsTest("a", "b", "c");
        Set<String> ref = this.createFromArgsRef("a", "b", "c");

        String removed = test.removeAny();

        assertEquals(true, ref.contains(removed));
        ref.remove(removed);
        assertEquals(ref, test);
    }

    //test cases for contains

    //empty
    @Test
    public void testContainsEmpty(){
        Set<String> test = this.constructorTest();

        assertEquals(false, test.contains("a"));
    }

    //normal cases for contains
    @Test
    public void testContainsNormal(){
        Set<String> test = this.createFromArgsTest("a", "b", "c");

        assertEquals(true, test.contains("a"));
        assertEquals(false, test.contains("d"));
    }

    //test cases for size

    //empty
    @Test
    public void testSizeEmpty(){
        Set<String> test = this.constructorTest();

        assertEquals(0, test.size());
    }

    //normal case for size
    @Test
    public void testSizeNormal(){
        Set<String> test = this.createFromArgsTest("a", "b", "c");

        assertEquals(3, test.size());
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

[hw8]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/set-on-queue/set-on-queue.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[set-test]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/set-on-queue/SetTest.java
[remove-any]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/set-on-queue/test-removeany.html
