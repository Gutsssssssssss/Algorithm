import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        int sum = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (q.size() == bridge_length) {
                    sum -= q.poll();
                }
                
                if (sum + truck <= weight) {
                    q.add(truck);
                    sum += truck;
                    answer++;
                    break;
                } else {
                    q.add(0);
                    answer++;
                }
            }
        }
        
        return answer + bridge_length;
    }
}