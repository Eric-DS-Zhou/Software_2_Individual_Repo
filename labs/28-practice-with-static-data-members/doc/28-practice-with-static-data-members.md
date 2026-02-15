# Lab: Practice with Static Data Members

## Objective

In this lab you will explore some issues related to the development and testing
of a class (EmailAccount1) that uses static data members to store state shared
by all instances (objects) of the class.

## Method

1. In the src folder, complete the EmailAccount1 class by pasting the code you
   wrote for the homework.
2. Open the EmailAccountMain.java program in the src folder and make sure you
   understand what it does. Run it and verify that your implementation results
   in the expected output. If not, fix any bugs.
3. Modify the main method in EmailAccountMain so that it repeatedly asks the
   user for a full name on one line, creates a new email account for that name,
   and outputs _**all** the email accounts created up to that point_. This is
   repeated until the user enters an empty string (i.e., just presses enter at
   the prompt). You can assume that the full names entered by the user include
   only first name and last name separated by a single space and that first and
   last name only contain letters (no spaces).
4. Test your EmailAccount1 implementation by running the program and entering a
   variety of names, including names that have the same last name, names that
   have the same last name but spelled with different case (e.g., Scarlet and
   SCARLET), names that are exactly the same, etc. Fix any bugs that you
   observe.

### Additional Activities

1. Develop a JUnit test fixture to test the EmailAccount1 implementation.
2. What new issues arise in testing as a result of the static variables used in
   the implementation?
