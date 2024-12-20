#pragma warning(disable: 4996)
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int dist(const pair<int, int> &a, const pair<int, int> &b) {
	return ((a.first - b.first) * (a.first - b.first)) + ((a.second - b.second) * (a.second - b.second));
	} 
bool compare(const pair<int, int> &a, const pair<int, int> &b) { 
	if (a.first < b.first) return true; 
	else if (a.first == b.first) { 
		if (a.second < b.second) return true;
		else return false; 
	}
	else return false;
} int get_triangle_min_value(const pair<int, int> &a, const pair<int, int> &b, const pair<int, int> &c) {
	int min_value = 987654321;
	int one = dist(a, b); if (one < min_value) min_value = one; 
	int two = dist(b, c); if (two < min_value) min_value = two; 
	int three = dist(a, c); if (three < min_value) min_value = three; 
	return min_value; 
} 
int get_square_min_value(const pair<int, int> &a, const pair<int, int> &b, const pair<int, int> &c, const pair<int, int> &d) {
	int min_value = 987654321; 
	int one = dist(a, b); if (one < min_value) min_value = one; 
	int two = dist(b, c); if (two < min_value) min_value = two; 
	int three = dist(c, d); if (three < min_value) min_value = three; 
	int four = dist(d, a); if (four < min_value) min_value = four; 
	int five = dist(a, c); if (five < min_value) min_value = five; 
	int six = dist(b, d); if (six < min_value) min_value = six; 
	return min_value; 
} int main() { 
	ios::sync_with_stdio(0);
	cin.tie(0); 

	vector<pair<int, int>> v; 
	int n; cin >> n;
	for (int i = 0; i < n; i++) { 
		int a, b; cin >> a >> b; v.push_back(make_pair(a, b));
	}
	if (n == 2) {
		cout << dist(v[0], v[1]) << '\n'; return 0; 
	}
	else if (n == 3) { 
		cout << get_triangle_min_value(v[0], v[1], v[2]) << '\n';
		return 0;
	}
	sort(v.begin(), v.end(), compare);
	int min_value = 987654321; 
	for (int i = 0; i < n - 3; i++) { 
		int result = get_square_min_value(v[i], v[i + 1], v[i + 2], v[i + 3]);
		if (result < min_value) min_value = result; 
	}
	cout << min_value << '\n'; 
	return 0;
}

