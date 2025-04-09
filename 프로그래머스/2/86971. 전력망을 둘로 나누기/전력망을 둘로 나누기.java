import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            adj.get(wire[0]).add(wire[1]);
            adj.get(wire[1]).add(wire[0]);
        }
        int answer = Integer.MAX_VALUE / 2;
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            adj.get(wire[0]).remove((Integer) wire[1]);   
            adj.get(wire[1]).remove((Integer) wire[0]);
            boolean[] visited = new boolean[n+1];
            int cnt = dfs(1, adj, visited);
            int val = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, val);
            adj.get(wire[0]).add(wire[1]);
            adj.get(wire[1]).add(wire[0]);
        }
        
        return answer;
    }
    
    int dfs(int here, List<List<Integer>> adj, boolean[] visited) {
        visited[here] = true;
        int cnt = 1;
        for (int next : adj.get(here)) {
            if (visited[next]) continue;
            cnt += dfs(next, adj, visited);
        }
        return cnt;
    }
}