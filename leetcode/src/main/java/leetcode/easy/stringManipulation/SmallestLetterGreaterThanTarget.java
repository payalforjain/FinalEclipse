package leetcode.easy.stringManipulation;

public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetterIter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }

    public char nextGreatestLetter(char[] letters, char target) {


        int low = 0 ; int high = letters.length;

        while(low < high)
        {
            int mid = low + (high - low) /2 ;
            if(letters[mid] <= target )
                low = mid+1;
            else
                high = mid;
        }

        return letters[low % letters.length ];
    }
}
