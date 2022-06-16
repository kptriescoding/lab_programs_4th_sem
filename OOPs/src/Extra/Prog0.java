package Extra;

import java.util.Scanner;

class changeTime {
    int given_sec;
    Scanner scan = new Scanner(System.in);
    int sec, min, hours;

    public changeTime() {
        System.out.println("Enter the time in seconds");
        given_sec = scan.nextInt();
        secToTime();
        System.out.println(" when converted is " + hours + ":" + min + ":" + sec);
    }

    public void secToTime() {
        hours = given_sec / 3600;
        given_sec = given_sec % 3600;
        min = given_sec / 60;
        given_sec = given_sec % 60;
        sec = given_sec;
    }
}

class combination {
    int n, s = 0;
    Scanner scan = new Scanner(System.in);

    public combination() {
        System.out.println("Enter n");
        n = scan.nextInt();
        for (int i = 0; i < 10; i++)
            findValue(3, i);
        System.out.println("The possible combinations are " + s);

    }

    public void findValue(int x, int sum) {
        if (x == 0) {
            if (sum == n) s++;
            return;
        }
        for (int i = 0; i < n; i++)
            if(sum+i<=n)findValue(x - 1, sum + i);
    }
}

class staircase {
    int n, x = 0, n1;
    Scanner scan = new Scanner(System.in);

    public staircase() {
        System.out.println("Enter no of coins");
        n = scan.nextInt();
        findAns();
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < n1; i++)
            System.out.print("*");
        System.out.println();
    }

    public void findAns() {
        n1 = n;
        while (n1 >= x) n1 -= x++;
    }

}

class rearrangeArray {
    Scanner scan = new Scanner(System.in);
    int[] v1, v2;
    int n;

    public rearrangeArray() {
        System.out.println("Enter the no of elements");
        n = scan.nextInt();
        v1 = new int[n];
        v2 = new int[n];
        solve();
        System.out.println("The modified array is");
        for (int i = 0; i < n; i++)
            System.out.print(v2[i]+" ");
        System.out.println();
    }

    void solve() {
        System.out.println("Enter the elements");
        int j = 0;
        for (int i = 0; i < n; i++) v1[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            System.out.print(v1[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            if (v1[i] % 2 == 1)
                v2[j++] = v1[i];
        for (int i = 0; i < n; i++)
            if (v1[i] % 2 == 0)
                v2[j++] = v1[i];
    }
}

class digits {
    Scanner scan = new Scanner(System.in);
    int a, b, c;

    public digits() {
        System.out.println("Enter the 3 numbers");
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        if (a % 10 == b % 10 || b % 10 == c % 10 || c % 10 == a % 10) System.out.println("True");
        else System.out.println("False");
    }
}

class findElement {
    Scanner scan = new Scanner(System.in);
    int[][] a;
    int m, n, x;

    public findElement() {
        takeInput();
        findEle();
    }
    public void takeInput(){
        System.out.println("Enter rows and columns");
        m = scan.nextInt();
        n = scan.nextInt();
        System.out.println("Enter the elements");
        a = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = scan.nextInt();
        System.out.println("Enter the element to be found");
        x = scan.nextInt();
    }
    public void findEle(){
        boolean found=false;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(a[i][j]==x) {
                    found=true;
                    System.out.println("The ele "+x+" has the position i = "+i+" j = "+j);
                }
        if(!found) System.out.println("The ele "+x+" could not be found");
    }
}

public class Prog0 {
    public static void main(String[] args) {
        new changeTime();
        new combination();
        new staircase();
        new rearrangeArray();
        new digits();
        new findElement();
    }
}
