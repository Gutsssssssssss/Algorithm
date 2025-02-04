#include<bits/stdc++.h>
using namespace std;
int a, b, c, d;
map<pair<int, int>, int> m;
queue<pair<int, int>> q;
void enqueue(int x, int y, int d) {
	if(m[{x, y}]) return;
	m[{x, y}] = d+1;
	q.push({x, y});
	return;
}
int bfs(int x, int y) {
	m[{x, y}] = 1;
	q.push({x, y});
	while(q.size()) {
		tie(x, y) = q.front(); q.pop();
		
		enqueue(a, y, m[{x, y}]);
		enqueue(x, b, m[{x, y}]);
		enqueue(0, y, m[{x, y}]);
		enqueue(x, 0, m[{x, y}]);
		enqueue(min(a, x+y), max(0, x+y-a), m[{x, y}]);
		enqueue(max(0, x+y-b), min(b, x+y), m[{x, y}]);
	}
	if(m[{c, d}]) return m[{c, d}] - 1;
	else return -1;
}
int main() {
	cin >> a >> b >> c >> d;
	cout << bfs(0, 0);
	return 0;
}