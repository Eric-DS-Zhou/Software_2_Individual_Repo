# [Homework 2: Testing Sequence Smooth][hw2]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Jan 15 @ 4:10 PM EST

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

Below you will find the list of problems for this homework assignment.

### Problem 1

> Develop a complete test plan for the following static method smooth.

```java
/**
 * Smooths a given {@code Sequence<Integer>}.
 *
 * @param s1
 *            the sequence to smooth
 * @param s2
 *            the resulting sequence
 * @replaces s2
 * @requires |s1| >= 1
 * @ensures <pre>
 * |s2| = |s1| - 1  and
 *  for all i, j: integer, a, b: string of integer
 *      where (s1 = a * <i> * <j> * b)
 *    (there exists c, d: string of integer
 *       (|c| = |a|  and
 *        s2 = c * <(i+j)/2> * d))
 * </pre>
 */
public static void smooth(Sequence<Integer> s1, Sequence<Integer> s2) {...}
```

Test Plan:

input - output - type

1. s1 = < 2, 4 >, s2 = < 3 >, minimum output
2. s1 = < 1, 2 >, s2 = < 1 >, special integer division
3. s1 = < 0, 5, 0 >, s2 = < 2, 2 >, contains zero
4. s1 = < -3, -5, -7 >, s2 = < -4, -6 >, negative values
5. s1 = < 5, 5, 5 >, s2 = < 5, 5 >, repeated value
6. s1 = < 2, -5, 11, -4, 0 >, s2 = < -1, 3, 3, -2 >, both positive number and negative number
7. s1 = < 1000000, 1000002 >, s2 = < 1000001 >, large number
8. s1 = < 7 >, s2 = < >, minimum input size

### Problem 2

> Code your test cases in the JUnit test fixture accessible from
> the link below. Make sure you have access to an electronic version
> of the completed file in closed lab. Turn in a printed copy as your
> homework.

```java
/**
 * Test smooth with s1 = < 2, 4 >, s2 = < 2, 4 >.
 **/
@Test
public void test1(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(2, 4);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(3);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 1, 2 >, s2 = < 2, 4 >.
 **/
@Test
public void test2(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(1, 2);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(1, 2);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(1);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 0, 5, 0 >, s2 = < 2, 4 >.
 **/
@Test
public void test3(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(0, 5, 0);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(0, 5, 0);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(2, 2);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < -3, -5, -7 >, s2 = < 2, 4 >.
 **/
@Test
public void test4(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(-3, -5, -7);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(-3, -5, -7);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(-4, -6);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 5, 5, 5 >, s2 = < 2, 4 >.
 **/
@Test
public void test5(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(5, 5, 5);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(5, 5, 5);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(5, 5);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 2, -5, 11, -4, 0 >, s2 = < 2, 4 >.
 **/
@Test
public void test6(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(2, -5, 11, -4, 0);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(2, -5, 11, -4, 0);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(-1, 3, 3, -2);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 1000000, 1000002 >, s2 = < 2, 4 >.
 **/
@Test
public void test7(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(1000000, 1000002);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(1000000, 1000002);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs(1000001);
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
}

/**
 * Test smooth with s1 = < 7 >, s2 = < 2, 4 >.
 **/
@Test
public void test8(){
    /*
     * Set up variables and call method under test
     */
    Sequence<Integer> seq1 = this.createFromArgs(7);
    Sequence<Integer> expectedSeq1 = this.createFromArgs(7);
    Sequence<Integer> seq2 = this.createFromArgs(2, 4);
    Sequence<Integer> expectedSeq2 = this.createFromArgs();
    SequenceSmooth.smooth(seq1, seq2);
    /*
     * Assert that values of variables match expectations
     */
    assertEquals(expectedSeq1, seq1);
    assertEquals(expectedSeq2, seq2);
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

[hw2]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/smooth-test/smooth-test.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
