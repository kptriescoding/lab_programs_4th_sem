package Program9;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the testing string ");
        String str = s.nextLine();
        str = str.replace("python","#eds&8");
        str = str.replace("java","python");
        str = str.replace("#eds&8","java");
        System.out.println("The replaced String is\n"+str);

    }
}
