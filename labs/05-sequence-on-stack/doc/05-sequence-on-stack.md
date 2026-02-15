# Lab: Sequence Implementation on Stack

## Objective

In this lab you will practice implementing and testing a _kernel_ component,
Sequence3 implemented on Stack .

## Method

1. Take a look at the src and test folders in your new project. Open the
    Sequence3.java file in the src folder and explore it. In particular, take a
    look at the private members (the _representation_) at the top of the class
    and the _correspondence_ in the Javadoc comment for the class. The
    correspondence clause is a mathematical statement that describes how a
    client should interpret the variables in the data representation (denoted by
    `$this` followed by a dot and the name of the instance variable) as an
    abstract value of a `Sequence` variable (written `this`). (Note that the
    notation `$this` never appears in Java code, but only in Javadoc comments
    like this that describe aspects of the data representation!)
2. Paste the code you wrote for the homework into the body of the private
    method setLengthOfLeftStack, and complete the body of the kernel methods
    (add, remove, and length) in Sequence3 in the src folder.
3. Paste the test cases you designed for the homework at the end of the
    SequenceTest class in the test folder.
4. Run Sequence3Test in the test folder to test your implementation of
    Sequence3. Fix any bugs that you discover and/or add extra test cases, if
    you realize that you are missing some important cases.

## Additional Activities

1. Copy and paste the following piece of code at the end of Sequence3 (after
    the iterator method and before the class closing '}').

    ```java
    /*
     * Other methods (overridden for performance reasons) ---------------------
     */

    @Override public final void flip() {

        // TODO - fill in body

    }
    ```

    Provide a non-layered implementation of the secondary method flip defined in
    [Sequence][Sequence API]. Note that there is a simple, clever solution to
    this that does not involve iteration or recursion.

2. Add appropriate test cases for the flip method to SequenceTest and test your
    implementation.
3. Copy and paste the following piece of code at the end of Sequence3 (after
    the iterator method and before the class closing '}').

    ```java
    /*
     * Other methods (overridden for performance reasons) ---------------------
     */

    @Override
    public final T entry(int pos) {
        assert 0 <= pos : "Violation of: 0 <= pos";
        assert pos < this.length() : "Violation of: pos < |this|";

        // TODO - fill in body

    }
    ```

    Provide a non-layered implementation of the secondary method entry defined
    in [Sequence][Sequence API].

4. Add appropriate test cases for the entry method to SequenceTest and test
    your implementation.
5. Take a look at the Standard methods (newInstance, clear, and transferFrom)
    in Sequence3. We will discuss the details of these implementations later in
    the semester, but for now, design test cases to test these methods and add
    the test cases to your test fixture, SequenceTest.

[Sequence API]: https://cse22x1.engineering.osu.edu/common/doc/components/sequence/Sequence.html
