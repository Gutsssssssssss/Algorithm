import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int idx = 0;
        int cur = 0;
        int sum = 0;
        while (idx < jobs.length || !pq.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= cur) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] front = pq.poll();
                cur += front[1];
                sum += (cur - front[0]);
            } else {
                cur = jobs[idx][0];
            }
        }
        
        return sum / jobs.length;
    }
}