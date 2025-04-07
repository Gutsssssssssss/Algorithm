import java.util.*;

class Solution {
    int N;
    String numbers;
    boolean[] che;
    int answer;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        this.numbers = numbers;
        che = new boolean[100000000];
        N = numbers.length();
        Arrays.fill(che, true);
        che[0] = che[1] = false;
        for (int i = 2; i * i <= 9999999; i++) {
            if (!che[i]) continue;
            for (int j = i * i; j <= 9999999; j += i) {
                che[j] = false;
            }
        }
        // true -> 소수
        
        answer = 0;
        boolean[] visited = new boolean[N];
        List<Integer> list = new ArrayList<>();
        go(visited, 0, "");
        for (int i : set) {
            System.out.println(i);
            if (che[i]) answer++;
        }
        return answer;
    }
    
    void go(boolean[] visited, int depth, String s) {
        
        if (depth > N) return;
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            set.add(Integer.parseInt(s + numbers.charAt(i)));
            go(visited, depth + 1, s + numbers.charAt(i));
            visited[i] = false;
            
        }
    }
}