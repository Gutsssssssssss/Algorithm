#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    int a[n];
    for(int i=0; i<n; i++) {
        cin >> a[i];
    }
    vector<int> lis;
    for(int i=0; i<n; i++) {
        vector<int>::iterator pos = lower_bound(lis.begin(), lis.end(), a[i]);
        if(pos == lis.end()) {
            lis.push_back(a[i]);
        } else {
            *pos = a[i];
        }
    }
    cout << lis.size() << '\n';
    
    return 0;
}