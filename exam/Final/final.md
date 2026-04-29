# Software 2 Final review

## Mutiple choices

1. The job of the implementor and client
    - implementor: make sure the postcondition is ture when method returns.
    - client: make sure the precondition is ture at the moment the method is called.

2. Convention and Correspondance
    - Convention: A constraint on the possible values of the concrete state space.
    - Correspondace: maps values in the concrete state space to values in the abstract state space.
    - More about convention
        - It is a precondition for every public kernel method.
        - It is a postcondition for every public kernel method.
        - It is a postcondition for every constructor.
        - It is `not` a precondition for every constructor.

3. Hash function
    - WHAT: An integer representation of an object.
    - Benefit: Faster and Convenient
    - What is a good hash function:
        - the same result every time for the same key
        - reduce collisions
    - More about hash function
        - Equal objects must always result in the same hash code.
        - The following statement is `False`
            - It must never return the same code for two different objects
                - `False`: It is collisions, collisions are allowed to exist
            - The function must only return positive integer values
                - `False`: Does not have to be postive. Return `int`
            - The function should have a precondition to limit legal inputs
                - `False`: should work for any valid object

4. Smart node
    - Benefit: It eliminates most edge cases.
    - May remove the need to deal with null cases.

5. Abstract class
    - Provide a body for some of the methods inherited from the interfaces it implemented.
    - Provide some shared functionality for a set of subclasses.
    - To factor out shared code for layered methods that can be implemented using only the kernel interface

6. Classes and interfaces
    - Both can include overloaded methods
    - Only classes can include private members
    - Only classes can be instantiated
    - Only classes can include constuctors
    - More about interface
        - It describes what the software does, not how it does it
        - Where we place contracts
        - can contain instance methods and constants
        - cannot contain constructors, static methods and instance variables
        - can only inherit other interfaces

7. Overloading and overriding
    - Overloading means methods have the same name but different parameter lists.
    - Overriding means a subclass provides a new implementation of a method with the same signature.

8. One more question about overloading and overriding

9. Access modifiers
    - Public: The member is accessible from any other class in any package.
    - Protected: The member is accessible within its own package and by subclasses even if they are in different packages.
    - Package: The member is visible only within its own package. It is not accessible to subclasses in different packages.
        - Package is basically a directory of files.
    - Private: The member is accessible only within the class where it is defined. The most restrictive level and is not inherited by subclasses.

10. One more question about access modifiers

11. Error and exceptions
    - Errors and exceptions
        - Errors: Errors are unrecoverable, meaning the program must crash.
        - Exceptions: Exceptions are recoverable, meaning we can keep the program from crashing.
    - Checked and unchecked exceptions
        - Checked exceptions: must be checked with a try-catch or thrown; your code will not complie otherwise.
        - Unchecked exceptions: are not required to be checked.
    - How does try-catch works
        - If an exception happens, Java jumps to the matching catch block.
        - If no exception happens, the catch block is skipped.
    - More about try-catch
        - If an exception is thrown within a try block and none of the associated catch clauses provide a matching exception type, what happens?
            - The exception is thrown to the outer block or the calling method (the client).

12. Declared type and object type
    - Declared type: Left side (static type & compiler type)
    - Object type: Right side (dynamic type & runtime type)

13. ".Equal()" Funcition
    - Check the alias of `this`

        ```java
        if (obj == this) {
            return true;
        }
        ```

    - Check the `null`

        ```java
        if (obj == null) {
            return false;
        }
        ```

        - We won't check that, we know that `this` is not null. We couldn't call this method otherwise.

    - Check whether the same interface

        ```java
        if (!(obj instancOf Queue<?>)) {
            return false;
        }
        ```

    - Check whether the same order as `this`

        ```java
        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = q.iterator();
        while (it1.hasNext()) {
            T x1 = it1.next();
            Object x2 = it2.next();
            if (!x1.equals(x2)) {
                return false;
            }
        }
        return true;
        ```

14. The purpose and nature of constructors
    - A constructor is used to initialize a new object when it is created.
    - It has the same name as the class and has no return type.
    - Constructors are called automatically when using new.

15. Tracing Problem 1 - Predict output
16. Tracing Problem 2 - Predict output
17. Tracing Problem 3 - Whether solution is correct or not
18. Tracing Problem 4 - Whether solution is correct or not
19. Tracing Problem 5 - Whether solution is correct or not
20. Kernel Implement - Identify the issue

## Short answer

### Review HW 30

## Coding Question

### Complier Programming

