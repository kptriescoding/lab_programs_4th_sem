#include <bits/stdc++.h>
using namespace std;
void findCombination(vector<int> &candidates, int target, vector<vector<int>> &res, vector<int> &temp, int index)
{
    if (target == 0)
    {
        res.push_back(temp);
        return;
    }
    if (index == candidates.size() || target < 0)
    {
        return;
    }
    for (int i = index; i < candidates.size(); i++)
    {
        if (i > index && candidates[i] == candidates[i - 1])
            continue;
        temp.push_back(candidates[i]);
        findCombination(candidates, target - candidates[i], res, temp, i + 1);
        temp.pop_back();
    }
}
vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
{
    sort(candidates.begin(), candidates.end());
    vector<vector<int>> res;
    vector<int> temp;
    findCombination(candidates, target, res, temp, 0);
    return res;
}
int main()
{
    int n, sum;
    vector<vector<int>> res;
    cout << "Enter no of elements of arr" << endl;
    cin >> n;
    vector<int> arr(n);
    cout << "Enter array elements" << endl;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    cout << "Enter resultant sum" << endl;
    cin >> sum;
    res = combinationSum2(arr, sum);
    int m = res.size();
    if (res.size() == 0)
        cout << "Empty set" << endl;
    else
    {
        for (int i = 0; i < m; i++)
        {
            cout << "[";
            for (int j = 0; j < res[i].size(); j++)
            {
                cout << res[i][j];
                if (j < res[i].size() - 1)
                    cout << " ";
            }
            cout << "]";
        }
    }
}
	
	
	
