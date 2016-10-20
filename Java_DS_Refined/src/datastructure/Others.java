package datastructure;

public class Others {
	
	
	// merge two linked list
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur=new ListNode(-1);
        ListNode copy=cur;
        if(l1==null) return l2;
        if(l2==null) return l1;
       
       while(l1!=null & l2!=null){
        if(l1.val>l2.val){
            cur.next=l2;
            cur=cur.next;
            l2=l2.next;
        }else{
            cur.next=l1;
            cur=cur.next;
            l1=l1.next;
        }   
       }
        
        if(l1==null) cur.next=l2;
        if(l2==null) cur.next=l1;
       
        return copy.next;
    }

	
	

}
