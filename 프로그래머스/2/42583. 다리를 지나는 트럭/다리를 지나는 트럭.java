import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        int idx = 0;
        int sum = 0;
        int answer = 0;
        while (idx < truck_weights.length) {
            answer++;
            sum -= q.poll();
            
            if (sum + truck_weights[idx] <= weight) {
                q.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                q.add(0);
            }
        }
        return answer + bridge_length;
    }
}