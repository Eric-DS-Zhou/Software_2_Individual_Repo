# [Homework 25: Program and Statement renameInstruction][hw25]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Mar 25 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 90 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

The following problems will give you practice with statements and recursion.

### Problem 1

> Using recursion, complete the body of the following static method.

```java
/**
 * Refactors the given {@code Statement} by renaming every occurrence of
 * instruction {@code oldName} to {@code newName}. Every other statement is
 * left unmodified.
 *
 * @param s
 *            the {@code Statement}
 * @param oldName
 *            the name of the instruction to be renamed
 * @param newName
 *            the new name of the renamed instruction
 * @updates s
 * @requires [newName is a valid IDENTIFIER]
 * @ensures <pre>
 * s = [#s refactored so that every occurrence of instruction oldName
 *   is replaced by newName]
 * </pre>
 */
public static void renameInstruction(Statement s, String oldName,
        String newName) {
    switch (s.kind()) {
        case BLOCK: {
            int length = s.lengthOfBlock();

            for (int i = 0; i < length; i++) {
                Statement child = s.removeFromBlock(i);
                renameInstruction(child, oldName, newName);
                s.addToBlock(i, child);
            }

            break;
        }

        case IF: {
            Statement body = s.newInstance();
            Condition c = s.disassembleIf(body);

            renameInstruction(body, oldName, newName);
            s.assembleIf(c, body);

            break;
        }

        case IF_ELSE: {
            Statement thenPart = s.newInstance();
            Statement elsePart = s.newInstance();
            Condition c = s.disassembleIfElse(thenPart, elsePart);

            renameInstruction(thenPart, oldName, newName);
            renameInstruction(elsePart, oldName, newName);
            s.assembleIfElse(c, thenPart, elsePart);

            break;
        }

        case WHILE: {
            Statement body = s.newInstance();
            Condition c = s.disassembleWhile(body);

            renameInstruction(body, oldName, newName);
            s.assembleWhile(c, body);

            break;
        }

        case CALL: {
            String callName = s.disassembleCall();

            if(callName.equals(oldName)) {
                s.assembleCall(newName);
            } else {
                s.assembleCall(callName);
            }

            break;
        }
    }
}
```

### Problem 2

> Using the method above, complete the body of the following static method.

```java
/**
 * Refactors the given {@code Program} by renaming instruction
 * {@code oldName}, and every call to it, to {@code newName}. Everything
 * else is left unmodified.
 *
 * @param p
 *            the {@code Program}
 * @param oldName
 *            the name of the instruction to be renamed
 * @param newName
 *            the new name of the renamed instruction
 * @updates p
 * @requires <pre>
 * oldName is in DOMAIN(p.context)  and
 * [newName is a valid IDENTIFIER]  and
 * newName is not in DOMAIN(p.context)
 * </pre>
 * @ensures <pre>
 * p = [#p refactored so that instruction oldName and every call
 *   to it are replaced by newName]
 * </pre>
 */
public static void renameInstruction(Program p, String oldName,
        String newName) {
    Statement body = p.newBody();
    Map<String, Statement> context = p.newContext();
    Map<String, Statement> newContext = p.newContext();
    p.swapBody(body);
    p.swapContext(context);

    renameInstruction(body, oldName, newName);

    while(context.size() > 0) {
        Map.Pair<String, Statement> entry = context.removeAny();
        String name = entry.key();
        Statement instructionBody = entry.value();

        renameInstruction(instructionBody, oldName, newName);

        if(name.equals(oldName)) {
            newContext.add(newName, instructionBody);
        } else {
            newContext.add(name, instructionBody);
        }
    }

    p.swapBody(body);
    p.swapContext(newContext);
}
```

### Problem 3

> You may hand-draw your answer to this question. Recalling how much
> we care that you use correct punctuation when you write objects' values,
> and using the notation of slides 9 through 12 from Program, but fully
> drawing each abstract syntax tree involved, show the value of p at the
> end of the following code snippet.

```java
Program p = new Program1();
Map<String, Statement> context = p.newContext();
Statement block = p.newBody();
Statement s = block.newInstance();
p.setName("Get-to-Edge-and-Wait-for-Infection");
s.assembleCall("walk");
block.addToBlock(0, s);
s.assembleCall("run");
block.addToBlock(block.lengthOfBlock(), s);
s.assembleWhile(Condition.NEXT_IS_NOT_WALL, block);
block.addToBlock(0, s);
p.swapBody(block);
s.assembleCall("move");
block.addToBlock(0, s);
s.assembleCall("move");
block.addToBlock(block.lengthOfBlock(), s);
context.add("run", block);
s.assembleCall("move");
block = block.newInstance();
block.addToBlock(0, s);
context.add("walk", block);
p.swapContext(context);
```

![Problem 3](Problem3.png)

### Problem 4

> Consider the occurrence on line 19 of the code snippet above of
> block = block.newInstance(). What would probably have happened if
> that statement had been replaced by block.clear()? In other words,
> what is the difference between the two statements? You may hand-draw
> a diagram to show the difference. (Hint: which are the only two lines
> in the code snippet in which the statement executed would introduce
> an alias to a mutable object? (Hint: all contracts in our components
> catalog advertise every introduction of an alias to a mutable object.))

![Problem 4](Problem4.png)

Reason: If line 19 were replaced by block.clear(), then the block already added to context under "run" would be cleared because of aliasing.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw25]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/program-statement.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
