# Lab: Sequence Smooth

## Objective

In this lab you will practice writing the _smooth_ static method for
`Sequence<Integer>` in a couple different ways and testing your implementations
with your JUnit test fixture.

## Method

1. Take a look at the provided code skeleton and make sure you understand it.
2. Complete the body of the smooth static method. While you may use method
   entry, do not use any other method that is introduced in the enhanced
   interface Sequence. Among the methods still permitted for your use are all
   those inherited by or introduced in SequenceKernel, including add, remove,
   and length.
3. Run your JUnit test fixture and test your implementation of smooth. This is
   also a test of your test fixture itself, and you may have to fix some test
   cases or add new ones you had not considered before.
4. Provide an alternative implementation that is recursive if your first
   implementation was not recursive, or make your second implementation not
   recursive if the first one was recursive. You can just comment out the code
   of your first implementation (select the code to comment out and press
   <kbd>CTRL</kbd> + <kbd>/</kbd>, i.e., the Control key and the '/' key at the
   same time).
5. Run the JUnit test fixture and test your second implementation of smooth.
6. Once you are convinced that both your implementations work and you are
   satisfied with your test fixture, proceed with these steps:

   1. What is the value of the expression `-5 / 2`? If your test fixture does
      not include test cases involving negative numbers (both in the arguments
      and in the expected values), add appropriate test cases to deal with them.
      Run the new test fixture and fix any issues.
   2. Add the following test case to your test fixture:

        **Argument values:** s1 = `< 1073741825, 1073741825 >`, s2 = `< >`

        **Expected values:** s1 = `< 1073741825, 1073741825 >`, s2 = `< 1073741825 >`

        Run the JUnit test fixture and fix any new problem this test case exposes.

   3. Next add the following test case:

        **Argument values:** s1 = `< 1073741825, -1073741825 >`, s2 = `< >`

        **Expected values:** s1 = `< 1073741825, -1073741825 >`, s2 = `< 0 >`

        Run the JUnit test fixture and fix any new problem this test case exposes.

   4. Next add the following test case:

        **Argument values:** s1 = `< -1073741823, 1073741824 >`, s2 = `< >`

        **Expected values:** s1 = `< -1073741823, 1073741824 >`, s2 = `< 0 >`

        Run the JUnit test fixture and fix any new problem this test case exposes.
