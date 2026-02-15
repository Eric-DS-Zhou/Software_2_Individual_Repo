# Lab: Statement and Recursion

## Objective

In this lab you will practice manipulating Statement values by implementing and
testing the static method countOfPrimitiveCalls.

## Method

1. Open the file CountPrimitiveCalls.java in the src folder and complete the
   body of the static method countOfPrimitiveCalls by pasting the code you wrote
   for the homework into the skeleton provided.
2. Open the CountPrimitiveCallsTest.java JUnit test fixture in the test folder
   and carefully review the createFromArgs method and its contract. One sample
   test case is provided as an example of how to test countOfPrimitiveCalls
   (note that it uses the input file test1.bl in the data folder). If you have
   questions about the test fixture, make sure to ask an instructor.
3. Run the test fixture. If your implementation of countOfPrimitiveCalls does
   not pass the test case provided, you need to debug your code. It might be
   helpful to create new (smaller) test cases that allow you to test each
   individual branch in the **switch** statement. Add the new test cases to the
   test fixture and test/debug your code until you believe it to be correct.

## Additional Activities

1. Implement and test the following static method. You can copy and paste
   countOfPrimitiveCalls and then update the contract and modify the header and
   the body.

    ```java
    /**
     * Reports the number of calls to a given instruction, {@code instr},
     * in a given {@code Statement}.
     *
     * @param s
     *          the {@code Statement}
     * @param instr
     *          the instruction name
     * @return the number of calls to {@code instr} in {@code s}
     * @ensures countOfInstructionCalls = [number of calls to instr in s]
     */
    public static int countOfInstructionCalls(Statement s, String instr) {...}
    ```

2. Implement and test the following static method. You can copy and paste
   countOfInstructionCalls and then update the contract and modify the header
   and the body.

    ```java
    /**
     * Refactors the given {@code Statement} by renaming every occurrence of
     * instruction {@code oldName} to {@code newName}. Every other statement is
     * left unmodified.
     *
     * @param s
     *          the {@code Statement}
     * @param oldName
     *          the name of the instruction to be renamed
     * @param newName
     *          the new name of the renamed instruction
     * @updates s
     * @requires [newName is a valid IDENTIFIER]
     * @ensures <pre>
     * s = [#s refactored so that every occurrence of oldName is
     *      replaced by newName]
     * </pre>
     */
    public static void renameInstruction(Statement s, String oldName, String newName) {...}
    ```
