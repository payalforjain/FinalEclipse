package leetcode.easy.LinkedList;

class MyHashMap {

    class ListNode
    {
        int key, value;
        ListNode next ;

        ListNode(int key , int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    class Bucket
    {
        ListNode head = new ListNode(-1,-1);
    }

    Bucket[] bucket;
    int size = 10000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Bucket[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int i = hash(key);
        if(bucket[i] == null)
        {
            bucket[i] = new Bucket();
        }

        ListNode pre = find(bucket[i] , key);

        if(pre.next == null)
        {
            pre.next = new ListNode(key, value);
        }
        else
        {
            pre.next.value = value;
        }

    }


    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int i = hash(key);
        if(bucket[i] == null)
        {
            return -1;
        }

        ListNode pre = find(bucket[i] , key);

        if(pre.next == null)
        {
            return -1;
        }
        else
        {
            return pre.next.value;
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int i = hash(key);
        if(bucket[i] == null)
        {
            return ;
        }

        ListNode pre = find(bucket[i] , key);

        if(pre.next == null)
        {
            return ;
        }
        else
        {
            pre.next = pre.next.next;
        }

    }

    private ListNode find(Bucket bucket , int key)
    {
        ListNode head = bucket.head;
        ListNode pre = head;

        while(head !=null && head.key != key)
        {
            pre = head;
            head = head.next;
        }
        return pre;
    }

    private int hash(int key )
    {
        return key %size;
    }
}
