package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 class RandonPick{


    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public  RandonPick(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = psum.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
/*
    Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

            Note:

            1 <= w.length <= 10000
            1 <= w[i] <= 10^5
    pickIndex will be called at most 10000 times.
            Example 1:

    Input:
            ["Solution","pickIndex"]
            [[[1]],[]]
    Output: [null,0]
    Example 2:

    Input:
            ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
            [[[1,3]],[],[],[],[],[]]
    Output: [null,0,1,1,1,0]


    */

}
