import java.util.*;

public class NaturalSort implements Comparator
{
    int compareRight(String s1, String s2)
    {
        int temp = 0, i_s1 = 0, i_s2 = 0;

        
        for (;; i_s1++, i_s2++)
        {
            char char_s1 = charAt(s1, i_s1);
            char char_s2 = charAt(s2, i_s2);

            if (!Character.isDigit(char_s1) && !Character.isDigit(char_s2)) {
                return temp;
            }
            if (!Character.isDigit(char_s1)) {
                return -1;
            }
            if (!Character.isDigit(char_s2)) {
                return +1;
            }
            if (char_s1 == 0 && char_s2 == 0) {
                return temp;
            }

            if (temp == 0) {
                if (char_s1 < char_s2) {
                    temp = -1;
                } else if (char_s1 > char_s2) {
                    temp = +1;
                }
            }
        }
    }

    public int compare(Object o1, Object o2)
    {
        String s1 = o1.toString();
        String s2 = o2.toString();

        int i_s1 = 0, i_s2 = 0;
        int nz_s1 = 0, nz_s2 = 0;
        char char_s1, char_s2;

        while (true) {
            // Only count the number of zeroes leading the last number compared
            nz_s1 = nz_s2 = 0;

            char_s1 = charAt(s1, i_s1);
            char_s2 = charAt(s2, i_s2);

            // skip over leading spaces or zeros
            while (Character.isSpaceChar(char_s1) || char_s1 == '0') {
                if (char_s1 == '0') {
                    nz_s1++;
                } else {
                    // Only count consecutive zeroes
                    nz_s1 = 0;
                }

                char_s1 = charAt(s1, ++i_s1);
            }

            while (Character.isSpaceChar(char_s2) || char_s2 == '0') {
                if (char_s2 == '0') {
                    nz_s2++;
                } else {
                    // Only count consecutive zeroes
                    nz_s2 = 0;
                }

                char_s2 = charAt(s2, ++i_s2);
            }

            // Process run of digits
            if (Character.isDigit(char_s1) && Character.isDigit(char_s2)) {
                int temp = compareRight(s1.substring(i_s1), s2.substring(i_s2));
                if (temp != 0) {
                    return temp;
                }
            }

            if (char_s1 == 0 && char_s2 == 0) {
                return nz_s1 - nz_s2;
            }
            if (char_s1 < char_s2) {
                return -1;
            }
            if (char_s1 > char_s2) {
                return +1;
            }

            ++i_s1;
            ++i_s2;
        }
    }

    static char charAt(String s, int i) {
        return i >= s.length() ? 0 : s.charAt(i);
    }

    public static void main(String[] args)
    {
        String[] strings = new String[] { "10/5", "5/02","txt10.txt", "text2.txt", "txt5.txt", "1/20", "1/5",
            "-2", "2", "1 10 2", "1210", "1102","1 2 10","-5"};

        List orig = Arrays.asList(strings);
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("");

        System.out.println("Original: " + orig);
        
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
        
        Collections.sort(orig);

        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("");

        System.out.println("ASCII sort: " + orig);
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("");

        Collections.sort(orig, new NaturalSort());
        
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Natural Sort: " + orig);
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        
    }
}