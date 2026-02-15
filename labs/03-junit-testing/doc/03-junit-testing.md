# Lab: JUnit Testing Pattern

## Objective

In this lab you will learn how to organize a JUnit test fixture so that it can
be easily reused for different implementations.

## Method

1. Take a look at the two classes provided and make sure you understand how
    they are organized.
2. Complete the body of the createFromArgsTest and createFromArgsRef methods in
    StackTest.java so that they satisfy their contracts, and the body of the
    constructorTest and constructorRef methods in Stack1LTest.java so that they
    instantiate and return stacks of type Stack1L and of type Stack3,
    respectively. Note that the _varargs_ argument to createFromArgs can be
    interpreted and accessed as an array (guaranteed not to be null).
3. Run the Stack1LTest JUnit test fixture and make sure that all test cases
    complete successfully. If any of the test cases result in failures or
    errors, that probably indicates a problem with your code for the methods you
    implemented.
4. Once everything works as expected, create a new class in the test folder, by
    copying and pasting Stack1LTest, and name it Stack2Test. Update the
    constructorTest method so that it instantiates and returns a stack of type
    Stack2 (you can keep Stack3 as the reference implementation). Run the
    Stack2Test JUnit test fixture and make sure that all test cases complete
    successfully. This shows how simple it is to reuse the StackTest fixture to
    test a different implementation of Stack.
5. Consider the first section of test cases in StackTest, where we provided a
    few examples of test cases for the Stack kernel methods. Add new test cases
    to this section of StackTest to test **thoroughly** _and_ **systematically**
    the kernel methods _push_, _pop_, and _length_. Run the test fixtures and
    make sure all your test cases succeed.
