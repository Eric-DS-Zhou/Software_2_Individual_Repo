# Lab: WaitingLine Family Interface Design

_For this lab you are **required** to work in a group of 4-6 members. Your
instructor will tell you how to form the groups. Each group must work on a
single CSE department computer so that you will be able to print and turn in
your work at the end of the lab._

## Objective

In this lab you will refine the design of the interfaces for the WaitingLine
family of components that you worked on for the homework.

## Method

Please follow the steps outlined below carefully. Your team's goal for this lab
is to come up with a consensus on the design of the WaitingLineKernel and
WaitingLine interfaces, and make sure that they are typed into Eclipse, free of
syntax errors, and documented clearly and precisely.

1. Before you start working on the design activity, get your homework for today
   (if you already turned it in, you should get it back from your instructor—but
   do not forget to turn it in at the end of class) and pass it to the teammate
   on your left. Review the teammate's design and make sure you note the
   similarities and differences between your solutions. When everyone is ready,
   pass the homework to your left again, and repeat your analysis. Keep doing
   this until you get back your own homework. At this point, everyone on the
   team should have had a chance to review everyone else's design.
2. As a team, start editing the project provided. Here are some specific steps:
    1. Explore the given project's src folder. It contains a package called
       components.queue, which, in turn, contains the QueueKernel and Queue
       interfaces.
    2. Create a new package. ~~In the **Package Explorer** view, right-click on
       the src folder, and select **New > Package**. Then enter
       components.waitingline in the **Name** field and click on **Finish**.~~
    3. In the components.waitingline package, create the interfaces
       WaitingLineKernel and WaitingLine. One way to do it is to copy the
       QueueKernel and Queue interfaces one at a time from the components.queue
       package and paste them into the components.waitingline package while
       renaming them appropriately.
    4. Edit the new interfaces appropriately to reflect your design. This is the
       main part of the lab and you should make sure to include every teammate
       in the discussion and try to come up with the best design you can. Pay
       attention to the details including the choice of names for methods and
       parameters, and the model and contracts for your new components. Make
       sure the name of each team member is included in a separate @author tag
       in the Javadoc comment for each interface. Talk to an instructor if you
       have any questions.
3. When your group has completed the design, call an instructor to show your
   work and get feedback on your design. You are required to print the
   WaitingLineKernel.java and WaitingLine.java files and turn them in to your
   instructor _before_ you leave the lab. ~~To print from Eclipse, select
   **File > Print...** from the toolbar with the file you want to print
   currently open and visible in the editor. Choose a printer near you (e.g.,
   if you are in DL 280, you can use the printer in DL 272 called lj\_dl\_272)
   and click on **Print**. Pick up your printout and turn it in.~~ Don't forget
   to turn in your homework as well! You should also make sure that each team
   member has a copy of the two interfaces you designed together; emailing them
   or copying them to a USB flash drive are possible ways to share the work.
