#include<bits/stdc++.h>
#define loop(i, n,x) for (i = x; i < n; i++)
using namespace std;
vector < int > v;
int i,n;
 int Partition(int l, int h) {
    int i = l-1, j = 0,pivot=v[h];
loop(j,n,l)if(v[j]<pivot)swap(v[++i],v[j]);
swap(v[++i],v[h]);
return i;
  }
  void Quick_Sort(int l, int h) {
    if (l >= h) return;
    int pi=Partition(l, h);
    Quick_Sort(l, pi-1);
    Quick_Sort(pi + 1, h);
  }
  void printArray() {
    cout << "The Sorted Array is\n";
    loop(i, n,0) cout << v[i] << " ";
  }
int main() {
    cout << "How many numbers\n";
    cin >> n;
    v.resize(n);
    loop(i, n,0) cin >> v[i];
  Quick_Sort(0, n - 1);
  printArray();
}