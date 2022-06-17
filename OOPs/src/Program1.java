package Java_Optimized;

import java.util.Scanner;

public class Program1 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Enter the real and imaginary part of the first complex number one by one");

        float r1,i1;
        r1 = s.nextFloat();
        i1 = s.nextFloat();
        Complex num1 = new Complex(r1,i1);
        
        System.out.println("Enter the real and imaginary part of the second complex number one by one");
        float r2,i2;
        r2 = s.nextFloat();
        i2 = s.nextFloat();
        Complex num2 = new Complex(r2,i2);
        
        Complex addition= num1.add(num2);
        Complex subtraction= num1.subtract(num2);
        
        System.out.println("The addition of first two complex number is "+addition.real+"+i*("+addition.imaginary+")");
        System.out.println("The subtraction of first two complex number is "+subtraction.real+"+i*("+subtraction.imaginary+")");
    }

}

class Complex {
    float real;
    float imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex add(Complex number) {
        float real = this.real + number.real;
        float imaginary = this.imaginary + number.imaginary;
        return new Complex(real, imaginary);
    }

    public Complex add(Complex number1, Complex number2) {
        float real = this.real + number2.real + number1.real;
        float imaginary = this.imaginary + number1.imaginary + number2.imaginary;
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex number) {
        float real = this.real - number.real;
        float imaginary = this.imaginary - number.imaginary;
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex number1, Complex number2) {
        float real = this.real + number2.real - number1.real;
        float imaginary = this.imaginary + number1.imaginary - number2.imaginary;
        return new Complex(real, imaginary);
    }

    public void display() {
        System.out.println("The given complex number is" + this.real + "+i" + this.imaginary);
    }
}
