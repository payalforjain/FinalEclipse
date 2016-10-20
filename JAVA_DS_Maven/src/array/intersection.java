package array;
import java.util.*;
public class intersection {
	  public static void main(String[] args) {
		  
		        char[] a = {'a', 'b', 'c', 'd'};
		        char[] b = {'c', 'd', 'e', 'f'};
		        System.out.println(intersect(a, b));
		        System.out.println(minus(a, b));
		        String[] alphabets = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

		        List<String> list = Arrays.asList(alphabets);

		        Collections.shuffle(list);

		        for (String alpha : list) {
		          System.out.print(alpha + " ");
		        } 
		        
		    }

		    private static Set<Character> intersect(char[] a, char[] b) {
		        Set<Character> aSet = new HashSet<Character>();
		        Set<Character> intersection = new HashSet<Character>();
		      
		        
		        for (char c : a) {
		            aSet.add(c);
		        }
		        for (char c : b) {
		            if (aSet.contains(c)) {
		                intersection.add(c);
		            }
		        }
		        return intersection;
		    }
		    
		    private static Set<Character> minus(char[] a, char[] b)
		    {
		        Set<Character> aSet = new HashSet<Character>();
		        Set<Character> intersection = new HashSet<Character>();
		        for (char c : b) {
		            aSet.add(c);
		        }
		        for (char c : a) {
		            if (!aSet.contains(c)) {
		                intersection.add(c);
		            }
		        }
		        return intersection;
		    }
}
