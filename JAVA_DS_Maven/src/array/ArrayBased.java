package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ArrayBased {

	
	 public void printTwoMaxNumbers(int[] nums){
	        int maxOne = 0;
	        int maxTwo = 0;
	        for(int n:nums){
	            if(maxOne < n){
	                maxTwo = maxOne;
	                maxOne =n;
	            } else if(maxTwo < n){
	                maxTwo = n;
	            }
	        }
	        System.out.println("First Max Number: "+maxOne);
	        System.out.println("Second Max Number: "+maxTwo);
	    }

	public static void basicArray()
	{
		String[] a = {"a","b", "c"};
		List<String> l = Arrays.asList(a);
		System.out.println(l);
		
		int[] myArr = {2,4,2,4,5,6,3};
        System.out.println("Array size before copy: "+myArr.length);
        int[] newArr = Arrays.copyOf(myArr, 10);
        System.out.println("New array size after copying: "+newArr.length);
        
        
        Arrays.sort(newArr);
        for(int i = 0; i< newArr.length;i++)
		   System.out.println(newArr[i]);
        
        
        int[] n = Arrays.copyOfRange(myArr, 1, 4);
        
        for(int num:n){
            System.out.print(num+"  ");
        }

        int[] s = {5,6,6};
        int[] d= {5,6,6};
        System.out.println("Are strArr and strArrCopy same? "+ Arrays.equals(s,d));

		// Arrays.fill(myArr, "Assigned"); Arrays.fill() helps us to fill an empty array with default values 
        
        
        /*
         * tring[] strArr = {"JAVA", "C++", "PERL", "STRUTS", "PLAY"};
        Arrays.sort(strArr,new Comparator<String>(){
 
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }});
         
        for(String str:strArr){
            System.out.println(str);
        }*/

       
	}
	

	
	
	   public static int indexEqualToNumberSortedArray(int[] a)
	    {
	    	int temp = 0;
	    	 if (a.length == 0) {
	             return -1;
	         }
	    	for(int i = 0; i<a.length;i++)
	    	{
	    		if(a[i]==i)
	    		{
	    			return a[i];
	    		}
	    	}
	    	
	    	
	    	return -1;
	    }
	    
	    public static int numberWithHighestFrequency(int[] inputArray) {
	        if (inputArray.length < 1) {
	            System.out.println("Input array should contain atleast one element");
	            return -1;
	        }
	        
	        int globalNumber = inputArray[0];
	        int globalCount = 0;
	        
	        int number = inputArray[0];
	        int count = 0;
	        
	        for(int temp :  inputArray)
	        {
	        	if(number == temp)
	        	{
	        		count++;
	        	}
	        	if(number != temp)
	        	{   globalNumber = temp;
	        		globalCount++;
	        		if(globalCount > count)
	        		{
	        			count = globalCount;
	        			number = temp;
	        			
	        			globalCount = 0;
	        			
	        		}
	        	}
	        }
	        return number ;
	    }
		//Given an int[] multiply all numbers except index I/p {1,2,3,4} O/P {24,12,8,6} 
		public static void multiplication(String[] args) {
		    int[] arr = {1,2,3,4};
		    int[] result = { 1, 1, 1, 1};
		    for (int i = 0; i < arr.length; i++) {
		        for (int j = 0; j < i; j++) {
		            result[i] *= arr[j];

		        }
		        for (int k = arr.length - 1; k > i; k--) {
		            result[i] *= arr[k];
		        }
		    }
		    for (int i : result) {
		        System.out.println(i);
		    } 
		        
	}
		
		public static void oddnumberstime(int[] a)
		{
			HashMap<Integer, Integer> m = new HashMap<Integer,Integer>();
		  
		  for(int i=0 ; i<a.length;i++)
		  {
			  if(m.containsKey(a[i]))
			   { 
				           int v =m.get(a[i]);
				   	       m.put(a[i],v+1 );
				   	       
				   	  
			   }
			   
			   else
			   {
				   m.put(a[i], 1);   
			   }
		  }
		  
		    for(Map.Entry<Integer,Integer> d: m.entrySet())
		   	   {
		   		if(d.getValue()%2==1) 
		   		{
		    	System.out.println(d.getKey() + " = " + d.getValue());
		   		}
		   	   }	
		  
		}
		

		public static void moveZerotoEnd(int[] a)
		{
			int start = 0;
			int end= 0;
			
			for(int i=0;i<a.length;i++)
			{
				
				if(a[i] != 0)
				
				{
					
					
					int temp;
					  temp = a[end];
				      a[end] = a[i];
				      a[i] = temp;
				      end++;
				}
			
			}
			for(int i =0 ; i<a.length; i++)
			{
				System.out.println(a[i]);
			}
		}

		public static void moveZerotoBegin(int[] a)
		{
			int start = 0;
			int end= 0;
			
			for(int i=0;i<a.length;i++)
			{
				
				if(a[i] != 1)
				
				{
					
					
					int temp;
					  temp = a[end];
				      a[end] = a[i];
				      a[i] = temp;
				      end++;
				}
			
			}
			for(int i =0 ; i<a.length; i++)
			{
				System.out.println(a[i]);
			}
		}
		
		public static void moveAllEvensToLeft(int[] a)
		{
			int start = 0;
			int end= 0;
			
			for(int i=0;i<a.length;i++)
			{
				
				if(a[i] %2 == 0)
				
				{
					
					
					int temp;
					  temp = a[end];
				      a[end] = a[i];
				      a[i] = temp;
				      end++;
				}
			
			}
			for(int i =0 ; i<a.length; i++)
			{
				System.out.print(a[i]);
			}
		}
		
		public static void arraylist(Integer[] a)
		{
		    
		    List<Integer> list = Arrays.asList(a);
		    Collections.sort(list);
		    
		    System.out.println(list); // prints [6, 5, 5, 2, 1, 0, 0]
		    Collections.reverse(list);
		    System.out.println(list); 
		   
	}
		public static void secondLargest()
		{ 
			// Tree Set
			int[] randomIntegers = { 1, 5, 4, 2, 8, 1, 8, 9,9 };
	        TreeSet<Integer> set = new TreeSet<Integer>();
	        for (int i: randomIntegers) {
	            set.add(i);
	        }
	        // Remove the maximum value; print the largest remaining item
	       
			int secondlargest = set.size()-2;
			System.out.println(set.toArray()[secondlargest]);
			
			/*
			 *  set.remove(set.last());
	        System.out.println(set.last());
			
			 */
		}
		
		//determine the second frequent number in an input array
		
	public static void secFreqElement() {
		int array[] = { 12, 12, 12, 13, 14, 133, 155, 166, 134, 123, 123, 1234, 12, 12345 };

		SortedMap<Integer, Integer> sMap = new TreeMap<Integer, Integer>();
		sMap.put(array[0], 1);
		int temp;
		for (int i = 1; i < array.length; i++) {

			if (sMap.get(array[i]) != null) {
				temp = sMap.get(array[i]);
				sMap.put(array[i], temp + 1);
			} else {
				sMap.put(array[i], 1);
			}
			temp = 0;
		}
		System.out.println(sMap);

		TreeSet<Integer> treeSet = new TreeSet<Integer>(sMap.values());
		int sechigh = treeSet.size() - 2;
		System.out.println(treeSet.toArray()[sechigh]);

		for (Map.Entry<Integer, Integer> entry : sMap.entrySet()) {
			if (entry.getValue().equals(treeSet.toArray()[sechigh])) {
				System.out.println("1st higest value is" + entry.getKey());
			}
		}

	}
    private static final int MAX_ROW = 4;

    // Diagonal Format
    private static void  diagonalFormatPrint(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        // In the question, there are only 4 rows
        StringBuilder[] rows = new StringBuilder[MAX_ROW];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        // distance from left corner
        int distance = 0;

        for (int i = 0; i < array.length; distance++) {

            rows[0].append(array[i++]).append(" ");

            for (int j = 0; i < array.length && j < distance && j < rows.length - 1; j++, i++) {
                rows[j + 1].append(array[i]).append(" ");
            }
        }

        for (StringBuilder sb : rows) {
            System.out.println(sb.toString());
        }
    }
    
    public static int  middleIndex(int[] a) throws Exception
	{
		int leftSum = 0;
		int rightSum=0;
		int leftIndex=0;
		int rightIndex=a.length-1;
		
		while(true)
		{
			if(leftSum > rightSum)
			{
				
				
				rightSum = rightSum+a[rightIndex--];
				
			}
			
			else 
			{
				leftSum = leftSum + a[leftIndex++];
				
			}
			
			if( leftIndex > rightIndex )
			{
				if(leftSum == rightSum)
				{
					break;
				}
				
				else throw new Exception("Enter proper Array");
			}
			
			
		}
		return rightIndex;
	}
	
    // how to avoid duplicate elements from asn array and disply only distinct elements. Please use only arrays to process it. 
    // if u want with better performance use Set
    public static void printDistinctElements(int[] arr){
        
        for(int i=0;i<arr.length;i++){
            boolean isDistinct = false;
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct){
                System.out.print(arr[i]+" ");
            }
        }
    }

	    public static void main(String[] args)
	    {
	    	
	    	 int[] d = {2,3,2,4,4,4,6,8,8};
	    		oddnumberstime(d);
	    		
	    		
	    		int g[] = {0, 0, 1,0,0,1,1,0,0,1};

	    		System.out.println("Move Aerp to End");
	    		moveZerotoEnd(g);
	    		
	    		System.out.println("Move Aerp to Begin");
	    		moveZerotoBegin(g);
	    		  moveAllEvensToLeft(new int[]{1, 4, 4, 6});
	    	
int[] array1 = new int[] {1,2,3,4,5,6,7,8,9,10};

		
	    	
	    	  System.out.println(indexEqualToNumberSortedArray(new int[] {1, 2, 4, 5, 6, 7}));
		       System.out.println(indexEqualToNumberSortedArray(new int[] {0, 3, 4, 5, 6, 7}));
		        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 2, 4, 7}));
		        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 2, 3, 5}));
		        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 3, 5, 6}));
		        System.out.println("Highest" + numberWithHighestFrequency(new int[] {0, 0, 1,1,1,1,1, 2, 2, 2, 2}));
		        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

		        diagonalFormatPrint(array);

		        array = new int[45];
		        for (int i = 0; i < array.length; i++) {
		            array[i] = i+1;
		        }
		        diagonalFormatPrint(array);
		        
		        int[] num = { 2, 4, 4, 5, 4, 1 };
		        try {
		            System.out.println("Starting from index 0, adding numbers till index "
		                            + middleIndex(num) + " and");
		            System.out.println("adding rest of the numbers can be equal");
		        } catch (Exception ex) {
		            System.out.println(ex.getMessage());
		        }
	    }
	    
	
	
	   
}
