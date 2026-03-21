# [Homework 36: Java File I/O][hw36]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 21 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 60 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> Write a main program that copies a given text file into another file
> using SimpleReader to read the input file and SimpleWriter to write the
> output file. The names of the input text file to be copied and of the
> destination file where the copy is to be saved are provided as command-line
> arguments. Assume that appropriate arguments will be provided and no error
> checking is necessary. The command-line arguments are accessible by your
> main program through the String[] args array parameter to the main method.
> If you need more details about command-line arguments, see Section 7.3,
> Command Line Arguments, in Java for Everyone.

```java
public static void main(String[] args) {
    SimpleReader in = new SimpleReader1L(args[0]);
    SimpleWriter out = new SimpleWriter1L(args[1]);

    while (!in.atEOS()) {
        String line = in.nextLine();
        out.println(line);
    }

    in.close;
    out.close;
}
```

### Problem 2

> Rewrite the file-copying main program using only the standard java.io
> classes discussed in class. Assume that appropriate arguments will be
> provided and no error checking is necessary. Do not handle the possible
> IOExceptions but simply declare that main may throw an IOException.

```java
public static void main(String[] args) {
    BufferedReader input = new BufferedReader(new FileReader(args[0]));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

    String line = input.readline();
    while (line != null){
        output.println(line);
        line = input.readLine();
    }

    input.close();
    output.close();
}
```

### Problem 3

> Copy and modify the previous main program so that it handles all possible
> IOExceptions and main will not throw any IOException. Output meaningful
> error message(s) if an IOException occurs.

```java
public static void main(String[] args) {
    BufferedReader input;
    PrintWriter output;

    try {
        input = new BufferedReader(new FileReader(args[0]));
        output = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
    } catch (IOException e) {
        System.err.println("Error opening file");
        return;
    }

    try {
        String s = input.readLine();
        while (s != null) {
            output.println(s);
            s = input.readLine();
        }
    } catch (IOException e) {
        System.err.println("Error reading from file");
    }

    try {
        input.close();
    } catch (IOException e) {
        System.err.println("Error closing file");
    }

    output.close;
}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw36]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/java-input-output.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
