import java.util.*;

class Solution {
    List<String> ans;
    boolean[] visited;
    String[][] tickets;
    
    public List<String> solution(String[][] tickets) {
        this.tickets = tickets;
        ans = new ArrayList<>();
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> b[1].compareTo(a[1]));
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(path, "ICN");
        String[] answer = {};
        return ans;
    }
    
    void dfs(List<String> path, String here) {
        if (path.size() == tickets.length + 1) {
            ans = new ArrayList<>(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i][0].equals(here)) continue;
            if (visited[i]) continue;
            visited[i] = true;
            path.add(tickets[i][1]);
            dfs(path, tickets[i][1]);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}