import java.util.*;
class Solution {
    List<List<Integer>> adj;
    public int solution(int n, int[][] wires) {
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        if (n == 2) return 0;
        
        int answer = Integer.MAX_VALUE / 2;
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            answer = Math.min(answer, bfs(wire[0], wire[1], adj));
        }
        
        return answer;
    } // main
    int bfs(int v1, int v2, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        
        visited[v1] = true;
        visited[v2] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v2);
        int cnt1 = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                cnt1++;
                q.add(next);
            }
        }
        
        int cnt2 = 1;
        visited = new boolean[adj.size()];
        q.add(v1);
        visited[v1] = true;
        visited[v2] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                cnt2++;
                q.add(next);
            }
        }
        System.out.println(cnt1 + " : " + cnt2);
        return Math.abs(cnt1 - cnt2);
    }
}