import java.util.Scanner;

class Circle{
    double radius;
    String color;

    Circle(double radius){this.radius=radius;}
    Circle(double radius,String color){this.radius=radius;this.color=color;}
    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}

class Cylinder extends Circle{
double height;
    Cylinder(double radius,double height) {
        super(radius);
        this.height=height;
    }
    Cylinder(double radius,double height,String color){
        super(radius,color);
        this.height=height;
    }
    public double getHeight(){return this.height;}
    public double getArea(){return 2*Math.PI*radius*height;}
    public double getVolume(){return Math.PI*radius*radius*height;}
}
public class Program3 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        double tr,th;
        String tc;
        System.out.println("Enter radius , height,Color of first Cylinder");
        tr = s.nextDouble();th=s.nextDouble();s.nextLine();
        tc = s.nextLine();
        Cylinder c1 = new Cylinder(tr,th,tc);
        System.out.println("Enter radius,height,Color of 2nd Cylinder");
        tr = s.nextDouble();th=s.nextDouble();s.nextLine();
        tc = s.nextLine();
        Cylinder c2 = new Cylinder(tr,th,tc);
        if(c1.getArea()==c2.getArea() && c1.getVolume()==c2.getVolume() && c1.color.equals(c2.color))
            System.out.println("Cylinders are equal");
        else
            System.out.println("Cylinders are not equal ");
    }
}
