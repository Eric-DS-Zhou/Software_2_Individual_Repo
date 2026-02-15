# Lab: List Implementation with Singly-Linked List and Two Smart Nodes

## Objective

In this lab you will practice working with linked structures by modifying a
given implementation of the _kernel_ component List2 implemented with a
singly-linked list. The given implementation uses only one "smart" node at the
start of the singly-linked list. You will modify it to use a second smart node
at the end of the list.

## Method

1. Take a look at the src and test folders in your new project. The src folder
   contains the List2.java implementation of List. The test folder contains a
   JUnit test fixture, ListTest, that provides a test fixture for the List
   kernel operations. (For this lab you will not have to write your own test
   fixture, though if you want you can certainly add your own test cases.)
2. In the src folder, copy the given List2.java file and name the copy
   List2a.java. Open the List2a.java file (make sure you do not edit the given
   List2.java file and keep it for reference). Then follow these steps in the
   order given:
    1. Find the declaration of the _finish_ field, and, using the refactoring
       capabilities of VSCode, rename it _postFinish_ to reflect the fact that
       it will be pointing to the second smart node following the last node in
       the singly-linked list containing a List entry.
    2. Fix the _convention_ and the _correspondence_ in the class Javadoc
       comment to reflect the modified implementation with two smart nodes.
    3. Modify the createNewRep private method so that it creates the second
       smart node and sets up the proper initial representation for List2a.
    4. Fix the kernel methods that need to be updated to take into account the
       new representation. To help you in your quest, we'll tell you that there
       are **2** kernel methods that need to be changed. It is up to you to
       figure out which ones and how to modify them.
    5. Find the declaration of the List2Iterator nested class, and, using the
       refactoring capabilities of Eclipse, rename it List2aIterator.
    6. Fix the iterator implementation in the List2aIterator nested class to
       correctly deal with the presence of the second smart node.
    7. Finally, after the iterator you can find an implementation of the
       secondary method moveToFinish included at the end of the List2 kernel for
       performance reasons (the layered implementation provided in ListSecondary
       exhibits linear time performance). This implementation is now broken. Fix
       it so that it works correctly with the singly-linked list representation
       with two smart nodes. Note that since this method is being overridden in
       a kernel, it must follow the same rules as other kernel methods; in
       particular, it must follow the _kernel purity rule_.
    8. Now consider these questions: Did your fix of moveToFinish result in an
       improvement in the time performance? Can you think of any way that class
       List2a, with its new representation invariant calling for two smart
       nodes, could provide an improvement in the time performance of
       moveToFinish? Should we be overriding moveToFinish in class List2a?
3. In the test folder, open the ListTest.java JUnit test fixture. Make sure you
   carefully look through it and that you recognize how it is organized, why
   each test case is included, and how each test case is designed.
4. In the test folder, copy the given List2Test.java file and name the copy
   List2aTest.java. Open the List2aTest.java file and replace List2 with List2a
   where needed.
5. Run List2aTest in the test folder to test your implementation of List2a. Fix
   any bugs that you discover.

## Additional Activities

1. Get started with the next project [List with Retreat][List with Retreat].

[List with Retreat]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/projects/list-with-retreat/list-with-retreat.html
