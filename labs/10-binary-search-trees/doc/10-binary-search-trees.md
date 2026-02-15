# Lab: Binary Search Trees

## Objective

In this lab you will deepen your understanding of binary search trees and
practice using the BinaryTree component and recursion by writing and testing the
isInTree static, generic method for `BinaryTree<T>`.

## Method

1. Take a look at the provided code skeleton of BinarySearchTreeMethods.java in
    the src folder and make sure you understand it. You will notice that the
    main program makes use of a custom utility class, BinaryTreeUtility, that
    provides a useful static method, insertInTree, used to insert a label in a
    binary search tree. Here is the documentation:

    ```java
    /**
     * Inserts {@code x} in {@code t}.
     *
     * @param <T>
     *          type of {@code BinaryTree} labels
     * @param t
     *          the {@code BinaryTree} to be searched
     * @param x
     *          the label to be inserted
     * @aliases reference {@code x}
     * @updates t
     * @requires IS_BST(t) and x is not in labels(t)
     * @ensures IS_BST(t) and labels(t) = labels(#t) union {x}
     */
    public static <T extends Comparable<T>> void insertInTree(
        BinaryTree<T> t, T x) {...}
    ```

2. Complete the body of the isInTree static, generic method by pasting the code
    you wrote for the homework. **Make sure your implementation takes advantage
    of the fact that the given tree is a _binary search tree_.**
3. Run the main program to interactively test your implementation of isInTree.
4. When you think it is working, edit the BinarySearchTreeMethodsTest.java
    JUnit test fixture in the test folder and add appropriate test cases for the
    isInTree method. One sample test case is provided as an example of how to
    set up a binary search tree.
5. Run your JUnit test fixture and fix any problems with your implementation of
    isInTree until it passes all its test cases and you are confident it is
    correct (and implemented efficiently).
6. If you have extra time, spend it working on the Additional Activities below
    because they are part of your next project.

### Additional Activities

1. Fill in the body of the removeSmallest method in the
    BinarySearchTreeMethods.java file.
2. Uncomment the last section of the main program so that it calls
    removeSmallest and outputs the labels in the tree smallest-to-largest. Run
    the main program to test your implementation of removeSmallest.
3. Add appropriate test cases to BinarySearchTreeMethodsTest.java to test your
    implementation of removeSmallest. Run the JUnit test fixture on your
    implementation and fix any remaining problems.
