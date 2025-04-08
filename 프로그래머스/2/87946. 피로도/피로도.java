class Solution {
    int N;
    int[][] dungeons;
    int ret;
    public int solution(int k, int[][] dungeons) {
        this.N = dungeons.length;
        this.dungeons = dungeons;
        boolean[] visited = new boolean[N+1];
        dfs(k, visited, 0);
        int answer = ret;
        return answer;
    }
    
    void dfs(int hp, boolean[] visited, int depth) {
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (hp < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(hp - dungeons[i][1], visited, depth + 1);
            visited[i] = false;
        }
        ret = Math.max(ret, depth);
    }
}