```java
public static void main(String[] args) {
    SimpleReader in = new SimpleReader1L();
    SimpleWriter out = new SimpleWriter1L();

    out.print("Enter thr inputfilename: " );
    String inputFileName = in.nextLine();
    out.print("Enter the outputfilename: ");
    String outputFileName = in.nextLine();

    try {
        SimpleReader fileIn = new SimpleReader1L(inputFileName);
        SimpleWriter fileOut = new SimpleWriter1L(outputFileName);

        Program p = new Program1();
        p.parse(fileIn);
        Sequence<Integer> code = p.generatedCode();
        for (int x : code) {
            out.println(x);
        }
    } catch (IOException) {
        out.println("Error: " + e.getMessage());
    }

    in.close();
    out.close();
}

```

### Kernel Implementation - Queue on List (Only use left side)

```java

@Override
public void enqueue(T x) {
    this.rep.moveToFinish();
    this.rep.addRightFront(x);
    this.rep.moveToFinish();
}

@Override
public T dequeue() {
    this.rep.moveToStart();
    T x = this.rep.removeRightFront();
    this.rep.moveToFinish();

    return x;
}

@Override
public int length() {
    this.rep.moveToFinish(); //Do we need to do that

    return this.rep.leftLength();
}

@Override
public T front() {
    this.rep.moveToStart();
    T x = this.rep.rightFront();
    this.rep.moveToFinish();
}

@Override
public T replaceFront(T x) {
    this.rep.moveToStart();
    T result = this.rep.replaceRightFront(x);
    this.rep.moveToFinish();

    return result;
}

@Override
public void flip() {
    List<T> temp = this.rep.newInstance();
    this.rep.moveToStart();

    while (this.rep.rightLength() > 0) {
        T x = this.rep.removeRightFront();
        temp.addRightFront(x);
    }

    this.rep.transferFrom(temp);
}

@Override
public void rotate(int distance) {
    if (this.rep.leftLength() > 0) { //Do we need to do that

        while (distance > 0) {
            this.rep.moveToStart();
            T x = this.rep.removeRightFront();

            this.rep.moveToFinish();
            this.rep.addRightFront(x);
            this.rep.moveToFinish();

            distance--;
        }
    }
}

@Override
public void append(Queue<T> q) {
    Queue4<T> temp = (Queue4<T>) q; //assume this is `Queue4`

    while (temp.rep.leftLength() > 0) {
        temp.rep.moveToStart();
        T x = temp.rep.removeRightFront();

        this.rep.moveToFinish();
        this.rep.addRightFront(x);
        this.rep.moveToFinish();
    }
}

```

### Kernel Implementation - Queue on List (Only use right side)

```java
@Override
public void enqueue(T x) {
    this.rep.moveToFinish();
    this.rep.addRightFront(x);
    this.rep.moveToStart(); //（left = 0)
}

@Override
public T dequeue() {
    T x = this.rep.removeRightFront();

    return x;
}

@Override
public int length() {

    return this.rep.rightLength();
}

@Override
public T front() {
    T result = this.rep.removeRightFront();
    this.rep.addRightFront(result);

    return result;
}

@Override
public T replaceFront(T x) {
    T result = this.rep.removeRightFront();
    this.rep.addRightFront(x);

    return result;
}

@Override
public void flip() {
    List<T> temp = this.rep.newInstance();

    while (this.rep.rightLength() > 0) {
        T x = this.rep.removeRightFront();
        temp.addRightFront(x);
    }

    this.rep.transferFrom(temp);
}

@Override
public void rotate(int distance) {
    if (distance < 0) {
        distance = this.rep.rightLength() + distance;
    }

    while (distance > 0) {
        T x = this.rep.removeRightFront();

        this.rep.moveToFinish();
        this.rep.addRightFront(x);
        this.rep.moveToStart();

        distance--;
    }

}

@Override
public void append(Queue<T> q) {
    Queue4<T> temp = (Queue4<T>) q; //assume this is `Queue4`

    while (temp.rep.rightLength() > 0) {
        T x = temp.rep.removeRightFront();

        this.rep.moveToFinish();
        this.rep.addRightFront(x);
        this.rep.moveToStart();
    }
}
```

### Recursive Descent Parsing

```java
public static boolean valueOfBoolExpr(Queue<String> tokens) {
    String token = tokens.dequeue();
    boolean value;

    if (token.equals("T")) {
        value = true;
    } else if (token.equals("F")) {
        value = false;
    } else if (token.equals("NOT")) {
        tokens.dequeue();
        boolean result = valueOfBoolExpr(tokens);
        tokens.dequeue();
        value = !result;
    } else {
        boolean left = valueOfBoolExpr(tokens);
        String op = tokens.dequeue();
        boolean right = valueOfBoolExpr(tokens);

        if (op.equals("AND")) {
            value = left && right;
        } else {
            value = left || right;
        }

        tokens.dequeue();
    }

    return value;
}
```
