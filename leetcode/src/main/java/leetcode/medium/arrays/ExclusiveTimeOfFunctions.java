package leetcode.medium.arrays;
import java.util.*;
public class ExclusiveTimeOfFunctions {

    /*
    On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

Return the exclusive time of each function, sorted by their function id.
/*
Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 */

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        if (logs == null || logs.size() == 0) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();

        int lastTimestamp = 0;
        for (String log : logs) {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            String flag = arr[1];
            int timestamp = Integer.parseInt(arr[2]);

            if (!stack.isEmpty()) {
                ans[stack.peek()] += (timestamp - lastTimestamp);
            }

            if ("start".equals(flag)) {
                stack.push(id);
            } else {
                timestamp++;
                ans[stack.peek()]++;
                stack.pop();
            }
            lastTimestamp = timestamp;
        }
        return ans;
    }

        public static void main(String[] args)
    {


        ExclusiveTimeOfFunctions e = new ExclusiveTimeOfFunctions();
        e.exclusiveTime(2,  new ArrayList<>( Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6") ));
    }

    /*
    Time complexity : O(n)O(n). We iterate over the entire logslogs array just once. Here, nn refers to the number of elements in the logslogs list.

Space complexity : The stackstack can grow upto a depth of atmost n/2n/2. Here, nn refers to the number of elements in the given logslogs list.
     */
}
