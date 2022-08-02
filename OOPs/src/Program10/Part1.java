import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = s.nextLine();
        String[] sentence = str.split(" ");
        System.out.println("The penultimate word is "+sentence[sentence.length-2]);
    }
}
