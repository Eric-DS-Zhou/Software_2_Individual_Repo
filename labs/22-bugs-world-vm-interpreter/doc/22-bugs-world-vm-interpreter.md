# Lab: BugsWorld Virtual Machine ByteCode Interpreter

## Objective

In this lab you familiarize yourself with the BugsWorld virtual machine (VM)
instruction set and behavior by writing and testing an interpreter of the VM
byte code programs.

## Method

1. First carefully look through the file BugsWorldVMInterpreter.java in the src
   folder and make sure you understand what each method does, including the main
   method. Complete the body of the static method
   extPrimitiveInstructionAddress by pasting the code you wrote for the homework
   into the skeleton provided.
2. Open the file BugsWorldVMInterpreterTest.java in the test folder and review
   the test cases provided to see how they are set up and how they attempt to
   test your implementation of the interpreter. Run the JUnit test fixture and
   carefully review any test cases that fail. If that is not enough information
   to help you find the bug(s), you can also run the main program in
   BugsWorldVMInterpreter and interactively execute a compiled BL program. In
   the data folder you will find one sample BL program TestProgram.bl and its
   compiled version TestProgram.bo that you can use as input to the main
   program. Fix all the bugs and make sure your interpreter passes all the test
   cases to complete this lab.
