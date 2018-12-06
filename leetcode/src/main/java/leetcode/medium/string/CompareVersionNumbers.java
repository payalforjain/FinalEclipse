package leetcode.medium.string;

public class CompareVersionNumbers {
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 */
    public int compareVersion(String version1, String version2) {

        int ver1 = 0;
        int ver2=0;
        int i =0 ;
        int j = 0;
        while(i < version1.length()  || j < version2.length() )
        {

            while(i < version1.length()  && version1.charAt(i) != '.')
            {
                ver1 = ( ver1 * 10) + version1.charAt(i) - '0';
                i++;
            }


            while(j < version2.length()  && version2.charAt(j) != '.')
            {
                ver2 = ( ver2 * 10) + version2.charAt(j) - '0';
                j++;
            }



            if(ver1 > ver2)
            {
                return 1;
            }

            else if (ver1 < ver2)
            {
                return -1;
            }

            else
            {
                ver1 =0;
                ver2=0;
                i++;
                j++;
            }
        }
        return 0;
    }
}
