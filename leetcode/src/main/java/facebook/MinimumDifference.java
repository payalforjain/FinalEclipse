package facebook;

public class MinimumDifference {
	
	public int minimumDifference(int[] arr) {
	    int minimum = 0;

	    if (null != arr) {
	        int length = arr.length;
	        if (length == 1) {
	            minimum = arr[0];
	        }
	        if (length == 2) {
	            minimum = Math.abs(arr[0] - arr[1]);
	        } else if (length > 2) {
	            int minimumSoFar = arr[0];
	            int secondMinimumSoFar = arr[0];
	            for (int i = 0; i < length; i++) {
	                if (arr[i] < minimumSoFar) {
	                    minimumSoFar = arr[i];
	                }
	                if (arr[i] > minimumSoFar && arr[i] < secondMinimumSoFar) {
	                    secondMinimumSoFar = arr[i];
	                }
	            }
	            minimum = secondMinimumSoFar - minimumSoFar ;
	        }
	    }
	    return minimum;
	}

}
