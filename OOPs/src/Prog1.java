import java.util.*;

class Complex_No {
    public float real_part, imaginary_part;

    public Complex_No() {
    }

    public Complex_No(float real_part, float imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }

    public void display() {
        System.out.println("The Complex Number is " + real_part + "+ i*(" + imaginary_part + ")");
    }
    public void add(float real_part1, float imaginary_part1, float real_part2, float imaginary_part2) {
        this.real_part = real_part1 + real_part2;
        this.imaginary_part = imaginary_part1 + imaginary_part2;
        System.out.println("The Sum is");
        display();
    }

    public void subtract(float real_part1, float imaginary_part1, float real_part2, float imaginary_part2) {
        this.real_part = real_part1 - real_part2;
        this.imaginary_part = imaginary_part1 - imaginary_part2;

        System.out.println("The Difference is");
        display();

    }

    public void add(Complex_No complex1, Complex_No complex2) {
        this.real_part = complex1.real_part + complex2.real_part;
        this.imaginary_part = complex1.imaginary_part + complex2.imaginary_part;

        System.out.println("The Sum is");
        display();
    }

    public void subtract(Complex_No complex1, Complex_No complex2) {

        this.real_part = complex1.real_part - complex2.real_part;
        this.imaginary_part = complex1.imaginary_part - complex2.imaginary_part;

        System.out.println("The Difference is");
        display();
    }
}

public class Prog1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float real_part, imaginary_part;
        System.out.println("Enter the real part of Complex No 1");
        real_part = scan.nextFloat();
        System.out.println("Enter the imaginary part of Complex No 1");
        imaginary_part = scan.nextFloat();

        Complex_No complex1 = new Complex_No(real_part, imaginary_part);

        System.out.println("Enter the real part of Complex No 2");
        real_part = scan.nextFloat();
        System.out.println("Enter the imaginary part of Complex No 2");
        imaginary_part = scan.nextFloat();

        Complex_No complex2 = new Complex_No(real_part, imaginary_part);

        Complex_No class_add = new Complex_No();
        class_add.add(complex1, complex2);

        Complex_No class_sub = new Complex_No();
        class_sub.subtract(complex1, complex2);

        Complex_No direct_add = new Complex_No();
        direct_add.add(complex1.real_part, complex1.imaginary_part, complex2.real_part, complex2.imaginary_part);

        Complex_No direct_sub = new Complex_No();
        direct_sub.subtract(complex1.real_part, complex1.imaginary_part, complex2.real_part, complex2.imaginary_part);
    }

}