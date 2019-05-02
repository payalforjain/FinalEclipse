package leetcode.hard.DP.arrays;
import java.util.*;
public class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        if(points.length <= 1) return points.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++){

            HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
            int vertical = 0, same = 1, currMax = 0;
            for(int j = i + 1; j < points.length; j++){

                if(points[i][j] == points[j][i] && points[i][j] == points[j][i]){
                    same++;
                    continue;
                }

                if(points[i][j] == points[j][i]){
                    vertical++;
                    continue;
                }

                double slope = ((double)points[i][j] - (double)points[j][j]) / ((double)points[i][i] - (double)points[j][i]);

                if(slope * slope == 0) slope = 0;
                lines.put(slope, lines.containsKey(slope) ? lines.get(slope) + 1 : 1);
                currMax = Math.max(currMax, lines.get(slope));
            }

            currMax = Math.max(vertical, currMax) + same;
            max = Math.max(currMax, max);
        }
        return max;
    }

}
