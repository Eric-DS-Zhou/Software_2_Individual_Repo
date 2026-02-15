# Lab: Hashing Experiments

## Objective

In this lab you will learn about hashing in general and hashing Strings in
particular and you will explore how the same hash function can behave quite
differently depending on the distribution of the inputs being hashed.

## Method

1. Take a look at the src and test folders in your new project. Open the
    HashingExploration.java file in the src folder and explore it. In
    particular, take a look at the main method and make sure you understand what
    it does. Discuss it with your partner and, if you are confused, make sure
    you ask an instructor _before_ you continue with the lab.
2. Paste the code you wrote for the homework into the body of the public method
    _mod_, and run the ModTest test fixture in the test folder to test your
    implementation of mod. Fix any bugs exposed by the test cases provided. Do
    not move on to the next step until your implementation of mod passes all
    test cases.
3. Now fill in the body of the private method hashCode that, given a String s,
    computes and returns an integer hash value. For this implementation, **the
    hash value to return must be _the sum of the char values_ in s** . Note that
    in Java the conversion from char to int is automatic and implicit, so you
    can use char values directly in int expressions.
4. Run HashingExploration supplying various hash table sizes (recommended
    range: 15-150) and various input files. Four files of several hundred lines
    of text each, chosen from a dictionary, are provided for your convenience in
    the data folder: random.txt, length8.txt, startend.txt, and mod30.txt. Look
    at these files to see if you can determine what features the various lines
    of text have; it's not necessarily obvious. Among the hash table sizes you
    try, be sure to try size **30** (or any other size in the recommended range
    that is evenly divisible by **2**, **3**, or **5**) with each of the
    provided sets of values.
5. An evil "adversary" has attacked the combination of our hash function and
    table sizes evenly divisible by 2, 3, or 5. Which file came from this
    adversary? Try to lessen the impact of the adversary's scheme by using a
    table size relatively prime to 30; any prime number in the range will do,
    but there are other numbers relatively prime to 30, too. What happened? Do
    you think there would be an advantage to using an actual prime number as
    opposed to a number that is merely relatively prime to 30 or some other
    special number of interest? If not, why not? If so, what's the advantage? A
    "good" hash function should distribute these sets of values approximately
    evenly among the buckets. Observe the results of applying the hash function
    you have implemented for this test. Do you think it's doing a "good" job?
    Could it be improved? Why or why not?
6. Now pick a prime hash table size around 1000. Other than the file created by
    the adversary, one file has what might seem a surprising distribution of
    bucket hits. Which one? Can you explain why the distribution looks like
    this? (If not, remember this situation when you're asking why statistics is
    a CSE/CIS graduation requirement!)
7. Run the program with the input file src/HashingExploration.java (i.e., run
    the program with its own source code as input). What does the program do in
    calculating its results that makes this a reasonable additional test of the
    hash function and table size? (Study the program again if you're not sure.)
    Does this additional test shake your confidence in the "goodness" of the
    hash function? Why or why not?
8. Change the hash function to any other substantively different one. For this
    implementation, **do not use the String hashCode function** because the
    lab's purpose is to see how hashCode would need to be implemented for a new
    class. Repeat steps 4 and 5, trying to find a hash function that works well
    on all four input files. Which hash function do you think is "better" for
    general text values not picked by an adversary, the first one or your
    alternate?
