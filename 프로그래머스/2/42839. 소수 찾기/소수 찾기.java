import java.util.*;

class Solution {
    int N;
    String numbers;
    Set<Integer> set;
    public int solution(String numbers) {
        N = numbers.length();
        this.numbers = numbers;
        set = new HashSet<>();
        
        boolean[] visited = new boolean[N];
        go(visited, 0, "");
        
        int answer = 0;
        for (int i : set) {
            if (check(i)) answer++;
        }
        return answer;
    } // main
    
    boolean check(int val) {
        if (val < 2) return false;
        for (int i = 2; i < val; i++) {
            if (val % i == 0) return false;
        }
        return true;
    }
    
    void go(boolean[] visited, int depth, String s) {
        if (depth == N) return;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            set.add(Integer.parseInt(s + numbers.charAt(i)));
            go(visited, depth + 1, s + numbers.charAt(i));
            visited[i] = false;
        }
    }
}