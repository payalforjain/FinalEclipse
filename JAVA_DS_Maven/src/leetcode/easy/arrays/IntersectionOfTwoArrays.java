package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
//	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i : nums1) {
			set1.add(i);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i : nums2) {
			if (set1.contains(i)) {
				set2.add(i);
			}
		}

		int[] result = new int[set2.size()];
		int i = 0;
		for (int n : set2) {
			result[i++] = n;
		}

		return result;
	}
	//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i])  + 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                map.put(nums2[j], map.get(nums2[j]) - 1);
                if (!resultMap.containsKey(nums2[j])) {
                    resultMap.put(nums2[j], 1);
                } else {
                    resultMap.put(nums2[j], resultMap.get(nums2[j]) + 1);
                }
            }
        }

        int sum = 0;
        for (Integer e : resultMap.keySet()) {
            int count = resultMap.get(e);
            sum += count;
            for (int i = 0; i < count; i++) {
                list.add(e);
            }
        }
        int[] result = new int[sum];
        for (int i = 0; i < sum; i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }
}
