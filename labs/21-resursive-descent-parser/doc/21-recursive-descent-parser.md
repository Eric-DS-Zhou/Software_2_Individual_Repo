# Lab: Evaluation of Arithmetic Expressions (Recursive Descent Parser)

## Objective

In this lab you will practice writing and testing a recursive-descent parser to
evaluate arithmetic expressions.

## Method

1. First carefully look through the file ExpressionEvaluator.java in the src
   folder and make sure you understand all the given members and the main
   method. Complete the body of the 5 static methods valueOfDigit,
   valueOfDigitSeq, valueOfFactor, valueOfTerm, and valueOfExpr comprising the
   parser by pasting the code you wrote for the homework into the skeleton
   provided.
2. You can test your parser implementation in a couple different ways. Run the
   main program and enter valid expressions terminated by '!' or use the
   provided JUnit test fixture (in the test folder) to systematically test your
   parser. One sample test case is provided to show you how to set them up. Even
   though it may seem to be extra work, it is a good idea to write test cases of
   increasing complexity starting from very simple expressions. This will make
   the task of debugging your code much simpler than just typing "random"
   expressions in the main program or having to reenter the same expressions
   over and over again as you make changes to your code.

### Additional Activities

1. If you did not create a JUnit test plan because you tested using the main
   program provided and your code seemed to work, develop a test plan for the
   parser and write appropriate JUnit test cases to implement your plan. Run the
   fixture on your implementation of the parser and see whether it exposes any
   defects.
2. Modify the grammar and the parser so that the evaluator allows the remainder
   operator (%) with the same precedence as multiplication (\*) and division
   (/).
