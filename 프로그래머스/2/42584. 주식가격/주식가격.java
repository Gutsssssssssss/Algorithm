import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int N = prices.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                int top = stk.pop();
                answer[top] = (i - top);
            }
            stk.add(i);
        }
        while (!stk.isEmpty()) {
                int top = stk.pop();
                answer[top] = (N - top - 1);
            }
        
        return answer;
    }
}