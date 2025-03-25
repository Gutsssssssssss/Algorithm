class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, visited, computers, n);
            }
        }
        
        int answer = cnt;
        return answer;
    } // main
    void dfs(int here, boolean[] visited, int[][] computers, int n) {
        visited[here] = true;
        for (int i = 0; i < n; i++) {
            if (here == i) continue;
            if (visited[i]) continue;
            if (computers[here][i] == 1) {
                dfs(i, visited, computers, n);
            }
        }
    }
} // class