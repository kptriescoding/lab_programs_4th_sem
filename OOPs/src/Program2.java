import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        String tname, tid, tstreet, tstate, tcountry, tusn, tcity;
        int ne, ns, nc;
        Address add;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of students ,colleges,employees one by one");
        ns = s.nextInt();
        nc = s.nextInt();
        ne = s.nextInt();
        s.nextLine();
        Student[] sArray = new Student[ns];
        Employee[] eArray = new Employee[ne];
        College[] cArray = new College[nc];

        for (int i = 0; i < ns; i++) {
            System.out.println("Enter the name of " + i + "th student and his USN");
            tname = s.nextLine();
            tusn = s.nextLine();
            add = Address.takeAddress(tname);
            sArray[i] = new Student(tname, tusn, add);
        }
        for (int i = 0; i < ne; i++) {
            System.out.printf("Enter the name of %dth the Second.College", i);
            tname = s.nextLine();
            add = Address.takeAddress(tname);
            cArray[i] = new College(tname, add);
        }

        for (int i = 0; i < ne; i++) {

            System.out.printf("Enter the name of %dth employee and his ID\n", i);
            tname = s.nextLine();
            tid = s.nextLine();
            add = Address.takeAddress(tname);
            eArray[i] = new Employee(tid, tname, add);
        }

        System.out.printf("\tSecond.Student details are :\n%15s%15s%15s%15s%15s%15s\n", "Name", "USN", "Street Num", "City", "State", "Country");
        for (Student student : sArray) {
            System.out.printf("%15s%15s%15s%15s%15s%15s\n", student.name, student.usn, student.address.streetNum, student.address.city, student.address.state, student.address.country);
        }
        System.out.printf("\tSecond.College details are :%15s%15s%15s%15s%15s\n", "Name", "Street Num", "City", "State", "Country");
        for (College college : cArray) {
            System.out.printf("%15s%15s%15s%15s%15s\n", college.name, college.address.streetNum, college.address.city, college.address.state, college.address.country);
        }
        System.out.printf("\tSecond.Employee details are:\n%15s%15s%15s%15s%15s%15s\n", "Name", "Second.Employee Id", "Street Num", "City", "State", "Country");
        for (Employee employee : eArray) {
            System.out.printf("%15s%15s%15s%15s%15s%15s\n", employee.name, employee.empID, employee.address.streetNum, employee.address.city, employee.address.state, employee.address.country);
        }

    }

}

class Address {
    int streetNum;
    String city, state, country;

    public Address() {
    }

    static Address takeAddress(String per) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Enter address details of %s one by one as mentioned\n", per);
        Address ad = new Address();
        System.out.print("Enter Stree No:");
        ad.streetNum = s.nextInt();
        s.nextLine();
        System.out.print("Enter city:");
        ad.city = s.nextLine();
        System.out.print("Enter State:");
        ad.state = s.nextLine();
        System.out.print("Enter Country:");
        ad.country = s.nextLine();
        System.out.println();
        return ad;
    }
}

class Student {
    String usn, name;
    Address address;

    public Student(String usn, String name, Address address) {
        this.usn = usn;
        this.name = name;
        this.address = address;
    }

}

class College {
    String name;
    Address address;

    public College(String name, Address address) {
        this.name = name;
        this.address = address;
    }

}

class Employee {
    String empID, name;
    Address address;

    public Employee(String empID, String name, Address address) {
        this.empID = empID;
        this.name = name;
        this.address = address;
    }

}
