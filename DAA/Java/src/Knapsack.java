import java.util.Scanner;

public class Knapsack {
    public static int knapsack(int W, int[] wt, int[] val, int n){
        int i,w;
        int[][] K=new int[n+1][W+1];
        for( i=0;i<=n;i++)
            for(w=0;w<=W;w++ ) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        return K[n][W];
    }

    private static int max(int a, int b) {
    if(a>b)return a;
    return b;
    }
    public static void main(String[] args){
        int W,n;
        int[] wt,val;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of weights");
        n=sc.nextInt();
        wt=new int [n];
        val=new int [n];
        System.out.println("Enter the values of the items");
        for(int i=0;i<n;i++)
            val[i]=sc.nextInt();
        System.out.println("Enter the weights of the items");
        for(int i=0;i<n;i++)
            wt[i]=sc.nextInt();
        System.out.println("Enter the value of knapsack");
        W= sc.nextInt();
        System.out.println("Maximum total in the knapsack is "+ knapsack(W,wt,val,n));
    }
}
