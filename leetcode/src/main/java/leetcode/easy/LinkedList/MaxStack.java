package leetcode.easy.LinkedList;

class MaxStack {

    private Stack<Integer> maxStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();
    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int x = stack.pop();
        if (x == maxStack.peek()) {
            maxStack.pop();
        }

        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    /*
    Complexity Analysis

Time Complexity: O(N)O(N) for the popMax operation, and O(1)O(1) for the other operations, where NN is the number of operations performed.

Space Complexity: O(N)O(N), the maximum size of the stack.
     */

}