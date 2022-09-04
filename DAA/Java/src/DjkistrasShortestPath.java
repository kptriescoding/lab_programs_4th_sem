import java.util.Arrays;
import java.util.Scanner;

public class Djkistras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = s.nextInt();
        int[][] adj = new int[n][n];
        System.out.println("ENter adjacency matrix");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter the start vertex");
        int start = s.nextInt();

        int[] distance = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);


        distance[start] = 0;
        vis[start] = true;


        for (int i = 1; i < n; i++) {
            int choosen = 0;
            int min = Integer.MAX_VALUE;

//            Choose the minimum weighted edge from source + which is unvisited
            for(int j = 0;j<n;j++){
                if( adj[start][j]!=0 && !vis[j] && adj[start][j]<min){
                    min = adj[start][j];
                    choosen = j;
                }
            }

            vis[choosen] = true;
            distance[choosen] = Math.min(distance[choosen],adj[start][choosen]);
            for(int j = 0;j<n;j++) {
//             To check connectivity and then try to update minimum distance
                if(adj[choosen][j]!=0)
                distance[j] = Math.min(distance[j], adj[choosen][j]+ distance[choosen]);
            }

        }
        System.out.println("Minimum distances from source to vertices are :");
        for(int i:distance) System.out.print(i+" ");
        System.out.println();
    }
}
