package datastructure;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;



import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Queue<Item> 
{
	
	private int size =0;
	
	private Node First;
	private Node Last;
	
	public class Node
	{
		public Node next;
		public Item item; 
	}
	
	
	
public Queue()
{
	First = null;
	Last = null;
	size = 0;
}

public boolean isEmpty() {
    return First == null;
}


public int size() {
    return size;     
}

public void enqueue(Item item)
{
	if(item ==null) throw new NullPointerException(" Null Pointer Exception");
	
	Node oldlast = Last;
	Last = new Node();
	Last.item = item;
	Last.next = null;
	if(isEmpty())
		First = Last;
	else
	   oldlast.next = Last;
	
	size++;
	
}	

public Item dequeue()
{
	 if(isEmpty()) throw new RuntimeException("Stack Over Flow");
	 Item i = First.item;
	 First =First.next;
	 
	 if(isEmpty())
		 Last = null;
	 
	 size -- ;
	
	 return i;
}

public void middlelinkedlist() //how to find the middle of a linkedlist.
{
	Node current = First;
    int length = 0;
    Node middle = First;
  
    while(current.next != null){
        length++;
        if(length%2 ==0){
            middle = middle.next;
        }
        current = current.next;
    }
  
    if(length%2 == 1){
        middle = middle.next;
    }

   
    System.out.println("middle element of LinkedList : " + middle.item);


}



// you can reverse using stack to. Just similar to reversing a list or String


public boolean isCyclic() //1)	Loops in a singly linked list 
{ 
	Node fast = First; 
	Node slow = First; 
	while(fast!= null && fast.next != null)
	{ 
		fast = fast.next.next; 
		slow = slow.next; //if fast and slow pointers are meeting then LinkedList is cyclic 
		if(fast == slow )
		{ 
			return true; 
		} 
	} 
	return false; 
}

public Item nfromlast(int n)
{
    int i;
    Node current = First;
    for (i=0;i<n;i++)
    {
        if(current != null)
        {
            current = current.next;
        }
        else
        {
            return null;
        }
    }
    Node behind = First;
    while (current != null)
    {
        current = current.next;
        behind = behind.next;
    }
    return behind.item;
}

public void recursiveReverse()
{
	recursiveReverse(First);
}

private void recursiveReverse(Node curr) {
    if(isEmpty()) { return;}     //curr == null
    if(curr.next == null) {
        First = curr;
        return;
    }
    reverse(curr.next);
    curr.next.next = curr;
    curr.next = null;
}



public void reverse() // Iterative. This is wrong. keep it as refernce
{
	reverse(First);
}

public Node reverse(Node Node) {
    Node previous = null;
    while (Node != null) {
        Node next = Node.next;
        Node.next = previous;
        previous = Node;
        Node = next;
    }
    return previous;
}


public String toString() {
	 
	 String dis = "[";
	  for(Node disp=First; disp!=null; disp = disp.next)
	  {
		  
		  dis = dis + " " +  disp.item;
		  
		  
	  }
    
	  dis = dis + " ]";
	 
	  return dis;
}





public static void main(String args[])
{
	Queue<String> a = new Queue<String>();
	
	
	String d = args[0];
	
	try
	{
		
		String f = args[0];
	File inFile = new File (f);

    Scanner sc = new Scanner (inFile);
    String line = "";
    
    
    while(sc.hasNext())
	{
	  
    	line = sc.next();
    	if(!line.equals("-"))
    	{
    		a.enqueue(line);
    	}
    	
    	else
    	{
    		a.dequeue();
    	}
	}	
	}
catch(Exception e)
{
	System.out.println(e);
}
    
    System.out.println(" size is :" +  a.size());
    System.out.println(a.toString());
    /*a.middlelinkedlist();
    a.recursiveReverse();
    System.out.println("recursive" +a.toString());
    a.iterativeReverse();*/
  
    System.out.println(a.isCyclic());
    System.out.println(a.nfromlast(1));
	}

	



}