import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        int answer = 0;
        while (true) {
            if (pq.size() == 1) {
                if (pq.peek() < K) return -1;
                else break;
            }
            int a = pq.poll();
            int b = pq.poll();
            if (a >= K && b >= K) break;
            int val = a + b * 2;
            pq.add(val);
            answer++;
        }
        
        return answer;
    }
}