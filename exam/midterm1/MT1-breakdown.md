# Software 2 Midterm 1

## Exam Logistics

### Format

- 55 minutes w/ countdown timer on the board.
- Two packets, #1 is the exam, #2 is the API documentation. Both get turned in.
- Graded by Sunday, returned on Wednesday.

### Cheating

- Grifski is excited to see old school cheating (dont cheat).

## Exam Content

### Breakdown

- 15 multiple choice questions, 45 points total. (5 are ambiguous)
- 2 short answer questions, 10 points total.
- 3 coding questions, 45 points total.

### Multiple Choice Questions (Each are 5pts)

1. What is the purpose of an implementer? What is their job? What do they do?
    - Make sure the ensures clause is true.
    - Consider: What is the purpose of a client? What is their job? What do they do?
      - Make sure the requires clause is true.
2. What is convention?
    - Restrictions/**rules** on our data.
3. What is correspondence?
    - How you **interpret** the representation. What does this stack mean?
4. What is `hashCode`?
    - An integer representation of an object
    - **NOT** an index
5. What does this Java code do?
    - Shown two different types, **they are equal**.
6. Turn an if statement into a single line of code using boolean operations
7. Boolean expression, for what values is it true?
8. What is the difference between two if statements and an if-else?
    - If-If hits both statements
    - If-Else only hits one statement
9. You have a JUnit test that throws an error: `expected NaturalNumber1L (5) but was NaturalNumber3 (5)`. What does this mean?
    - There is something wrong with your kernel methods, either not implemented, something wrong with isZero, etc..
    - `.equals()` uses the kernel methods to determine if two `NaturalNumber`'s are equal, so if the test fails, something is wrong with the kernel methods.
    - `.toString()` is
    - Answer is `equals` found an issue and `toString` wont tell me what it is
10. JUnit test case for `removeAny`, given the code for it as well. The description above the test case is going to say that everything is perfect. The test case returns a pass, but the test case is bad. What scenario would you have a bad test case that returns a pass but the code is also correct?
    - The test case assumes you `dequeue`. You cannot assume that because the implementation of `removeAny` may not be `dequeue`. This is a brittle test.
11. _Mystery_
12. _Mystery_
13. _Mystery_
14. _Mystery_
15. _Mystery_

### Short Answer Questions

1. `5pts` Given a table and you are given a four or five numbers, you have to put them in the table. Mod each number by the size of the table to put the numbers into the correct bucket. All the numbers are positive.
    - None of the numbers are greater than 20.
2. `5pts` Given a single negative number, correctly identify which bucket it goes into.

### Coding Questions

1. `10pts` Set on an array of sets (identical to project 3 which is map on an array of maps).
    - Implement one of `add(T x)`, `contains(T x)`, or `remove(T x)` (you do not get to choose which one, it will be assigned)
    - Approximately two lines of code
2. `15pts` Binary Tree Recursion - determine if a tree is balanced (`boolean` return value).
    - A tree is balanced if for every node, the **height** of the left and right subtrees differ by at most 1.
    - It must be true for every node in the tree, not just the root.
    - Approximately between 6 and 7 lines
    - **Points will be taken off for an inefficient solution**. If you find out that the left side is unbalanced, do not check the right, the tree is already known to be unbalanced.
3. `20pts` `NaturalNumber` on `Sequence<Integer>` (similar to project 2)
    - Not responsible for implementing constructors
    - But you will have to implement `isZero()`, `multiplyBy10(int)`, and `divideBy10()`.
    - Convention and correspondence is different: the zero value is `<0>`, so you must handle that case in the kernel methods. You cannot ever have an empty sequence `<>`.