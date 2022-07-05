import java.util.*;

public class TopologicalSort {
    static ArrayList<Integer> notVisited, visited;
    static HashMap<Integer, ArrayList<Integer>> links = new HashMap<>();
    static HashMap<Integer, Integer> inDegree = new HashMap<>();
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of nodes present in graph");
        int n = s.nextInt();
        //        Initializing dynamic arrays

        notVisited = new ArrayList<>();

        visited = new ArrayList<>();
//        Formation of graph by taking inputs of directed links and node data information from the user
        for (int i = 0; i < n; i++) {
            int data, nl;
            System.out.printf("Enter node %d data and number of directed links from that node in the graph\n", i + 1);
            data = s.nextInt();
            nl = s.nextInt();

            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j < nl; j++) {
                if (j == 0) System.out.printf("Enter the nodes directed from node %d\n", data);
                int ins = s.nextInt();
                l.add(ins);
                if (inDegree.containsKey(ins))
                    inDegree.put(ins, inDegree.get(ins) + 1);
                else inDegree.put(ins, 1);
            }

            notVisited.add(data);
            links.put(data, l);
        }
//      Put all vertices with zero inDegree onto queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (!inDegree.containsKey(notVisited.get(i))) q.add(notVisited.get(i));
        topVerRem(q);

        topoDfs();
        System.out.println("The topological sorting acc to dfs method is:");
        while (!st.isEmpty()) System.out.print(st.pop() + " ");
        System.out.println();
    }

    static void topVerRem(Queue<Integer> q) {
        System.out.println("The topological ordering of given graph using vertex removal method is");

        while ((!q.isEmpty())) {
            int d = q.remove();
            System.out.print(d + " ");
            for (int i = 0; i < links.get(d).size(); i++) {
                int n = inDegree.get(links.get(d).get(i));
//                if inDegree becomes zero add the node onto the queue
                if (n == 1) q.add(links.get(d).get(i));
//                else decrease the inDegree by one
                else inDegree.put(links.get(d).get(i), n - 1);

            }
        }
        System.out.println();
    }

    // DFS which is used in topological ordering using DFS method
    static void Dfs(int n) {
//        All nodes are visited
        if (notVisited.size() == 0) return;
//          Remove the current node from not visited list
        notVisited.remove((Integer) n);
//        Recursively traverse all directed nodes from present node
        for (int i = 0; i < links.get(n).size(); i++)
            if (notVisited.contains(links.get(n).get(i)))
                Dfs(links.get(n).get(i));
//      After traversing all adjacent nodes put this node onto stack
        st.add(n);
    }

    static void topoDfs() {
//        Make sure all nodes are visited
        while (notVisited.size() != 0) {
            int n = notVisited.remove(0);
            Dfs(n);
        }
    }

}
