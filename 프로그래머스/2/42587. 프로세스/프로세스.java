import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        int answer = 0;
        boolean[] check = new boolean[priorities.length];
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            boolean flag = false;
            for (int i = 0; i < priorities.length; i++) {
                if (check[i]) continue;
                if (priorities[i] > priorities[cur]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                q.add(cur);
            } else {
                if (cur == location) {
                    answer = cnt;
                }
                check[cur] = true;
                cnt++;    
            }
            
        }
        
        return answer;
    }
}