# Lab: Stack Implementation with Linked List

## Objective

In this lab you will practice working with linked structures by implementing and
testing a _kernel_ component, Stack2 implemented with a singly-linked list.

## Method

1. Take a look at the src and test folders in your new project. Open the
   Stack2.java file in the src folder and explore it. In particular, observe the
   private method _conventionHolds_ that checks whether the convention holds at
   the point in which it is invoked. As you can see, calls to this method have
   been inserted at the end of each public method in the class (or just before
   each return statement in functions). These calls are meant to help both in
   exposing internal bugs while testing and also in identifying some of the bugs
   while debugging.
2. Complete the body of the private method createNewRep and the body of the
   kernel methods (push, pop, and length) in Stack2 in the src folder. You
   should be able to just paste the code you wrote for the homework.
3. Paste the test cases you designed for the homework at the end of the
   StackTest class in the test folder.
4. Run Stack2Test in the test folder to test your implementation of Stack2. Fix
   any bugs that you discover and/or add extra test cases, if you realize that
   you are missing some important cases.

## Additional Activities

1. Copy and paste the following piece of code at the end of Stack2 (after the
   Stack2Iterator nested class and before the class Stack2 closing '}').

    ```java
    /*
     * Other methods (overridden for performance reasons) ---------------------
     */

    @Override
    public final T top() {
        assert this.length() > 0 : "Violation of: this /= <>";

        // TODO - fill in body

        assert this.conventionHolds();
        // Fix this line to return the result after checking the convention.
        return null;
    }

    @Override
    public final T replaceTop(T x) {
        assert this.length() > 0 : "Violation of: this /= <>";

        // TODO - fill in body
        assert this.conventionHolds();
        // Fix this line to return the result after checking the convention.
        return null;
    }
    ```

    Provide a non-layered implementation of the secondary methods top and
    replaceTop defined in [Stack][Stack].

2. Add appropriate test cases to your StackTest JUnit fixture to test the new
   methods top and replaceTop. Run the new fixture and fix any problems you
   encounter.
3. Take a look at the Standard methods (newInstance, clear, and transferFrom) in
   Stack2. We will discuss the details of these implementations later in the
   semester, but for now, design test cases to test these methods and add the
   test cases to your test fixture, StackTest.

[Stack]: https://cse22x1.engineering.osu.edu/common/doc/components/stack/Stack.html
