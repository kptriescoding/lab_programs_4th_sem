#include <bits/stdc++.h>
using namespace std;
void computationtable(string str,int pos[256])
{
    int n = str.length();
    for (int i = 0; i <256; i++)
        pos[i] = n;
    for (int i = 0; i <= n-2; i++)
    pos[str[i]] = n-1-i;
}

int Harspool_matching(string pat, string txt)
{
    int pos[256];
    computationtable(pat,pos);
    int m = pat.length();
    int n = txt.length();
    int i = m - 1;
    while (i <= n - 1)
    {
        int k = 0;
        while ((k <= m - 1) && txt[i - k] == pat[m - 1 - k])
            k++;
        if (k == m)
            return i - m + 1;
        else
            i = i + pos[txt[i]];
    }
    return -1;
}
int main()
{
    string str, ptr;
    cout << "Enter the text: ";
    getline(cin,str);
    cout << "Enter pattern: ";
    getline(cin,ptr);
    int res = Harspool_matching(ptr, str);
    if (res == -1)
        cout << "Not found" << endl;
    else
        cout << "Pattern found at position" << res + 1 << endl;
    return 0;
}