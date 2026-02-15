# Lab: WaitingLine Family Class Implementation

_For this lab you are **required** to work in the same group as you did in the
previous lab. Each group must work on a single CSE department computer so that
you will be able to print and turn in your work at the end of the lab. If you
did not attend the previous lab, your instructor will assign you to a group. If
the person whose account you used during the previous lab is not present, you
must choose another group member to login into one of the lab Windows PCs._

## Objective

In this lab you will implement the classes for the WaitingLine family of
components based on the interface design you did in the previous lab and the
code that you worked on for the homework.

## Method

Please follow the steps outlined below carefully. Your team's goal for this lab
is to come up with a consensus on the implementation of the WaitingLineSecondary
and WaitingLine1 classes, and make sure that they are typed into Eclipse, free
of syntax errors, and documented clearly and precisely. The Additional
Activities will offer you the opportunity to test your implementations.

1. Before you start working on the implementation activity, get your homework
   for today (if you already turned it in, you should get it back from your
   instructor—but do not forget to turn it in at the end of class) and pass it
   to the teammate on your left. Review the teammate's work and make sure you
   note the similarities and differences between your solutions. When everyone
   is ready, pass the homework to your left again, and repeat your analysis.
   Keep doing this until you get back your own homework. At this point, everyone
   on the team should have had a chance to review everyone else's code.
2. As a team, start editing the project. Here are some specific steps:
    1. If you need to make any changes to the WaitingLineKernel and WaitingLine
       interfaces, do this first.
    2. Create a new class in the components.waitingline package in the src
       folder and name it WaitingLineSecondary.
    3. Edit the new class according to the implementation agreed on by your
       entire group. Make sure that all the Javadoc documentation is accurate
       and that the name of each team member is included in a separate @author
       tag in the Javadoc comment for each class (and interface). Talk to an
       instructor if you have any questions.
    4. Create another class in the components.waitingline package in the src
       folder and name it WaitingLine1.
    5. In the new class, implement the WaitingLineKernel methods (including the
       Standard methods). A straightforward implementation can be done by using
       a Queue or a Sequence as the only representation field. A good starting
       point for this is the Queue implementation on Sequence you did for an
       [earlier lab][Earlier Lab]. You can copy the code from that component
       into WaitingLine1 and just edit it to complete this part of the lab. Make
       sure the Javadoc documentation is updated appropriately.
3. When your group has completed the lab, call an instructor to show your work
   and get feedback on your work. You are required to print the
   WaitingLineKernel.java, WaitingLine.java, WaitingLineSecondary.java, and
   WaitingLine1.java files and turn them in to your instructor _before_ you
   leave the lab. Don't forget to turn in your homework as well! You should also
   make sure that each team member has a copy of all the classes and interfaces
   you produced together; emailing them or copying them to a USB flash drive are
   possible ways to share the work.

### Additional Activities

1. Design a JUnit test fixture for the methods defined in your WaitingLineKernel
   and WaitingLine interfaces. As the starting point, you could use the JUnit
   test fixture you were provided with for Queue implemented on Sequence in the
   [Queue Implementation on Sequence][Earlier Lab] lab.
2. Test your implementation of the WaitingLine components.

[Earlier Lab]: https://cse22x1.engineering.osu.edu/2231/web-sw2/extras/instructions/version-control/version-control.html
