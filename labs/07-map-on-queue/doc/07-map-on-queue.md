# Lab: Map Implementation on Queue

## Objective

In this lab you will practice implementing and testing a _kernel_ component,
Map2 implemented on Queue.

## Method

1. Take a look at the src and test folders in your new project. Open the
    Map2.java file in the src folder and explore it. In particular, take a look
    at the private members (the _representation_) at the top of the class and
    the _convention_ and _correspondence_ in the Javadoc comment for the class.
    Remember that the correspondence clause is a mathematical statement that
    describes how a client should interpret the variables in the data
    representation (denoted by `$this` followed by a dot and the name of the
    instance variable) as an abstract value of a `Map` variable (written
    `this`). The convention clause is a mathematical statement that describes
    properties the implementer claims are satisfied by the data representation
    at the end of every method call, including the constructor(s); it therefore
    mentions only the data representation, `$this`, and not the abstract value
    as seen by the client, `this`. (Note that the notation `$this` never appears
    in Java code, but only in Javadoc comments like this that describe aspects
    of the data representation!)
2. Paste the code you wrote for the homework into the body of the private
    method moveToFront, and complete the body of the kernel methods (add,
    remove, removeAny, value, hasKey, and size) in Map2 in the src folder.

    If you need to construct a Pair object in your code, just use the only
    available implementation of the Map.Pair interface called
    `MapSecondary.SimplePair<K, V>`. Inside the Map2 class, you will be able to
    declare and initialize a Pair variable with a statement like this:

    ```java
    Pair<K, V> p = new SimplePair<>(key, value);
    ```

    where _key_ and _value_ are some variables of type K and V, respectively.
3. Paste the test cases you designed for the homework at the end of the MapTest
    class in the test folder.
4. Run Map2Test in the test folder to test your implementation of Map2. Fix any
    bugs that you discover and/or add extra test cases, if you realize that you
    are missing some important cases.

## Additional Activities

1. Take a look at the Standard methods (newInstance, clear, and transferFrom)
    in Map2. We will discuss the details of these implementations later in the
    semester, but for now, design test cases to test these methods and add the
    test cases to your test fixture, MapTest.
