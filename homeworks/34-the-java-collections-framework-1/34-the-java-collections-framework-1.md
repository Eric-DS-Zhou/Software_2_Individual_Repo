# [Homework 34: The Java Collections Framework 1][hw34]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 15 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 30 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

The following problems will give you practice with the java collections
framework.

### Problem 1

> Complete the reading assignment from the Collections Trail in the Java Tutorials.

### Problem 2

> For each of the following four tasks, specify which of the OSU CSE
> component families is best suited, and explain how to use it to implement
> the task. (You do not need to write any code. Just give an idea of how you
> would use the component to solve the problem.)

#### Problem 2A

> Whimsical Toys Inc (WTI) needs to record the names of all its employees.
> Every month, an employee will be chosen at random from these records to
> receive a free toy.

Answer: `Sequence`. We can generate a random valid position in the sequence and choose the employee at that position. This is better than using a `Set` because employee names may be duplicated, and a Set cannot store multiple identical names.

#### Problem 2B

> WTI has decided that each new product will be named after an employee –
> but only first names will be used, and each name will be used only once.
> Prepare a list of unique first names.

Answer: `Set`. We can use the `Set` to store the unique first names. The `Set` prevents duplicates, so that each name will be used only once.

#### Problem 2C

> WTI decides that it only wants to use the most popular names for its toys.
> Count the number of employees who have each first name.

Answer: `Map`. We can use the `map` to store the names. Its keys are the first names and its values are the number of employees with those names.

#### Problem 2D

> WTI acquires season tickets for the local lacrosse team, to be shared by
> employees. Create a waiting list for this popular sport.

Answer: `Queue`. We can use `Queue` to create a waitlist because the `Queue` follow the "First in First out (FIFO)" rule. Therefore, the employee joins first will be given the opportunity first.

### Problem 3

> For each of the four tasks above, specify which of the Java Collections
> Framework interfaces is best suited, and explain any differences in how
> you would use it compared to the OSU CSE component you chose to handle the task.

Answer:

- `List`, almost no difference with OSU component.

- `Sorted Set`, it has the alphabetical order with the name.

- `Sorted Map`, it has the alphabetical order with the name. In addition, we may use Collections.max(map.values()); to find the biggest value.

- `Queue`, almost no difference with OSU component.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw34]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/java-collections-framework1.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
