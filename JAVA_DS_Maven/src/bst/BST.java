 package bst;

import java.util.*;

import datastructure.Queue.Node;

class BST
{
    public BSTNode root;

    /* Constructor */
    public BST()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    /* Functions to delete data */
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            root = delete(root, k);
            System.out.println(k+ " deleted from the tree");
        }
    }
    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.getData() == k)
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
 
    
    public boolean search(int data)
    {
   	 return search(root, data);
    }
 
    public boolean search(BSTNode node, int data)
    {
   	 
   	 if(node == null)
   		 return false;
   	 else if (node.getData()==data)
   	 {
   		
   		 return true;
   	 }
   	 else if(node.getData()> data)
   	 {
   		 
   		 return search(node.getLeft(),data);
   	 }	 
   	 
   	 else if(node.getData()< data)
   	 {
   		 
   		 return search(node.getRight(),data);
   	 }
   	 
   	
   	 return true;
   	 
    }   
    
    public boolean searchIter(int data)
    {
   	 return searchIter(root, data);
    }
 
	public boolean searchIter(BSTNode node, int data) {

		
		while (node != null)  {
			 
			 if (node.getData() > data) {
				
				node = node.getLeft();
			}

			else if (node.getData() < data) {
				 
				node = node.getRight();
			}
			 
			else if (node.getData() ==data) {
				
					return true;
				}
		}

		return false;

	}
    
    
 
    
    
    
    
    
   
    BSTNode nonfirstCommonAncestor(int data1, int data2)
    {
    	return nonfirstCommonAncestor(root, data1, data2);
    }
    
    BSTNode nonfirstCommonAncestor(BSTNode node, int data1, int data2) {
		
		while (node != null) 
		{
	
			 if (data1 > node.getData() && data2 > node.getData()) {
				node = node.getRight();
			}

			else if (data1 < node.getData() && data2 < node.getData()) {
				node = node.getLeft();
			}
			 
			else
			{
				System.out.println(node.getData());
	   	        return node;
			}
		}
		return node;
	}

    public BSTNode printPath(int data)
    {
    	System.out.println("Print Path");
    	return printPath(root, data);
    }
 
    public BSTNode printPath(BSTNode node, int data)
    {
    	
   	 if (node.getData()==data)
   	 {
   		 System.out.println( data );
   		 return node;
   	 }
   	 else if(node.getData()> data)
   	 {
   		 System.out.println(node.getData());
   		  return printPath(node.getLeft(),data);
   	 }	 
   	 
   	 else if(node.getData()< data)
   	 {
   		 System.out.println(node.getData());
   		 return printPath(node.getRight(),data);
   	 }
   	 
   	 return node;
    }
    
    
    
    
 // prints in level order
   	
    public int findMin()
    {
   	return findMin(root);
    }	
    
    public int findMin(BSTNode node)
    {
   	 if (node==null)
      	    return -1;
      	 else
      	 {
      	 while(node.getLeft() != null)
      	 {
      		node = node.getLeft();
      	 }
      	 }
      	 return node.getData();
    }
    

   
    public int findMax()
    {
   	return findMax(root);
    }	
    
    public int findMax(BSTNode node)
    {
   	 if (node==null)
      	    return -1;
      	 else
      	 {
      	 while(node.getRight() != null)
      	 {
      		node = node.getRight();
      	 }
      	 }
      	 return node.getData();
    }
    
   	


    
     
 	// get list length
 	public int getLength(Node head) {
 		int len = 0;
 		Node p = head;
  
 		while (p != null) {
 			len++;
 			p = p.next;
 		}
 		return len;
 	}

     static int index = 0;
     
     public  void getElement(int k)
     {
    	 getElement(root,k);
     }
     
     public void getElement(BSTNode root, int k){
         //Base condition
         if(root == null)
               return;

         getElement(root.right, k);   //first traverse the right sub tree
         if(++index == k){
                 System.out.println(root.data);
                 return;
         }  
         getElement(root.left, k);    //then traverse the left sub tree
 }

     public BSTNode sortedArrayToBST(int[] num) {
 		if (num.length == 0)
 			return null;
  
 		return sortedArrayToBST(num, 0, num.length - 1);
 	}
  
 	public BSTNode sortedArrayToBST(int[] num, int start, int end) {
 		if (start > end)
 			return null;
  
 		int mid = (start + end) / 2;
 		BSTNode root = new BSTNode(num[mid]);
 		root.left = sortedArrayToBST(num, start, mid - 1);
 		root.right = sortedArrayToBST(num, mid + 1, end);
  
 		
 		
 		
 		return root;
 	}
 	
 	static Node h;
     
 	public BSTNode sortedListToBST(Node head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 

 
	// build tree bottom-up
	public BSTNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		BSTNode left = sortedListToBST(start, mid - 1);
		BSTNode root = new BSTNode(Integer.parseInt((String) h.item));
		h = h.next;
		BSTNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
	
   
 

	public int maxDepth()
	{
		return maxDepth(root);
	}
	
    private int maxDepth(BSTNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int maxLeft = maxDepth( currentNode.getLeft());
        int maxRight = maxDepth( currentNode.getRight());
        int max = Math.max(maxLeft, maxRight);
        return 1 + max;
    }
    
	public int minDepth()
	{
		return minDepth(root);
	}

    private int minDepth(BSTNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int minLeft = minDepth( currentNode.getLeft());
        int minRight = minDepth( currentNode.getRight());
        int min = Math.min(minLeft, minRight);
        return 1 + min;
    }

 	
    // http://www.cnblogs.com/infinityu/archive/2013/05/11/3073411.html
	
 	// a balanced binary search tree will have equal heights (plus or minus one) on the left and right sub-trees of each node.
 	public boolean isTreeBalanced(BSTNode rootNode) {
         int maxDepth = maxDepth(rootNode);
         int minDepth = minDepth(rootNode);
         System.out.println("max depth " + maxDepth);
         System.out.println("min depth " + minDepth);
         return maxDepth - minDepth <= 1;
     }
 	
 	
 	  
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());             
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }  
    
    /** Iteratively traverses the binary tree in pre-order */
    public void preorderIter( ) {
        if( root == null ) return;

        Stack<BSTNode> stack = new Stack<BSTNode>( );
        stack.push( root );

        while( ! stack.isEmpty( ) ) {
            BSTNode current = stack.pop( );
            if( current.right != null ) stack.push( current.right );
            if( current.left != null ) stack.push( current.left );
            System.out.print( current.data + " " );
        }
    }

    /** Iteratively traverses the binary tree in in-order */
    public void inorderIter( ) {
        BSTNode node = root;
        Stack<BSTNode> stack = new Stack<BSTNode>( );
        while( ! stack.isEmpty( ) || node != null ) {
            if( node != null ) {
                stack.push( node );
                node = node.left;
            } else {
                node = stack.pop( );
                System.out.print( node.data + " " );
                node = node.right;
            }
        }
    }

    /** Iteratively traverses the binary tree in post-order */
    public void postorderIter( ) {
        if( root == null ) return;

        Stack<BSTNode> stack = new Stack<BSTNode>( );
        BSTNode current = root;

        while( true ) {

            if( current != null ) {
                if( current.right != null ) stack.push( current.right );
                stack.push( current );
                current = current.left;
                continue;
            }

            if( stack.isEmpty( ) ) return;
            current = stack.pop( );

            if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
                stack.pop( );
                stack.push( current );
                current = current.right;
            } else {
                System.out.print( current.data + " " );
                current = null;
            }
        }
    }
    
    
   	
   	/*Case 1. [k equals the key at root] The floor of k is k.
   	Case 2. [k is less than the key at root] The floor of k is in the left subtree.
   	Case 3. [k is greater than the key at root] The floor of k is in the right subtree 
   	(if there is any key <= k in right subtree); otherwise it is the key in the root.*/
   	
   	int flooring(int data)
   	{
   		return flooring(root, data);
   	}
   	
   	int flooring(BSTNode node, int input)
   	{
   	    // Base case
   	    if( node == null )
   	        return -1;
   	 
   	    // We found equal key
   	    if( node.getData() == input )
   	        return node.getData();
   	    else if(input <node.getData())
   	    	return flooring(node.getLeft(),input);
   	    else if(input > node.getData())
   	    {
   	    	if(node.getRight()!=null)
   	    	   return flooring(node.getRight(),input);
   	    	else
   	    		return node.getData();
   	    }
   	    
   	    return node.getData();
   	}
   		
   	int ceiling(int data)
   	{
   		return ceiling(root, data);
   	}
   	
   	int ceiling(BSTNode node, int input)
   	{
   	    // Base case
   	    if( node == null )
   	        return -1;
   	 
   	    // We found equal key
   	    if( node.getData() == input )
   	        return node.getData();
   	    else if(input >node.getData())
   	    	return ceiling(node.getRight(),input);
   	    else if(input < node.getData())
   	    {
   	    	if(node.getLeft()==null)
   	    		return node.getData();
   	    		
   	    	else
   	    		return ceiling(node.getLeft(),input);
   	    	
   	    		
   	    }
   	    return node.getData();
   	  
   	}
 
     public static void main(String args[])
{
	 BST bst = new BST();
	bst.insert(30);
    bst.insert(25);
    bst.insert(55);
    bst.insert(20);
    bst.insert(26);
    bst.insert(18);
    bst.insert(22);
    bst.insert(57); 
 
    bst.insert(53);
   
    bst.insert(6);
    bst.insert(52);
    bst.insert(54);
    bst.insert(59);
    bst.insert(56);
    //bst.printPath(26);*/
	 /*System.out.println(bst.flooring(19));
	 System.out.println(bst.ceiling(56));
	bst.levelOrderTraversal();
    bst.printZigZagOrder();*/
    System.out.println(bst.searchIter(4));
    
    System.out.println("least");

   bst.nonfirstCommonAncestor(18, 53);

    System.out.println("Max Depth is" + bst.maxDepth());
    
   System.out.println("Min Depth is" + bst.minDepth()); 
  
 
}
}