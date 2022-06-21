#include <bits/stdc++.h>
using namespace std;
void BFS(vector<int> adj[], int s, bool visited[])
{
    queue<int> q;

    visited[s] = true;
    q.push(s);

    while (q.empty() == false)
    {
        int u = q.front();
        q.pop();
        cout << u << " ";

        for (int v : adj[u])
        {
            if (visited[v] == false)
            {
                visited[v] = true;
                q.push(v);
            }
        }
    }
}
int BFSD(vector<int> adj[], int V)
{
    bool visited[V];
    for (int i = 0; i < V; i++)
        visited[i] = false;
    int cnt = 0;
    for (int i = 0; i < V; i++)
    {
        if (visited[i] == false)
        {
            BFS(adj, i, visited);
            cnt++;
        }
    }
    return cnt;
}
void DFSRec(vector<int> adj[], int s, bool visited[])
{
    visited[s] = true;
     cout<<s<<" ";
    for (int u : adj[s])
    {
        if (visited[u] == false)
            DFSRec(adj, u, visited);
    }
}

int DFS(vector<int> adj[], int V)
{
    int count = 0;
    bool visited[V];
    for (int i = 0; i < V; i++)
        visited[i] = false;

    for (int i = 0; i < V; i++)
    {
        if (visited[i] == false)
        {
            DFSRec(adj, i, visited);
            count++;
        }
    }
    return count;
}

void addEdge(vector<int> adj[], int u, int v)
{
    adj[u].push_back(v);
    adj[v].push_back(u);
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
        cout << "Enter edge vertices from 0 to" << V - 1 << endl;
        cin >> a >> b;
        addEdge(adj, a, b);
    }
    cout << "Following is Breadth First Traversal: " << endl;
    int p = BFSD(adj, V);
    cout << endl;
    cout << "No of disconnected component in graph is " << p << endl;
    cout << "Following is Depth First Traversal: " << endl;
    int q = DFS(adj, V);
    cout << endl;
    cout << "No of disconnected component in graph is " << q << endl;

    return 0;
}
