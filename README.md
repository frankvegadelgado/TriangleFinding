# Triangle Finding 
**Problem Statement**

Given an undirected graph G=(V, E), the problem **Triangle Finding** consists in determining whether there exist three vertices a, b and c in V such that {a, b}, {b, c} and {c, a} are edges in E.   
 
# Open Problem 
 
Triangle Finding can be solved in time O(n^w) where n = |V| and w < 2.373 denotes the matrix multiplication constant. However, it is currently unknown if Triangle Finding can be solved in time O(n^2). 

# Overview

Algorithms such as finding the maximum into an array of integers assumes the operation of comparisons between two numbers take constant time. That's why, we can affirm the running time of finding maximum is O(n) where n would be the array length.

Operations such as the Binary AND Operation might be more complex than the comparison operations, but if we assume that we can do this operation in constant time, then Triangle Finding can be solved in time O(n^2).

# Our Algorithm

**Informal Explanation:**

Given an undirected graph of n vertices represented by Boolean adjacency matrix, this should be a valid adjacency matrix for an undirected graph: for the symmetry(equals to its transpose) and the main diagonal is filled only with zeroes. 

First, fill the main diagonal with ones. 

Next, set to zero all the one values in the entries of the matrix which are above of the main diagonal. 

If we find a rectangle whose corners are 1's in the final modified matrix such that one of the corners is an entry of the main diagonal, then there must be a triangle in the undirected graph input.

Otherwise, there is no possible triangle in the undirected graph input.

# Programming Techniques

We use the Binary AND Operation between two integers and a fast exponentiation algorithm with the base 2 for finding the rectangle whose corners are 1's such that one of the corners is an entry of the main diagonal.

# Constraints

The Binary AND Operation under primitive types can be used in many languages for at most integers of size 64 bits. In this way, we cannot  efficiently (it is not practical in many languages) solve all the matrices with dimensions greater than 63. In addition, for the dimension 63 or lower, the naive algorithm behaves better since this does not have to do hard math computational calculations such as the exponentiation operation.

# Runtime

This takes O(n^2) time assuming the Binary AND operation might be done in constant time and the fast exponentiation algorithm of 2^m can be solved in time O(m).

# Code

- Java code by Frank Vega just using as background theory the project [MichaelWehar/BooleanMatrixRectangleProblem](https://github.com/MichaelWehar/BooleanMatrixRectangleProblem).

# License
- MIT.


