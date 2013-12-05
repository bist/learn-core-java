# Learn Core Java

## Overview

This course is an internal course given in November 2013 for BIST developers. Course is divided into 10 half-day program. BEWARE! Each day you will be **pushed to your limits** to understand the dynamics of the language.

After each session, you'll be given a homework and these homeworks will be scored (On a scale of **1 to 100**).

End of the course, you'll also be given a test and an assignment to score your skills. 20% of your homeworks, 30% of your test score and 50% of your final assignment will give you the final score.  Anyone below **70 overall will not be certified**!

## How to Use

First thing you need to do is to create a file called `AUTHOR`, you can do this by using your favorite editor. File has to contain your name like below:

    John Doe

Keep in mind that this repo **is not** designed for **checking in** your personal files. So bare with the instructors until the last day to check in. The repo contains branches with day/session names. Any session that you want to work on, just type the branch name with topic like below:

    git checkout -t origin/day1-hello

This will create a local branch of the remote branch specified in the command. To see all available sessions, type:

    git branch -a

After checking out the branch you want to work on like above, anytime you want to work on the branch again, you can just use the local branch like:

    git checkout day1-hello

And now you can focus on the files introduced only in this session. Once you are ready to work on the homeworks, go to the master branch and do your magic there:

    git checkout master

When the course is over, you can get the score of your homeworks by typing:

    git add -A .
    git commit -m 'Finished homeworks'
    git push origin master

Please keep in mind that this score will only contribute 20% to the final score. Your final test and the final exam will be done in the last day. These are scored separately.

## Course Schedule

### Day 1

* Introduction
* Introducing the Java 5-7 platform, JDK, JRE
* Introducing the Java language
* Know your IDE – IntelliJ, Eclipse and Netbeans
* Java syntax and class review, and a `Hello World` program
* **Day 1 Homework**

### Day 2

* Working with primitive types and wrapper types
* Using operators and decision constructs
* Creating and using arrays
* Using loop constructs
* **Day 2 Homework**

### Day 3

* Thinking in objects
* Working with objects
* Encapsulation, information hiding and polymorphism
* **Day 3 Homework**

### Day 4

* Inheritance with Java interfaces
* Java class design
* Advanced class design
* **Day 4 Homework**

### Day 5

* Working with methods, overriding and overloading
* String processing
* Generics and collections
* **Day 5 Homework**

### Day 6

* Handling Errors
* I/O Fundamentals
* File I/O with NIO2
* **Day 6 Homework**

### Day 7

* Threading
* Concurrency
* **Day 7 Homework**

### Day 8

* Database connectivity
* JDBC
* Networking
* **Day 8 Homework**

### Day 9

* Java 7/8 Enhancements
* Collective workshop
* **Day 9 Homework**

### Day 10

* **Final Exam**
