import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int val = ((100 - progresses[i]) / speeds[i]) + (((100 - progresses[i]) % speeds[i]) != 0 ? 1 : 0);
            System.out.println(val);
            if (!q.isEmpty() && q.peek() < val) {
                ans.add(q.size());
                q.clear();
            }
            q.add(val);
        }
        if (q.size() > 0) ans.add(q.size());
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}