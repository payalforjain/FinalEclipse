package leetcode.easy.linkedlistPrac;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Scanner;


public class Stack<Item> 
{
	private int size;
	private Node first;
	
	public class Node
	{
	  private Item item;
	  private Node next;
	}
	
	
	public Stack()
	{
		first = null;
		size = 0;
	}
	
	 public boolean isEmpty()
	 {
		 return size ==0;
	 }
	 
	 public int size()
	 {
		 return size;
	 }
	
	 
	 public void push(Item item) 
	 {
		 if(item == null) throw new NullPointerException();
		 Node oldfirst = first;
		 first = new Node();
		 first.item = item;
		 first.next = oldfirst;
		 size++;
		 
		 
	 }
	 
	 public Item pop() {
		 if(size == 0) throw new RuntimeException("Stack Over Flow");
		 Item i = first.item;
		 first =first.next;
		 size--;
		 return i;
		 
	 }
	 
	   public Item peek() {
	        if (isEmpty()) throw new RuntimeException("Stack underflow");
	        return first.item;
	    }

	   
	
	 
	 
	 public String toString() {
		 
		 String dis = "[";
		  for(Node disp=first; disp!=null; disp = disp.next)
		  {
			  
			  dis = dis + " " +  disp.item;
			  
			  
		  }
	     
		  dis = dis + " ]";
		 
		  return dis;
	 }
	 
	 
	 public static Stack<Integer> sortStack(Stack<Integer> input)
	 {
		 Stack<Integer> tempStack = new Stack<Integer>();
		 
		 while(!input.isEmpty())
		 {
			 int temp = (int) input.pop();
			 
			 if(tempStack.isEmpty())
			 {
				 tempStack.push(temp);
				 
			 }
			 
			 else
			 {
				 while(!tempStack.isEmpty() && tempStack.peek() > temp)
				 {
					 input.push(tempStack.pop());
				 }
				 
				 tempStack.push(temp);
			 }
		 }
		 
		 return tempStack;
	 }
	 
	 public static void main(String args[])
	 {
			
	 
	 
	  Stack<Integer> inputStack = new Stack<Integer>();
      inputStack.push(5);
      inputStack.push(4);
      inputStack.push(7);
      inputStack.push(7);
      inputStack.push(6);
      inputStack.push(9);
      inputStack.push(9);
      inputStack.push(1);
      inputStack.push(11);
      Stack<Integer> stack = sortStack(inputStack);
      while (!stack.isEmpty()) {
          System.out.println(stack.pop());
      }
	 
	 }
	 
}