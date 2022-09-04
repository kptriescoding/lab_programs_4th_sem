import java.util.Scanner;

public class Prims {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = s.nextInt();
        int[][] adj = new int[n][n];
        System.out.println("Enter adjacency matrix");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = s.nextInt();
            }
        }

        boolean[] vis = new boolean[n];
//      Mark any node visited and start from that node
        vis[0] = true;
        int total = 0;

        for (int i = 1; i < n; i++) {
//            Pick the least weighted edge from all the visited vertices  to unvisited vertices
            int d = Integer.MAX_VALUE;
            int vertex = 0;
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    for (int k = 0; k < n; k++) {
                        if ( adj[j][k]!=0 && !vis[k] && d > adj[j][k]) {
                            d = adj[j][k];
                            vertex = k;
                        }
                    }
                }
            }
//            Update total and mark the node which was picked as visited
            total += d;
            vis[vertex] = true;

        }
        for(boolean b:vis) System.out.print(b+" ");
        System.out.println("The value of the total is "+total);
    }


}
