#include<bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    for(int i=0; i<n; i++) {
        cin >> a[i];
    }
    vector<int> dp(n);
    fill(dp.begin(), dp.end(), 1);
    for(int i=0; i<n; i++) {
        for(int j=0; j<i; j++) {
            if(a[i] > a[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }
    cout << *max_element(dp.begin(), dp.end());
    return 0;
}