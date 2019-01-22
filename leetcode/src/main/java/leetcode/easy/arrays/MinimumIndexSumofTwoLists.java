package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.List;
/*


Suppose Andy and Doris want to choose a restaurant for dinner,
and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the
 least list index sum. If there is a choice tie between answers, output all of them with no order requirement.
  You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */
public class MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        int sum = 0;
        Map<String, Integer> m = new HashMap<>();

        for(int i  = 0 ; i < list1.length ; i++)
        {
            m.put(list1[i] , i);
        }

        for(int i  = 0 ; i < list2.length ; i++)
        {
            if(m.containsKey(list2[i]))
            {
                sum = i + m.get(list2[i]);
                if(minSum > sum)
                {
                    result.clear();
                    result.add(list2[i]);
                    minSum = sum;
                }
                else if (sum ==  minSum )
                    result.add(list2[i]);

            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args)
    {
        MinimumIndexSumofTwoLists m = new MinimumIndexSumofTwoLists();
        String[] l1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"} ;
        String[] l2  =  {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"} ;
        m.findRestaurant(l1, l2);
    }
    /*
    Time complexity : O(l_1+l_2)O(l
1
​
 +l
2
​
 ). Every item of list2list2 is checked in a map of list1list1. l_1l
1
​
  and l_2l
2
​
  are the lengths of list1list1 and list2list2 respectively.

Space complexity : O(l_1*x)O(l
1
​
 ∗x). hashmap size grows upto l_1*xl
1
​
 ∗x, where xx refers to average string length.
     */
}
