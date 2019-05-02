package leetcode.medium.arrays;
import java.util.*;
public class InsertDeleteGetRandomAllowDuplicates {

    HashMap<Integer, Set<Integer>> map ;
    List<Integer> list ;
    Random r ;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomAllowDuplicates() {
        map =  new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if (!map.containsKey(val)) {
            flag = true;
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if ( ! contain ) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index < list.size() - 1 ) {
            int last = list.get( list.size()-1 );
            list.set( index , last );
            map.get(last).remove( list.size()-1);
            map.get(last).add(index);
        }
        list.remove(list.size() - 1);

        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args)
    {
        InsertDeleteGetRandomAllowDuplicates r = new InsertDeleteGetRandomAllowDuplicates();
        r.insert(1);
        r.insert(1);
        r.insert(2);
        r.remove(1);

    }
}
