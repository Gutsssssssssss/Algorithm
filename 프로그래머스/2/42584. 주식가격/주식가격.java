import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        
        int N = prices.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                int t = stk.pop();
                
                answer[t] = i-t;       
                
            }
            stk.add(i);
        }
        System.out.println(stk.size());
        while (!stk.isEmpty()) {
            int t = stk.pop();
            answer[t] = N - t - 1;
        }
        
        
        return answer;
    } // main
}