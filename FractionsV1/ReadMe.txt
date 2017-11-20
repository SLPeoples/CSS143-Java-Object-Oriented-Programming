Summary
In this assignment, you will build a program using techniques from previous CSS courses that counts unique fractions. No new constructs from our readings are expected, and as such, you can complete this program with just a handful of lines (10–20) of code in just one main function. You will need to use loops, ifs, comments, etc., (in other words, structured programming) to complete this assignment and achieve the outcomes listed below. Included below is a sample execution of your program as well as a list of outcomes your program is to implement; notice reduction of fractions is optional in this version of the assignment.

Introduction
Your project is to read in a series of fractions from a text file, which will have each line formatted as follows: “A/B”.  A sample text file is listed below, and the purpose of your program is to read in each fraction and count the number of occurrences for the current fraction.  When all the input is consumed (or as the input is consumed), your program will print out its list of unique fraction and their corresponding count — see the output below (and you may assume no blank lines or misleading characters; see the text file link on the website for one of the actual inputs I’ll use when testing your submission).

Sample Input File
fractions.txtPreview the documentView in a new window 

Sample Text Input

6/3

7/3

6/3

12/6

Sample Console Output

6/3 has a count of 3

7/3 has a count of 1

Questions
Answer the following questions using multi-line comments in your code:

Can you complete this without using arrays? What is the least number of variables you can use to solve this problem?
Can you use just one array to solve this? What would the data type be of that array?
Can you nest* one class (data type) within another, like we observe with nested loops? What is an example of this? (*compose)
What are some solutions to the reduction problem other than Euclid's GCD (greatest common divisor) algorithm? (You may want to look up GCD online.)
Notes
Name your Java file LastFirst_FractionsV1.java, where you put in your own last name and first name for “Last” and “First”. You must name your file this way. (This means your class needs to be named the same as the part before the ".java".)
You should upload only a single file, your Java source code file.
Follow the Coding Style Guidelines!
Be sure to put code that gets lengthy into its own method!
This assignment is particularly detailed in its guidance in terms of outcomes; expect future assignments to test your ability to build your own programming contract for the problem at hand.
Test your code as you add features (either methods or variables) incrementally, making sure your small change works as you envisioned it to.
Try to keep in mind basic “structured programming” principles such as modular design (ie, decompose complex tasks into individual methods), good variable & methods names (self-documenting code), and comments.
NB:  By "unique fraction" I do not mean "unique string value" but "unique rational number value."
Consider reading one line at a time (with scanner.nextLine()), and using the split (Links to an external site.)Links to an external site. function (defined in class String) to give you an array with two elements in it (the numerator and denominator, respectively).
Your program should work with input files besides the sample given, even long files (e.g., 100,000 lines long).
Don’t wait till the last minute to get help from the instructor or our QSC tutors!
About This Document
Original assignment by Rob Nash, Autumn 2014. Minor edits and additions by Johnny Lin, March 2015.