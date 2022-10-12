#include <bits/stdc++.h>
using namespace std;
void knapSack(int W, int wt[], int val[], int n)
{
    int K[n + 1][W + 1];
    for (int i = 0; i <= n; i++)
    {
        for (int w = 0; w <= W; w++)
        {
            if (i == 0 || w == 0)
                K[i][w] = 0;
            else if (wt[i - 1] <= w)
                K[i][w] = max(val[i - 1] +
                                  K[i - 1][w - wt[i - 1]],
                              K[i - 1][w]);
            else
                K[i][w] = K[i - 1][w];
                printf("%d\t",K[i][w]);
        }cout<<endl;
    }
    int w=W;
    int res=K[n][w];
    cout<<"the weight included are"<<endl;
    for(int i=n;i>0 && res>0;i--){
        if(res==K[i-1][w]) continue;
        else{
            printf("%d\t",wt[i-1]);
            res=res-val[i-1];
            w=w-wt[i-1];
        }
    }cout<<endl;
    cout << "Maximum total value in a knapsack is" <<  K[n][W];
}
int main()
{
    int n, W;
    cout << "enter the no of weights" << endl;
    cin >> n;
    int val[n], wt[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the wt and value of " << i + 1 << "th items" << endl;
        cin >> wt[i];
        cin >> val[i];
    }
    cout << "Enter the value of knapsack" << endl;
    cin >> W;
    knapSack(W, wt, val, n);
    return 0;
}
