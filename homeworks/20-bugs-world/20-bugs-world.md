# [Homework 20: BugsWorld][hw20]

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) -->

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 90 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Background

> In preparation for the lab, you will design your own bug
> species for the BugsWorld contest that will take place during
> the lab. This document gives you a brief introduction to the
> applications involved and how to set up and run a simulation.
> Before the lab you will need to familiarize yourself with all
> the tools and, most important, write your own BL program to
> create the invincible bug. A compiler is provided so that you
> can fix any syntax errors in your BL program before the lab.
> You will also be able to run simulations to test the behavior
> and strength of your bugs.

### The Server

> To run a simulation, the first thing you want to do is start up the server
> application. This is done locally with the following command (assuming you
> have a copy of the BWServer.jar in the lib folder):
>
>       ./lib/BWServer.jar
>
> If the command above does not work, there is a slightly messier command that
> should work (note: the following command will lock up the current terminal,
> so you will need to open another terminal for the client):
>
>       java -jar lib/BWServer.jar
>
> Running the server is pretty straightforward. Here are the
> steps:
>
> 1. **Click New Game**: this should create a game grid to the left of the button
>    you just pressed. If you do not see a gride, try resizing the window. Also,
>    starting a new game will give you a port number. You will need to know both
>    hostname and the port number to connect as a client.
> 2. **Click Open Game**: this will allow clients to connect to the server.
>    Only click this when you are ready to accept connections. When the correct
>    number of clients have connected, continue to the next step.
> 3. **Click Close Game**: this will stop other clients from being able to
>    connect. If you clicked this too soon, you can always reopen the game
>    for connections.
> 4. **Click Start Game**: this begins the simulation. Assuming you can see the
>    game grid, the bugs should start moving around. You can keep track of the
>    progress of the simulation by watching the species bar chart.
> 5. **Click End Game**: this kills the grid and the current game, so a new one
>    can be launched.

### The Client

> Once the server is up and running, and you know the machine name and
> the port number, you can start the clients. This is done locally with the
> following command (assuming you have a copy of the BWServer.jar in the lib
> folder):
>
>       ./lib/BWClient.jar
>
> Again, if this command does not work, try the following command with the same
> caveats as above:
>
>       java -jar lib/BWClient.jar
>
> To connect to the server with your program, use the following steps:
>
> 1. **Click Load Program**: this will open up a file explorer. Use it to locate
>    your bugslang program. If the program is correct, it will compile the
>    program for you.
> 2. **Fill Out Hostname and Port**: using the server program, you should be
>    able to find the hostname and port number. Copy these over into the client.
> 3. **Click Connect to Server**: assuming the server is open to connection,
>    click "connect to server" will load your bug into the server interface.
>
> At this point, you can go back to the server application and click
> "Close Game." Whatever you do, **DO NOT** spam the "Connect to Server"
> button. Even if the application appears frozen, it is working. Clicking the
> button multiple times, may load your bug into the server multiple times.

## Problems

Drop your code below to receive credit for this assignment.
Make sure to delete the sample code or use it as the
basis for your own code.

```generic
PROGRAM TryToGuess IS
    INSTRUCTION FindObstacle IS
        WHILE next-is-empty DO
            move
        END WHILE
    END FindObstacle
BEGIN
    WHILE true DO
        FindObstacle
        IF next-is-enemy THEN
            infect
        ELSE
            IF next-is-wall THEN
                turnleft
            ELSE
                skip
            END IF
        END IF
    END WHILE
END TryToGuess
```

## Additional Lab Preparation

<!-- TODO: please read this before the lab -->
**TL;DR**: download and install Ivanti, FileZilla, and FastX as described
[here][coelinux]. Read on for more detailed instructions.

Once you are satisfied with your bug, you will need to do a few things to be
ready for the lab. First, if you have not already, you will need to download,
install, and setup **Ivanti VPN**, as described [here][ivanti].

Next, you will need to transfer your program from your computer to the OSU
server. This is unfortunately a nontrivial process. The recommendation is to
use **FileZilla**. I personally use WinSCP on windows, but there are probably
dozens of tools to help you do this. For example, there are directions in the
TL;DR link above which suggest emailing the file to yourself. There are also
command line tools, so just use whatever is most comfortable to you.

Once you have moved your file over, you will need to launch **FastX**. Again,
the directions for installing and running FastX can be found in the first link
in this section. Then, from within the FastX GUI, launch the client with the
following command:

        java -jar /share/CSE/class/software/2231/BWClient.jar

This is the same application you used to connect your client before, so there
should be no surprises. Use it the same way you did before to connect in lab.

Lastly, **DO NOT** follow the command line directions from the course website
that asks you to run the client, server, and display programs from the command
line. These programs are not compatible with the jars and will cause problems.

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw20]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/bugs-world.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[ivanti]: https://ets.osu.edu/ets-wiki
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[coelinux]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/linux.html
