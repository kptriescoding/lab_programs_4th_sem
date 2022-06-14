#include<bits/stdc++.h>
#define loop(i, n) for (i = 0; i < n; i++)
using namespace std;
vector < int > v;
int i,n;
 void Merge(int l, int mid, int h) {
    int i = 0, j = 0, k = l,n1 = mid - l + 1, n2 = h - mid;
    vector < int > v1(n1), v2(n2);
    loop(i, n1) v1[i] = v[k++];
    loop(j, n2) v2[j] = v[k++];
    i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (v1[i] <= v2[j]) v[k++] = v1[i++];
      else v[k++] = v2[j++];
    }
    while (i < n1) v[k++] = v1[i++];
    while (j < n2) v[k++] = v2[j++];
  }
  void Merge_Sort(int l, int h) {
    if (l >= h) return;
    int mid = (l + h) / 2;
    Merge_Sort(l, mid);
    Merge_Sort(mid + 1, h);
    Merge(l, mid, h);
  }
  void printArray() {
    cout << "The Sorted Array is\n";
    loop(i, n) cout << v[i] << " ";
  }
int main() {
    cout << "How many numbers\n";
    cin >> n;
    v.resize(n);
    loop(i, n) cin >> v[i];
  Merge_Sort(0, n - 1);
  printArray();
}