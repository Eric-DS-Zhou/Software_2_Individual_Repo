# [Homework 30: BugsWorld Virtual Machine ByteCode Generator and Interpreter][hw30]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 2 @ 4:10 PM EST

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

> Translate the following four BL programs into their executable form
> in the tables next to each example using the code generation "patterns"
> discussed in class (especially slides 30-47). Use only the primitives:
> MOVE, TURNLEFT, TURNRIGHT, INFECT, SKIP, and HALT; unconditional jump:
> JUMP; and the conditional jumps: JUMP_IF_NOT_NEXT_IS_EMPTY,
> JUMP_IF_NOT_NEXT_IS_NOT_EMPTY, etc.) Note that the tables may be bigger
> than the actual length of the generated code.

```bl
PROGRAM Example1 IS
BEGIN
    IF next-is-wall THEN
        turnright
        turnright
        infect
    END IF
END Example1
```

| Loc | Instruction |
| --- | ----------- |
| 0   |             |
| 1   |             |
| 2   |             |
| 3   |             |
| 4   |             |
| 5   |             |
| 6   |             |
| 7   |             |
| 8   |             |
| 9   |             |
| 10  |             |

```bl
PROGRAM Example2 IS
BEGIN
    IF next-is-wall THEN
        turnright
        turnright
        infect
    ELSE
        infect
        move
    END IF
END Example2
```

| Loc | Instruction |
| --- | ----------- |
| 0   |             |
| 1   |             |
| 2   |             |
| 3   |             |
| 4   |             |
| 5   |             |
| 6   |             |
| 7   |             |
| 8   |             |
| 9   |             |
| 10  |             |

```bl
PROGRAM Example3 IS
BEGIN
    WHILE next-is-not-empty DO
        IF next-is-wall THEN
            turnright
            turnright
            infect
        ELSE
            infect
            move
        END IF
    END WHILE
END Example3
```

| Loc | Instruction |
| --- | ----------- |
| 0   |             |
| 1   |             |
| 2   |             |
| 3   |             |
| 4   |             |
| 5   |             |
| 6   |             |
| 7   |             |
| 8   |             |
| 9   |             |
| 10  |             |
| 11  |             |
| 12  |             |
| 13  |             |
| 14  |             |
| 15  |             |

```bl
PROGRAM Example4 IS

    INSTRUCTION TurnBackAndInfect IS
        turnright
        turnright
        IF next-is-enemy THEN
            infect
        END IF
    END TurnBackAndInfect

BEGIN
    WHILE true DO
        TurnBackAndInfect
    END WHILE
END Example4
```

| Loc | Instruction |
| --- | ----------- |
| 0   |             |
| 1   |             |
| 2   |             |
| 3   |             |
| 4   |             |
| 5   |             |
| 6   |             |
| 7   |             |
| 8   |             |
| 9   |             |
| 10  |             |
| 11  |             |
| 12  |             |
| 13  |             |
| 14  |             |
| 15  |             |

### Problem 2

> Complete the body of the following public static method.
> A discussion of the BugsWorld virtual machine and its instruction
> set and of Java enumerated types is in the Code Generation slides.
> Review your code carefully and trace it on some examples.

```java
/**
 * Returns the location of the next primitive instruction to execute in
 * compiled program {@code cp} given what the bug sees {@code wbs} and
 * starting from location {@code pc}.
 *
 * @param cp
 *            the compiled program
 * @param wbs
 *            the {@code CellState} indicating what the bug sees
 * @param pc
 *            the program counter
 * @return the location of the next primitive instruction to execute
 * @requires <pre>
 * [cp is a valid compiled BL program]  and
 * 0 <= pc < cp.length  and
 * [pc is the location of an instruction byte code in cp, that is, pc
 *  cannot be the location of an address]
 * </pre>
 * @ensures <pre>
 * [return the address of the next primitive instruction that
 *  should be executed in program cp given what the bug sees wbs and
 *  starting execution at address pc in program cp]
 * </pre>
 */
public static int nextPrimitiveInstructionAddress(int[] cp, CellState wbs,
        int pc) {...}
```

> In implementing nextPrimitiveInstructionAddress, you will need the
> following enum type and two methods that will be provided for you
> (i.e., you do not need to implement them yourself):

```java
/**
 * BugsWorld possible cell states.
 */
enum CellState {
    EMPTY, WALL, FRIEND, ENEMY;
}
 
/**
 * Returns whether the given integer is the byte code of a BugsWorld virtual
 * machine primitive instruction (MOVE, TURNLEFT, TURNRIGHT, INFECT, SKIP,
 * HALT).
 *
 * @param byteCode
 *            the integer to be checked
 * @return true if {@code byteCode} is the byte code of a primitive
 *         instruction or false otherwise
 * @ensures <pre>
 * isPrimitiveInstructionByteCode =
 *  [true iff byteCode is the byte code of a primitive instruction]
 * </pre>
 */
private static boolean isPrimitiveInstructionByteCode(int byteCode) {...}
 
/**
 * Returns the value of the condition in the given conditional jump
 * {@code condJump} given what the bug sees {@code wbs}. Note that if
 * {@code condJump} is the byte code for the conditional jump
 * JUMP_IF_NOT_condition, the value returned is the value of the "condition"
 * part of the jump instruction.
 *
 * @param wbs
 *            the {@code CellState} indicating what the bug sees
 * @param condJump
 *            the byte code of a conditional jump
 * @return the value of the conditional jump condition
 * @requires [condJump is the byte code of a conditional jump]
 * @ensures <pre>
 * conditionalJumpCondition =
 *  [the value of the condition of condJump given what the bug sees wbs]
 * </pre>
 */
private static boolean conditionalJumpCondition(CellState wbs, int condJump) {...}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw30]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/interpreter.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
