package leetcode.medium.string;
import java.util.*;
class AllOne {
    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket prev;
        Bucket next;
        public Bucket(int count) {
            this.count = count;
            this.keySet = new HashSet<>();
        }
    }

    private Bucket head;
    private Bucket tail;
    private Map<Integer, Bucket> countBucketMap;
    private Map<String, Integer> keyCountMap;

    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            //existing key
            updateKey(key, 1);
        } else {
            //new key
            keyCountMap.put(key, 1);
            if (head.next.count != 1) {
                addBucketAfter(head, new Bucket(1));
            }
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                updateKey(key, -1);
            }
        }
    }

    private void updateKey(String key, int i) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count+i);
        Bucket pre = countBucketMap.get(count);
        Bucket cur;
        if (countBucketMap.containsKey(count+i)) {
            cur = countBucketMap.get(count+i);
        } else {
            cur = new Bucket(count+i);
            countBucketMap.put(count+i, cur);
            if (i == 1) {
                addBucketAfter(pre, cur);
            } else {
                addBucketAfter(pre.prev, cur);
            }
        }
        cur.keySet.add(key);
        removeKeyFromBucket(pre, key);
    }

    private void addBucketAfter(Bucket pre, Bucket cur) {
        Bucket next = pre.next;
        pre.next = cur;
        cur.prev = pre;
        cur.next = next;
        next.prev = cur;
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            bucket.prev.next = bucket.next;
            bucket.next.prev = bucket.prev;
            bucket.prev = null;
            bucket.next = null;
            countBucketMap.remove(bucket.count);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
    }
}



class PQ {


    class Node{
        String key;
        int val;
        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    HashMap<String, Node> map;
    PriorityQueue<Node> minQ;
    PriorityQueue<Node> maxQ;
    public AllOne() {
        map = new HashMap<String, Node>();
        minQ = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        maxQ = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return b.val - a.val;
            }
        });
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new Node(key, 1));
            Node node = map.get(key);
            minQ.add(node);
            maxQ.add(node);
        } else {
            Node node = map.get(key);
            minQ.remove(node);
            maxQ.remove(node);
            node.val++;
            map.put(key, node);
            minQ.add(node);
            maxQ.add(node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.val == 1) {
                map.remove(key);
                minQ.remove(node);
                maxQ.remove(node);
            } else {
                minQ.remove(node);
                maxQ.remove(node);
                node.val--;
                map.put(key, node);
                minQ.add(node);
                maxQ.add(node);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return maxQ.isEmpty() ? "" : maxQ.peek().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return minQ.isEmpty() ? "" : minQ.peek().key;
    }

}
