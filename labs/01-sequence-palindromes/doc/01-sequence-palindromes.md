# Lab: Sequence Palindromes

## Objective

In this first lab you will review writing a static method by implementing the
isPalindrome method that determines whether a given Sequence<Integer> is a
palindrome.

## Method

1. Take a look at the provided code skeleton and make sure you understand it.
2. Complete the body of the isPalindrome static method. In an effort to channel
    your solutions in the directions we intend, we insist you obey the following
    restriction. While you may use method entry, _do not use_ any _other_ method
    that is _introduced_ in the enhanced interface [Sequence][Sequence API].
    Among the methods still permitted for your use are all those inherited by or
    introduced in [SequenceKernel][SequenceKernel API], including add, remove,
    and length.
3. Run the program and test your implementation of isPalindrome.
4. Once your first implementation works, provide an alternative implementation
    that is recursive if your first implementation was not recursive, or make
    your second implementation not recursive if the first one was recursive.
    You can just comment out the code of your first implementation (select the
    code to comment out and press <kbd>CTRL</kbd> + <kbd>/</kbd>, i.e.,
    the Control key and the '/' key at the same time).
5. Run the program and test your second implementation of isPalindrome.

## Additional Activities

1. Copy SequencePalindrome.java into a new file in the same project and name it
    StackPalindrome.java. Update the code so that it uses the type
    `Stack<Integer>` instead of `Sequence<Integer>` and implement two versions
    (one recursive and one not) of isPalindrome.
2. Copy SequencePalindrome.java into a new file in the same project and name it
    QueuePalindrome.java. Update the code so that it uses the type
    `Queue<Integer>` instead of `Sequence<Integer>` and implement two versions
    (one recursive and one not) of isPalindrome.

[Sequence API]: https://cse22x1.engineering.osu.edu/common/doc/components/sequence/Sequence.html
[SequenceKernel API]: https://cse22x1.engineering.osu.edu/common/doc/components/sequence/SequenceKernel.html
