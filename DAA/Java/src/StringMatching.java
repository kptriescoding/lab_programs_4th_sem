import java.util.Scanner;

public class StringMatching {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//
        System.out.println("Enter the text");
        char[] text = s.nextLine().toCharArray();

        System.out.println("Enter the pattern");
        char[] pattern = s.nextLine().toCharArray();

        int ind = isMatching(text, pattern);
        if (ind == -1) System.out.println("No matching pattern ");
        else System.out.println("Index no " + ind + " matched");
    }

    // Bad table for all possible 256 ascii characters
    static int[] getTable(char[] pattern) {
        int[] arr = new int[256];
//Initialize with the pattern's length
        for (int i = 0; i < 256; i++) {
            arr[i] = pattern.length;
        }
//        Change the  value of character pattern[i]
        for (int i = 0; i < pattern.length; i++)
            arr[pattern[i]] = pattern.length - 1 - i;

        return arr;
    }

    static int isMatching(char[] text, char[] pattern) {

        int i = 0, pL = pattern.length;
        int[] badTable = getTable(pattern);

        while (i < text.length) {
            int k = 0;
//          Start from last of the pattern string and try to match it with the text
            while (k < pattern.length && pattern[pL - 1 - k] == text[i - k]) {
                k++;
            }
//          If the text contains substring pattern the the value of k will be equal to length of pattern
            if (k == pL) return i - pL + 1;
            else i += badTable[text[i]];
        }
//      No matching found even after traversing the entire text so return -1
        return -1;

    }
}
