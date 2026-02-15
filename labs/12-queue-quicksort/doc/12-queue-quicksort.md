# Lab: Queue Quicksort

## Objective

In this lab you will implement and test the Queue sort secondary method using
the quicksort algorithm. You will also familiarize yourself with an
implementation of the SortingMachine kernel using the same implementations of
sort and partition.

## Method

1. First carefully look through the file QueueSortMain.java, which is a test
   driver for a `Queue1LSort4<T>` extension for `Queue1L<T>`, to get an idea of
   the overall structure and to see what the main method does. (Except for using
   `Queue1LSort4<T>` instead of `Queue1LSort3<T>`, this is the same main program
   you used in the previous lab.) In particular, note the declaration of the
   StringLT _nested_ class that provides an implementation for the
   `Comparator<String>` interface using the
   [lexicographic order][Lexicographic Order] for Strings, and its use in the
   main method.
2. In Queue1LSort4.java, complete the body of the partition static method and
   the body of the sort instance method with the code you wrote for your
   homework.
3. Run the QueueSortMain test program. You can use the lines.txt file in the
   data folder in your project as a test input. Fix any problems you discover.
4. Once you are confident that your implementation of quicksort works, open the
   SortingMachine4.java file. This is a skeleton for an implementation of
   SortingMachine kernel. Look through the file carefully and follow these
   steps.
    - In the "Private members" section, note the representation which includes
      three instance variables (or fields): a **boolean** insertionMode to keep
      track of the machine mode (insertion or extraction), a `Comparator<T>`
      machineOrder that records the ordering used to sort, and a `Queue<T>`
      entries to keep track of the entries in the machine. (These are the same
      fields that were used in SortingMachine3 in the previous lab.)
    - Find the createNewRep method and note how it initializes the
      representation fields. (Same as SortingMachine3.)
    - Fill in the body of the private methods partition and sort by copying and
      pasting your code from the previous part of the lab. Here the code for
      sort is slightly different from what you wrote on the homework and used in
      the earlier part of the lab, because the sort method is a _static_ (not an
      _instance_) method, and the queue being sorted is called _q_, not _this_.
      _Make sure you update the recursive calls to call the static method sort,
      otherwise your code will compile but instead of sort being recursive it
      will call the Queue sort secondary method._
    - In preparation for filling in the bodies of the six kernel methods,
      contrast this representation invariant (found in the @convention tag) with
      the one in SortingMachine3 in Eclipse project QueueInsertionSort.
      (SortingMachine3's representation invariant is also available
      [here][SortingMachine3].)
    - Find the "Kernel methods" section and fill in the bodies of the six kernel
      methods. _Each of these methods can be implemented with a single line of
      code except for one that will require two lines of code._
5. Back in the QueueSortMain test program, update the main program so that it
   sorts the input from the file using your SortingMachine4 implementation.
   This requires just a few changes that you should have already experienced in
   the previous lab. If you are not sure, you should look at
   [Slides 49-50 in SortingMachine][Slides 49-50 in SortingMachine]. Run your
   program again and make sure the output is correct. If not, find the bug(s)
   and fix them.

## Additional Activities

1. In the test folder, open SortingMachineTest.java and carefully review the
   code provided. In particular, note the StringLT implementation of
   `Comparator<String>`, the variable ORDER, and how it is used in the two
   sample test cases provided. Add test cases to test the kernel methods of
   SortingMachine. Run your JUnit test fixture and fix any problems that come
   up. Note that if you already developed a test plan for SortingMachine for
   the **Additional Activities** of the previous lab, you can just copy and
   paste the SortingMachineTest.java file from the QueueInsertionSort project
   into this lab's project.

[Lexicographic Order]: https://en.wikipedia.org/wiki/Lexicographic_order
[SortingMachine3]: https://cse22x1.engineering.osu.edu/common/doc/components/sortingmachine/SortingMachine3.html
[Slides 49-50 in SortingMachine]: https://buckeyemailosu-my.sharepoint.com/:b:/g/personal/bucci_2_osu_edu/Easvl_O40AVLljzJDvcU9hwBzHvZxGFdJod3uJi4-QpNrw?e=xVpiRk
