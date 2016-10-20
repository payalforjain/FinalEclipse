Problem
===
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Solution
====
Hackish problem, need to use a hash set

1. put all numbers into hashset

2. retrieve one numbre *x* from hashset, and build a list around *x*