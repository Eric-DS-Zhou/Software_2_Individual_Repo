# Lab: BinaryTree and Recursion

## Objective

In this lab you will practice using the BinaryTree component and recursion by
writing the height and isInTree static, generic methods for `BinaryTree<T>`.

## Method

1. Take a look at the provided code skeleton of BinaryTreeMethods.java in the
    src folder and make sure you understand it. You will notice that the main
    program makes use of a custom utility class, BinaryTreeUtility, that
    provides two useful static methods, treeFromString and treeToString, used to
    construct a `BinaryTree<String>` from a String representation and to convert
    a `BinaryTree<T>` to a specific String representation, respectively. Here is
    the documentation:

    ```java
    /**
     * Constructs and returns the {@code BinaryTree<String>} corresponding to
     * the given {@code String}.
     *
     * @param str
     *          the prefix representation of a {@code BinaryTree<String>}
     * @return the {@code BinaryTree<String>} corresponding to {@code str}
     * @requires <pre>
     * [str is the prefix representation of a BinaryTree<String>
     * where the String representations of the labels of the tree do not
     * contain the characters '(' and ')']
     * </pre>
     * @ensures treeFromString = [the BinaryTree<String> corresponding to str]
     */
    public static BinaryTree<String> treeFromString(String str) {...}
    ```

    ```java
    /**
     * Returns the {@code String} prefix representation of the given
     * {@code BinaryTree<T>}.
     *
     * @param <T>
     *          the type of the {@code BinaryTree} node labels
     * @param t * the {@code BinaryTree} to convert to a {@code String}
     * @return the prefix representation of {@code t}
     * @requires <pre>
     * [the String representations of the labels of t do not contain
     * the characters '(' and ')']
     * </pre>
     * @ensures treeToString = [the String prefix representation of t]
     */
    public static <T> String treeToString(BinaryTree<T> t) {...}
    ```

    The prefix representation of the empty tree is "()", and the prefix
    representation of a non-empty `BinaryTree<T>` is the string concatenation of
    the root, followed by '(', then by the prefix representation of the left
    subtree, the prefix representation of the right subtree, and finally ')'.
    _We assume that the labels in the tree cannot contain the characters '(' and
    ')'._ Here are five examples of prefix representations of some binary trees.
    See if you can figure out and draw the binary trees being described.

    - ()
    - a(()())
    - a(b(()())c(()()))
    - a(()b(()()))
    - a(()b(c(()())()))

2. Complete the body of the height static, generic method without using the
    BinaryTree height method, of course.
3. Run the main program to interactively test your implementation of height.
4. When you think it is working, run the BinaryTreeMethodsTest.java JUnit test
    fixture in the test folder. In addition to the test cases for height, this
    fixture contains test cases for the isInTree method, some of which will fail
    given that isInTree has not been implemented yet. Fix any problems with your
    implementation of height until it passes all its test cases.
5. Complete the body of the isInTree static, generic method and try it out by
    running the main program.
6. Then run the JUnit test fixture and fix any problems with your
    implementation of isInTree until it passes all its test cases.
7. Once your first implementation of isInTree passes all test cases, provide an
    alternative implementation that is recursive if your first implementation
    was not recursive, or make your second implementation not recursive if the
    first one was recursive. You can just comment out the code of your first
    implementation (select the code to comment out and press <kbd>CTRL</kbd> +
    <kbd>/</kbd>, i.e., the Control key and the '/' key at the same time).
8. Run the JUnit test fixture and test your second implementation of isInTree.

### Additional Activities

1. Copy and paste your implementation(s) of the size method from your homework
    into BinaryTreeMethods.java. Update the main program so that it calls size
    and outputs the result. Run the main program to test each implementation of
    size (recursive and iterative).
2. Add appropriate test cases to BinaryTreeMethodsTest.java to test your
    implementation(s) of size. Run the JUnit test fixture on each implementation
    of size (recursive and iterative).
