Problem
===
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![alt tag](./histogram.png)

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

![alt tag](./histogram_area.png)

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,

	Given height = [2,1,5,6,2,3],
	return 10.

Solution
===
Maintain an increasing stack of indexes

largest rectangle will be one starting at a stack top value, and ends at the last one smaller than the top value