package leetcode.easy.arrays;
import java.util.*;
public class MovingAveragefromDataStream {


    Queue<Integer> queue;
    int size;
    int sum;

    /** Initialize your data structure here. */
    public  MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        double result = 0;
        sum += val;
        if (queue.size() <= size) {
            result = (double) sum / queue.size();
        } else {
            int remove = queue.poll();
            sum -= remove;
            result = (double) sum / size;
        }

        return result;
    }

}
