package leetcode.easy.linkedlistPrac;


public class CList <Item> 
{
	protected Node head;
	protected int size;
	
    public class Node
    {
    	public Item item;
    	public Node prev;
    	public Node next;
        
    	Node (Item i, Node p, Node n)
    	{
    		item = i;
    	    prev = p;
    	    next = n;
    		
    	}
    }

 
    
    
    public CList() 
    {
        size = 0 ;
        head = new Node(null,null,null);
        head.next = head;
        head.prev = head;
    }
    
    public boolean isEmpty() {
        return size == 0;
      }

 
      public int length() {
        return size;
      }
    
      public void insertFront(Item item) 
      {
    	   Node n = new Node(item,head,head.next);
    	   
    	   
    	   head.next.prev = n;
    	   head.next = n;
    	   
    	   size++;
      }
      
      public void insertBack(Item item) 
      {
    	  Node n = new Node(item,head.prev,head);
    	 
    	  head.prev.next = n;
    	  head.prev = n;
    	  size++;
    	  
    	     //System.out.println("inserted item is" + n.item);
      }
      
      public Node front()
      {
    	  if(size == 0)
    	  {
    		  return null;
    	  }
    	  
    	  else
    	  {
    		  //System.out.println( "front item is" + head.next.item);
    		  return head.next;
    	  }
      }
      
      public Node back()
      {
    	  if(size == 0)
    	  {
    		  return null;
    	  }
    	  
    	  else
    	  {
    		  //System.out.println( "back item is" + head.prev.item);
    		  return head.prev;
    	  }
      }
     
 
  	public Node next(Node node) 
  	{
  	   if(node==null || head.prev == node)
  	   {
  		 //System.out.println("Node next is null");
  		   return null;
  	   }
  	   
  	   //System.out.println("Node next is " + node.next.item);
  	   return node.next;
  	}
      
  	
  
    public Node prev(Node node) {
    	if(node==null || head.next == node)
    	  {
     		 //System.out.println("Node prev is null");
     		   return null;
     	   }
     	   
     	  // System.out.println("Node prev is " + node.prev.item);
     	   return node.prev;
     	}
 
    public void insertAfter(Item item, Node node) 
    {
    	
       if(node!=null)
       {
       Node n = new Node(item,node,node.next);
   	   
   	   node.next.prev = n;
   	   node.next = n;
       System.out.println("inserted after is" + n.item);
   	   size++;
       }
       
    }
    
    public void insertBefore(Item item,Node node) 
    {
        
    	if(node!=null)
        {
    		Node n = new Node(item,head.prev,head);
       	     node.prev.next = n;
       	     node.prev = n;
       	     size++;	
        }
    }
    
    public void remove(Node node) 
    {
       
       if(node!=null)
       {
    	   
    	   node.prev.next = node.next;
    	   node.next.prev =node.prev;
    	    node.next = null;
			node.prev = null;
    	   size--;
       }
    }

      
      public void displayList() 
      {
    	     
    	  
          String dis = "[";
          for( Node disp = head.next; disp != head; disp = disp.next)
          
          {
        	   dis = dis + " " + disp.item;
        	   
          }
          dis = dis + " ]";
    	  System.out.println("Values in list are " + dis);
      }
      
  	public static void main(String[] args)
  	{
  	    CList<Integer> d1 = new CList<Integer>();  
  	    d1.insertFront(30);
  	    d1.insertBack(20);
  	    d1.insertBack(50);
  	    d1.front();
  	    d1.back();
  	    d1.insertAfter(99,d1.back() );
  	    d1.insertBefore(11111,d1.back() );
  	    d1.remove(d1.front());
  	    
  	   
  	    System.out.println("isempty"  + d1.isEmpty());
  	    System.out.println("Length"  + d1.length());
  	    d1.displayList();
  	}
}

  	
    



