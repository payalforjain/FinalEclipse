package OpenX;

public class DS {
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
	
    public BSTNode findLca( int t1, int t2)
    {
   	 return findLca(root,t1,t2);
    }
    
    public BSTNode findLca(BSTNode node, int t1, int t2) {
   	    if(node == null) 
   	        return null;
   	    
   	    if(t1 < node.getData() && t2 < node.getData())// both targets are left
   	       return findLca(node.getLeft(), t1, t2);
   	    else if (t1 > node.getData() && t2 > node.getData()) // both targets are right
   	        return findLca(node.getRight(), t1, t2);
   	     else 
   	     {
   	       
   	    	System.out.println(node.getData());
   	        return node;
   	    }
   	}
    
    public Node mergeTwoLists(Node listone, Node listtwo) {
        Node current=new Node(-1);
        Node copy=current;
        if(listone==null) return listtwo;
        if(listtwo==null) return listone;
       
       while(listone!=null & listtwo!=null){
        if(listone.item>listtwo.item){
            current.next=listtwo;
            current=current.next;
            listtwo=listtwo.next;
        }else{
            current.next=listone;
            current=current.next;
            listone=listone.next;
        }   
       }
        
        if(listone==null) current.next=listtwo;
        if(listtwo==null) current.next=listone;
       
        return copy.next;
    }
    
}
