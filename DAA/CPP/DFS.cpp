#include <bits/stdc++.h>
using namespace std;
void DFS(map<int, vector<int> > adjacency_list, map<int, bool> &visited, int cur, vector<int> &v)
{
    int ver;
    if (visited[cur])
        return;
    v.push_back(cur);
    visited[cur] = true;
    for (int i = 0; i < adjacency_list[cur].size(); i++)
    {
        ver = adjacency_list[cur][i];
        if (!visited[ver])
            DFS(adjacency_list, visited, ver, v);
    }
    return;
}
void DFS_stack(map<int, vector<int> > adjacency_list, map<int, bool> &visited, int cur, vector<int> &v)
{
    int ver;
    if (visited[cur])
        return;
    v.push_back(cur);
    visited[cur] = true;
    for (int i = 0; i < adjacency_list[cur].size(); i++)
    {
        ver = adjacency_list[cur][i];
        if (!visited[ver])
            DFS(adjacency_list, visited, ver, v);
    }
    return;
}
// void BFS(map<int, vector<int> > adjacency_list, vector<bool> visited, int cur, vector<int> &v){

// }
int main()
{
    int vertex, edges, v1, v2;
    cout << "Enter the No of vertex\n";
    cin >> vertex;
    cout << "No of edges\n";
    cin >> edges;
    cout << "Enter the V-V connections(0,based indexing)\n";
    map<int, vector<int> > adjacency_list;
    map<int, bool> visited;
    for (int i = 0; i < edges; i++)
    {
        cin >> v1 >> v2;
        visited[v1] = false;
        visited[v2] = false;
        adjacency_list[v1].push_back(v2);
    }
    int st;
    vector<int> v;
    map<int,bool> visited_copy=visited;
    cout << "The output with DFS is\n";
    for (auto it:visited)
    {
        if (it.second)
            continue;
        v.clear();
        st = it.first;
        DFS(adjacency_list, visited, st, v);
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        cout << "\n";
    }
    v.clear();
    visited=visited_copy;
    cout << "The output with BFS is\n";
    for (auto it:visited)
    {
        if (it.second)
            continue;
        v.clear();
        st = it.first;
        DFS(adjacency_list, visited, st, v);
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        cout << "\n";
    }
}