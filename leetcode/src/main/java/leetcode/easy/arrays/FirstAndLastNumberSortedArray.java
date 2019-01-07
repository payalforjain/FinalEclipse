package leetcode.easy.arrays;

public class FirstAndLastNumberSortedArray {

    public int[] searchRangeBetter(int[] nums, int target) {
        int low= 0 ; int high = nums.length -1;

        while(low<=high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target)
            {
                if(nums[low] == target && nums[high] == target)
                {
                    return new int[]{low,high};
                }

                else if (nums[high] != target)
                {
                    high--;
                }
                else if (nums[low] != target)
                {
                    low ++;
                }

            }
            else if(nums[mid] < target )
            {
                low = mid +1;
            }

            else
            {
                high = mid -1 ;
            }
        }

        return new int[]{-1,-1};
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1 };

        for(int i = 0 ; i< nums.length; i++) {
            if(nums[i] == target) {
                result[0] = i;
                break;
            }
        }


        if(result[0] == -1) {
            return result;
        }


        for(int i = nums.length-1 ; i>=0; i--) {
            if(nums[i] == target) {
                result[1] = i;
                break;
            }
        }


        return result;
    }
}
