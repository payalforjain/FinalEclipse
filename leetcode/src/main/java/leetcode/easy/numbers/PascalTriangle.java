package leetcode.easy.numbers;
import java.util.*;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return result;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }

        return result;
    }

    /*
    Input: 3
Output: [1,3,3,1]
Could you optimize your algorithm to use only O(k) extra space?
     */
    // this solution uses extra space
    public List<Integer> getRow(int rowIndex) {


        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        int row = 0;

        if(rowIndex == 0)
        {
            return pre;
        }

        for (int i = 1; i <= 33; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last


            pre = cur;

            row ++;

            if(row == rowIndex)
            {
                return pre;
            }
        }

        return pre ;

    }

/*
Input: 3
Output: [1,3,3,1]
 */
    public List<Integer> getRowBetter(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}
