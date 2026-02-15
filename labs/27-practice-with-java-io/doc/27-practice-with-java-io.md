# Lab: Practice with Java File I/O

## Objective

In this lab you will experiment with the Java Input/Output components by
implementing two programs that read input from a file and write output to a
file. You will also practice handling exceptions (IOException) with
**try-catch** and manipulating command-line arguments.

## Method

1. In CopyFileStdJava.java in the src folder, complete the main method by
   pasting the code you wrote for Question 3 in the homework. In other words,
   your program should copy the text file given as the first command-line
   argument into the file given as the second command-line argument and make
   sure that any IOException thrown is caught and results in an error message
   being printed to the console (to System.err).
2. Run your program. The data folder contains an example file containing some
   strings. Use it to filter the contents of importance.txt by using the
   command-line arguments labs/27-practice-with-java-io/data/importance.txt
   labs/27-practice-with-java-io/data/copy-importance.txt and visually inspect
   the output file for any problems.
3. In the **Package Explorer** view, copy CopyFileStdJava.java into a new file
   and name it FilterFileStdJava.java. Edit the new file so that it reads an
   input text file and outputs to another file only those lines of the input
   file that contain at least one string from a list of strings loaded from a
   third text file. The program expects three command-line arguments: the first
   is the name of the input file, the second is the name of the output file, and
   the third is the name of the file containing the "filter" strings, one per
   line.
4. Run your program. The data folder contains an example file containing some
   strings. Use it to filter the contents of importance.txt by using the
   command-line arguments labs/27-practice-with-java-io/data/importance.txt
   labs/27-practice-with-java-io/data/filter-importance.txt
   labs/27-practice-with-java-io/data/strings.txt and visually inspect the
   output file for any problems.

### Additional Activities

1. Modify the CopyFileStdJava.java program so that it also includes appropriate
   error checks on the command line arguments, e.g., missing arguments, missing
   input file, non-readable input file, etc. (The [java.io.File][Java File]
   class provides helpful methods to check some of the possible errors.)
2. Modify the FilterFileStdJava.java program so that it also includes
   appropriate error checks on the command line arguments.

[Java File]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/File.html
[Past Lab]: https://cse22x1.engineering.osu.edu/2231/web-sw2/extras/instructions/program-pretty-print/program-pretty-print.html
