package leetcode.medium.arrays;
import java.util.*;

public class LongestIncreasingSequence {

    /*
  for each num in nums
   if(list.size()==0)
        add num to list
   else if(num > last element in list)
        add num to list
   else
        replace the element in the list which is the smallest but bigger than num
longest-increasing-subsequence-leetcode-java*/

    /*
    Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     */
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length ==0 )
            return 0;

        List<Integer> result = new ArrayList<>();

        for(int num : nums)
        {
            if(result.size() == 0 ||  num > result.get(result.size() - 1))
            {
                result.add(num);
            }
            else
            {
                int left = 0 ;
                int right = result.size() -1 ;

                while (left < right)
                {
                    int mid = (left +  right)/ 2 ;
                    if(result.get(mid) < num )
                        left = mid +1;
                    else
                        right= mid;
                }

                result.set(right , num);
            }
        }
        return result.size();
    }


    public static void main(String[] args)
    {
        LongestIncreasingSequence l = new  LongestIncreasingSequence();
        l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
