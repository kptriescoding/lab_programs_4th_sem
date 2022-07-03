#include <bits/stdc++.h>
using namespace std;
void topologicalSortBFS(vector<int> adj[], int V)
{
    vector<int> in_degree(V, 0);
    for (int u = 0; u < V; u++)
    {
        for (int x : adj[u])
            in_degree[x]++;
    }
    queue<int> q;
    for (int i = 0; i < V; i++)
        if (in_degree[i] == 0)
            q.push(i);
    while (!q.empty())
    {
        int u = q.front();
        q.pop();
        cout << u << " ";

        for (int x : adj[u])
            if (--in_degree[x] == 0)
                q.push(x);
    }
}
void DFS(vector<int> adj[], int u, stack<int> &st, bool visited[])
{
    visited[u] = true;
    for (int v : adj[u])
    {
        if (visited[v] == false)
            DFS(adj, v, st, visited);
    }
    st.push(u);
}
void topologicalSortDFS(vector<int> adj[], int V)
{
    bool visited[V];
    for (int i = 0; i < V; i++)
        visited[i] = false;
    stack<int> st;
    for (int u = 0; u < V; u++)
    {
        if (visited[u] == false)
        {
            DFS(adj, u, st, visited);
        }
    }
    while (st.empty() == false)
    {
        int u = st.top();
        st.pop();
        cout << u << " ";
    }
}
void addEdge(vector<int> adj[], int u, int v)
{
    adj[u].push_back(v);
}
int main()
{
    int V, E, a, b;
    cout << "Enter no of vertices" << endl;
    cin >> V;
    vector<int> adj[V];
    int max_edges = V * (V - 1);
    cout << "Enter no of edges  u want between  1 &" << max_edges << endl;
    cin >> E;
    for (int i = 0; i < E; i++)
    {
        cout << "Enter source and destination vertex from 0 to" << V - 1 << endl;
        cin >> a >> b;
        addEdge(adj, a, b);
    }
    cout << "Following is a Topological Sort of from DFS" << endl;
    topologicalSortDFS(adj, V);
    cout << endl;
    cout << "Following is a Topological Sort of from vertex deletion method" << endl;
    topologicalSortBFS(adj, V);
    cout << endl;
    return 0;
}
