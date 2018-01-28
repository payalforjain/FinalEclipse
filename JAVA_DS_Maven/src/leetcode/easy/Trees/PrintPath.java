package leetcode.easy.Trees;

public class PrintPath {
	 public BSTNode root;
	
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

}
