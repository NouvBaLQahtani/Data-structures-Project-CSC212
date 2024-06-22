# Maze Escape

This project is part of the Data structures course under my bachelor's degree in software engineering

It is a Java implementation of a binary tree-based maze solver. The goal is to provide hands-on experience with handling data structures in the context of a maze escape problem.

## Problem Definition

A player wants to escape a maze where at most two options are available at each step: go straight or turn. The maze can be represented by a binary tree, where the data in each node can take one of four values:

- `'B'`: Beginning (only at the root)
- `'S'`: Go straight
- `'T'`: Turn
- `'X'`: Exit

Exits are located at leaf nodes, but not all leaf nodes are exits - some may be dead ends. Each node has a unique key of type `int`.

## Project tasks

In the first phase of the project, the following tasks are to be completed:

1. Implement the Binary Tree data structure in Java with the following methods:
   a. `private boolean follow(MNode<T> t, String path)`: Checks if the given path starting from node `t` is valid. A path is valid if its directions are available (not necessarily leading to an exit).
   b. `private boolean escape(MNode<T> t)`: Searches for an exit starting from node `t` using preorder traversal and returns `true` if an exit is found.
   c. `private String short()`: Returns the shortest path to an exit starting from the root.

2. Provide the time complexity (worst case analysis) of the three methods using Big O notation, showing the steps followed when calculating the growth rate function.

In the second phase of the project, the following tasks are to be completed:
1. Review and Critique other group's code and provide 2-3 key critiques

2. Provide the Time Complexity Analysis for the three methods of the other group's code 


3. Demonstration

we conducted a presentation to briefly summarize our time complexity analysis, Discussed the key challenges we encountered and Highlighted the main lessons learned.


## Time Complexity Analysis

The time complexity analysis is provided in the project report. 

## Contact

If you have any questions, feedback, or inquiries regarding this project, please feel free to reach out to me through my Email: NouvAlqahtani@gmail.com .
