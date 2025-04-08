import java.util.*;

class Solution {
    public int solution(int[][] jobss) {
        int[][] jobs = new int[jobss.length][3];
        for (int i = 0; i < jobss.length; i++) {
            jobs[i][0] = i;
            jobs[i][1] = jobss[i][0];
            jobs[i][2] = jobss[i][1];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        int cur = 0;
        int sum = 0;
        int idx = 0;
        
        while (!pq.isEmpty() || idx < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][1] <= cur) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                cur += job[2];
                sum += (cur - job[1]);
            } else {
                cur = jobs[idx][1];
            }
        } 
        
        
        
        int answer = sum / jobs.length;
        return answer;
    }
}