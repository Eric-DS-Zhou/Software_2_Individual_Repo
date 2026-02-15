# Lab: Practice with Java Collections Framework

## Objective

In this lab you will experiment with the Java Collections Framework (JCF) by
implementing the static methods giveRaise and incrementAll both with the OSU
CSE collection components and also with the JFC components and comparing and
testing the two solutions.

## Method

1. First carefully look through the file JCFExplorations.java. It contains the
   skeletons for two versions each of two static methods, giveRaise and
   incrementAll. The two versions of each method only differ in the type of one
   of the parameters. We used types fully qualified with the package name to
   make the distinction clear.
2. In JCFExplorations.java, complete the bodies of the two versions of the
   giveRaise _static_ method by pasting the code you wrote for the homework.
3. Open the file JCFExplorationsTest.java in the test folder and review the 2
   sample test cases provided for giveRaise to see how they are set up and how
   you can test your implementations of giveRaise. Add appropriate test cases
   for both implementations of giveRaise and run the JUnit test fixture until
   you are confident both that your implementations are correct and that your
   JUnit test fixture adequately tests your implementations.
4. In JCFExplorations.java, complete the bodies of the two versions of the
   incrementAll _static_ method.
5. In JCFExplorationsTest.java, review the 4 sample test cases provided for
   incrementAll to see how they are set up and how you can test your
   implementations of incrementAll. Add appropriate test cases for both
   implementations of incrementAll and run the JUnit test fixture until you are
   confident both that your implementations are correct and that your JUnit test
   fixture adequately tests your implementations.

### Additional Activities

1. Can you think of any other ways you could correctly implement each version of
   giveRaise and incrementAll? In particular, are other ways to iterate over Map
   and Set with either the OSU CSE collection components or with the JCF
   components viable alternatives to the ones you chose? If you have not
   experimented with other approaches you should do so to get a better
   understanding of what can and cannot be done while iterating over
   collections.
