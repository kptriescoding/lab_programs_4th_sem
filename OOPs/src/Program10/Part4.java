package Program10;

import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = s.nextLine();
        String[] arr = str.split(" ");
        System.out.println("The words in the sentence are");
        for(String st:arr) System.out.println(st);
    }
}
