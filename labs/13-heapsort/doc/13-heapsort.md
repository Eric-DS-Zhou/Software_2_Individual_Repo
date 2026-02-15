# Lab: Heapsort siftDown method

## Objective

In this lab you will implement and test the static method siftDown using the
recursive algorithm discussed in class. This is very similar to the method you
will need for the project to implement SortingMachine with heapsort.

## Method

1. First carefully look through the file ArraySiftDownMain.java to get an idea
   of the overall structure and to see what the main method does. In particular,
   note the two private static methods isHeap and siftDown. Make sure you
   understand their contracts before proceeding with the rest of the lab. Ask
   your instructor if you have any questions.
2. In ArraySiftDownMain.java, complete the body of the siftDown static method
   using the following _recursive_ algorithm briefly outlined in
   [Slides 29-32 of Heap and Heapsort][Slides 29-32 of Heap and Heapsort].

    ```text
    if the size of the tree is greater than 1 then
        compare the root of the tree with the smaller of the two children
          (or with the only child)
        if the root is greater than the smaller child then
            swap the root with the smaller child
            recursively sift down the root of the corresponding subtree
    ```

    Note that the complete binary tree is represented by an int array and the
    ordering used is <=. The exchangeEntries method provided may prove useful to
    swap entries in the array.
3. Run the ArraySiftDownMain test program. You should test your implementation
   of siftDown with a variety of different input sizes including 0 (empty tree)
   and even and odd sizes. Fix any problems you discover.
4. If you are having trouble debugging your implementation of siftDown, try to
   trace your code on the smallest input on which the program fails. Draw
   pictures of the heap as a binary tree and see if you can find the problem.
   You can also modify the main program so that it allows the user to enter the
   values to store in the array instead of generating them randomly.

## Additional Activities

1. Write the body of isHeap so it is iterative rather than recursive.

[Slides 29-32 of Heap and Heapsort]: https://buckeyemailosu-my.sharepoint.com/:b:/g/personal/bucci_2_osu_edu/EYWivNK_4T9EvNrAw9Cd_MYBuwvAY2jC5jm148qO8kFnJA?e=aF2Jb2
