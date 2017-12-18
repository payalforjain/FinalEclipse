package leetcode.easy.linkedlistPrac;

/*
 *  Java Program to Implement Stack using Two Queues
 */
 
import java.util.*;
 
/* Class stackUsingQueue */
class stackUsingQueue
{
    LinkedList<Integer> q ;
    LinkedList<Integer> tmp ;
 
 
    public stackUsingQueue()
    {
        q = new LinkedList<Integer>();
        tmp = new LinkedList<Integer>();
    }    
   
    public void push(int data)
    {
             
        if (q.size() == 0)
            q.add(data);
        else
        {
                    
            int l = q.size();
            for (int i = 0; i < l; i++)
                tmp.add(q.remove());                
           
            q.add(data);        
                         
            for (int i = 0; i < l; i++)
                q.add(tmp.remove());
        }
    }    
    public void display()
    {
        System.out.print("\nStack = ");
        int l = q.size();
        if (l == 0)
            System.out.print("Empty\n");
        else
        {
            Iterator<Integer> it = q.iterator();
            while (it.hasNext())
                System.out.print(it.next()+" ");
            System.out.println();
        }
    }

   
    public static void main(String[] args)
    {
                         
    }
}