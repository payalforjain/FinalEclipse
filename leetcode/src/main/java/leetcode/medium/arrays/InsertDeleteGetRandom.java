package leetcode.medium.arrays;
import java.util.*;
public class InsertDeleteGetRandom {

    Map<Integer,Integer> map ;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom () {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else
        {
            map.put(val, list.size());
            list.add(val);

            return true;
        }

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!map.containsKey(val))
            return false;

        else
        {
            int index = map.remove(val);
            int last = list.remove(list.size()-1);
            if(last != val)
            {
                list.set(index, last);
                map.put(last, index);
            }
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
