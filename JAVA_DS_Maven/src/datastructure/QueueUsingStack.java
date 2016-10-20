package datastructure;

/*
 *  Java Program to Implement Queue using Two Stacks
 */
 
import java.util.*;
 
/* Class queueUsingStack */
class queueUsingStack
{
    Stack<Integer> s ;
    Stack<Integer> tmp ;
 
    /* Constructor */
    public queueUsingStack()
    {
        s = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
            
        if (s.size() == 0)
            s.push(data);
        else
        {   
                   
            int l = s.size();
            for (int i = 0; i < l; i++)
                tmp.push(s.pop());                   
            /* push the new element to stack s */             
            s.push(data);            
            /* pop all elements from stack tmp and
             * push them to stack s */             
            for (int i = 0; i < l; i++)
                s.push(tmp.pop());                   
        }
    }    
   
  
   
}