#include<bits/stdc++.h>
using namespace std;
int t, n;
int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> t;
	while(t--) {
		cin >> n;
		int cnt5=0;
		for(int i=5; i<=n; i*=5) {
			cnt5 += n/i;
		}
		cout << cnt5 << '\n';
	}
	return 0;
}