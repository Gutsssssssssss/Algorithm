import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[speeds.length];
        
        for (int i = 0; i < speeds.length; i++) {
            arr[i] = ((100 - progresses[i]) / speeds[i]) + ((100 - progresses[i]) % speeds[i] != 0 ? 1 : 0);
        }
        Queue<Integer> stk = new ArrayDeque<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!stk.isEmpty() && stk.peek() < arr[i]) {
                ans.add(stk.size());
                stk.clear();
                stk.add(arr[i]);
            } else {
                stk.add(arr[i]);
            }
        }
        ans.add(stk.size());
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}