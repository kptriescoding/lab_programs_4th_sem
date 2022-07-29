import java.util.Scanner;

public class Program8 {
    @FunctionalInterface
    interface performOperation {
        boolean operation(int num);

    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        performOperation checkEven = (int v)-> v % 2 == 0;

        performOperation checkPrime = (int v)->{
            for(int i = 2;i<Math.sqrt(v);i++){
                if(v%i==0) return false;
            }
            return true;
        };

        performOperation checkPalindrome = (int v)->{
            String str = String.valueOf(v);
            for(int i = 0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(str.length()-1-i))
                    return false;
            }
            return true;
        };
        int n;
        System.out.println("Enter the number which you want to check even or odd");
        n = s.nextInt();
        boolean isEven  = checkEven.operation(n);
        if(isEven) System.out.println("The given number "+n+" is even");
        else System.out.println("The given number "+n+" is odd");

        System.out.println("Enter the number which you want to check prime or not");
        n = s.nextInt();
        boolean isPrime  = checkPrime.operation(n);
        if(isPrime) System.out.println("The given number "+n+" is prime");
        else System.out.println("The given number "+n+" is not prime");

        System.out.println("Enter the number which you want to check palindrome or not");
        n = s.nextInt();
        boolean isPalindrome  = checkPalindrome.operation(n);
        if(isPalindrome) System.out.println("The given number "+n+" is pallindrome");
        else System.out.println("The given number "+n+" is not pallindrome");
    }
}
