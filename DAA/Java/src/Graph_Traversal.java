import java.util.*;
public class Graph_Traversal {
    public static void bfs(HashMap<Integer ,Boolean>visited,int cur,HashMap<Integer,ArrayList<Integer>> adj_list,ArrayList<Integer> order) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(cur);
        int n;
        ArrayList<Integer> arr;
        while(!queue.isEmpty()){
            cur=queue.remove();
            if(!visited.get(cur)){
                order.add(cur);
                visited.replace(cur,true);
            }
            arr=adj_list.get(cur);
            n=arr.size();
            for(int i=0;i<n;i++){
                if(visited.get(arr.get(i)))continue;
                visited.replace(arr.get(i),true);
                order.add(arr.get(i));
                queue.add(arr.get(i));
            }
        }
    }
    public static void dfs(HashMap<Integer ,Boolean>visited,int cur,HashMap<Integer,ArrayList<Integer>> adj_list,ArrayList<Integer> order) {
        Stack<Integer> stack=new Stack<>();
        stack.push(cur);
        int n;
        ArrayList<Integer> arr;
        while(!stack.empty()){
            cur=stack.pop();
            if(!visited.get(cur)) {
                order.add(cur);
                visited.replace(cur,true);
            }
            arr=adj_list.get(cur);
            n=arr.size();
            for(int i=0;i<n;i++){
                if(visited.get(arr.get(i)))continue;
                visited.replace(arr.get(i),true);
                order.add(arr.get(i));
                stack.push(cur);
                stack.push(arr.get(i));
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int edges,ver1,ver2,i;
        HashMap<Integer,ArrayList<Integer>> adj_list=new HashMap<>();
        HashMap<Integer,Boolean>visited=new HashMap<>();
        ArrayList<Integer> order=new ArrayList<>();
        System.out.println("Enter the number of edges");
        edges= scan.nextInt();
        System.out.println("Enter the connected vertices as v1 v2");
        for(i=0;i<edges;i++) {
            ver1 = scan.nextInt();
            ver2 = scan.nextInt();
            adj_list.computeIfAbsent(ver1, k -> new ArrayList<>());
            adj_list.computeIfAbsent(ver2, k -> new ArrayList<>());
            adj_list.get(ver1).add(ver2);
            adj_list.get(ver2).add(ver1);
            visited.put(ver1, false);
            visited.put(ver2, false);
        }
        int comp=0;
        HashMap<Integer,Boolean> vistited_copy=new HashMap<>(visited);
        System.out.println("The order of tree traversal with DFS is");
        for(Map.Entry<Integer,Boolean> it:visited.entrySet()) {
            if (it.getValue()) continue;
            order.clear();
            dfs(visited, it.getKey(), adj_list, order);
            comp++;
            System.out.println("Component "+comp);
            for (i=0;i<order.size();i++)
                System.out.print(order.get(i)+" ");
            System.out.println();
        }
        visited=new HashMap<>(vistited_copy);
        System.out.println("The order of tree traversal with BFS is");
        for(Map.Entry<Integer,Boolean> it:visited.entrySet()) {
            if (it.getValue()) continue;
            order.clear();
            bfs(visited, it.getKey(), adj_list, order);
            comp++;
            System.out.println("Component " + comp);
            for (i = 0; i < order.size(); i++)
                System.out.print(order.get(i) + " ");
            System.out.println();
        }
    }
}