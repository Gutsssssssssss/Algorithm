import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (true) {
            if (pq.size() <= 1) {
                if (pq.peek() < K) return -1;
                return answer;
            }
            int first = pq.poll();
            int second = pq.poll();
            if (first >= K) break;
            
            int val = (first + second * 2);
            pq.add(val);
            answer++;
        }
        return answer;
    }
}