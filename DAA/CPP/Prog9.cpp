#include <bits/stdc++.h>
using namespace std;
int * djikstra(int V, int **graph, int src)
{
    int *dist=new int [V];
	for(int i=0;i<V;i++) dist[i]=INT_MAX;
    dist[src] = 0;
	bool *fin=new bool[V];
	for(int i=0;i<V;i++) fin[i]=false;
    for (int count = 0; count < V - 1; count++)
    {
        int u = -1;
        for (int i = 0; i < V; i++)
            if (!fin[i] && (u == -1 || dist[i] < dist[u]))
                u = i;
        fin[u] = true;
        for (int v = 0; v < V; v++)

            if (graph[u][v] != 0 && fin[v] == false)
                dist[v] = min(dist[v], dist[u] + graph[u][v]);
    }
    return dist;
}
int main()
{
    int V, src, E;
    cout << "Enter no of vertices of graph" << endl;
    cin >> V;
    int *graph[V];
    for (int i = 0; i < V; i++)
        graph[i] = new int[V];
    cout << "Enter weight adjacency matrix" << endl;
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            cin >> graph[i][j];
        }
    }
    cout << "Enter source vertex" << endl;
    cin >> src;
	int *res=new int[V];
     res = djikstra(V, graph, src);
    for (int i = 0; i < V; i++)
    {
        cout << "distance from " << src << " to " << i << " is " << res[i] << endl;
    }
    return 0;
}
