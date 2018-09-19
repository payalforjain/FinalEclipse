package leetcode.easy.LinkedList;
import java.util.NoSuchElementException;

public class Deque<Item> 
{
    private int N;
	private Node first;
	private Node last;
	private Node current;
	
	
    

	private class Node
	{
		private Item item;
		private Node prev;
        private Node next;
        
	}
	public Deque()
	{
	   first = null;
	   last = null;
	  
	   N = 0;
	}
	
	
	

	public boolean isEmpty()
	{
	   return first == null;
	}
	
	public int size()
	{
	   return N;
	}
	
	/* 1) check first is null
      2) if first and last are not null
	  3) if last is null */
	
  public void addFirst(Item item) {
       if (item == null) throw new NullPointerException();
       Node oldfirst = first;
       first = new Node();
       first.item = item;
       first.prev = null;
       if (oldfirst == null) {
           first.next = null;
       }
       else {
           first.next = oldfirst;
           oldfirst.prev = first;        
       }
       if (last == null) {
           last = first;
       }
       N++;
   }
   // insert the item at the end
   
   /* 1) check last is null
      2) if first and last are not null
	  3) if first is null */
	  
	  
   public void addLast(Item item) {
       if (item == null) throw new NullPointerException("Object to add is NULL!");
       Node oldlast = last;
       last = new Node();
       if (oldlast == null) {
           last.prev = null;
       }
       else { 
           last.prev = oldlast;
           oldlast.next = last;
       }
       last.next = null;
       last.item = item;
       if (first == null) {
           first = last;
       }
       N++;    
   }		
	
   public Item removeFirst() {
       if (first == null) throw new NoSuchElementException();
       Item item = first.item;
       first = first.next;
       if (first != null && first.prev != null) {
           first.prev = null;
       }
       if (first == null) {
           last = null;
       }
       N--;
       return item;
   }
   // delete and return the item at the end
   public Item removeLast() {
       if (last == null) throw new NoSuchElementException();
       Item item = last.item;
       last = last.prev;
       if (last != null && last.next != null){
           last.next = null;
       }
       if (last == null) {
           first = null;
       }
       
       N--;
       return item;
       
       
   }
   
   
   public void squish() // Removing Duplicates in linkedlist very important
   {
	   if (N != 0) 
	   {
		 tool : for (Node node=first; node.next != null; node = node.next) 
		 {
				
				while (node.next != null && node.item.equals(node.next.item)) {
					if (node.next.next != null) { node.next = node.next.next; }
					else { node.next = null; break tool; }
					N--;
			}
		} } }
	
public void twin()
{
	
	Node head = first;
	while ( head !=null) 
	{
		Node new_node = new Node();
		
		
		
		if( head.next!=null)
		{
			
			
			new_node.item = head.item;
			current =head.next;
			head.next = new_node;
			new_node.next = current;
			System.out.println(head.item + "  " + new_node.item + " work in progress");
			
		}

		else
		{
			last.next = new_node;
			new_node.item = last.item;
            last = new_node;
            
		}
	    
	    head = new_node.next;
	    N++;
	}
}
   
 public void displayList() {
     
	  
      String dis = "[";
	  for(Node disp=first; disp!=null; disp = disp.next)
	  {
		  
		  dis = dis + " " +  disp.item;
		  
		  
	  }
     
	  dis = dis + " ]";
	  System.out.println("Values in list are " + dis);
   }
   
	   
	
	public static void main(String[] args)
	{
	    Deque<Integer> d1 = new Deque<Integer>();
		
		d1.addFirst(4);
		d1.addFirst(4);
		d1.addFirst(4);
		d1.addFirst(4);
		d1.addFirst(5);
		d1.addLast(2);
		d1.addLast(1);
		d1.addLast(3);
		d1.addLast(5);
		d1.addLast(2);
		System.out.println("Removed First Item is:" + d1.removeFirst());
		System.out.println("Removed Last Item is:" + d1.removeLast());
		d1.squish();
		d1.twin();
	    d1.displayList();
	    System.out.println("Size is" + d1.size());
	}
	
}


