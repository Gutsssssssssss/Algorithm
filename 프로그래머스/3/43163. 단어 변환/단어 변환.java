import java.util.*;
class Solution {
    final int INF = Integer.MAX_VALUE / 2;
    String target;
    String[] words;
    int N;
    int answer = INF;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        this.N = words.length;
        
        boolean[] visited = new boolean[N];
        
        dfs(begin, 0, visited);
        return answer == INF ? 0 : answer;
    }
    
    boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1 ? true : false;
    }
    
    void dfs(String cur, int idx, boolean[] visited) {
        if (idx > N) return;
        if (cur.equals(target)) {
            answer = Math.min(answer, idx);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (check(cur, words[i])) {
                dfs(words[i], idx + 1, visited);
            } 
            visited[i] = false;
        }
    }
}