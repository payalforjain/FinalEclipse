package leetcode.medium.graph;
import java.util.*;
public class FactorialCombination {

    /*
    Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
     */


    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(n , 2 , result , current);
        return result ;
    }

    private void dfs (int n ,  int start , List<List<Integer>> result , List<Integer> current )
    {

        if(n == 1 && current.size() > 1)
        {
            System.out.println(current);
            result.add(new ArrayList<>(current));
        }

        for (int i = start ; i <= n ; i++)
        {
            if( n % i == 0)
            {
                current.add(i);
                dfs(n / i ,i , result , current);
                current.remove(current.size() -1 );
            }
        }



    }
}
