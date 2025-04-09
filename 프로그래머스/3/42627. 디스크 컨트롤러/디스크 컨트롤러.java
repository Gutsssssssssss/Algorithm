import java.util.*;

class Solution {
    public int solution(int[][] jo) {
        int[][] jobs = new int[jo.length][3];
        for (int i = 0; i < jo.length; i++) {
            jobs[i][0] = i;
            jobs[i][1] = jo[i][0];
            jobs[i][2] = jo[i][1];
        }
        // 0: 번호, 1: 시각, 2: 소요
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
        
        int curTime = 0;
        int answer = 0;
        int idx = 0;
        
        while (!pq.isEmpty() || idx < jobs.length) {
            
            while (idx < jobs.length && curTime >= jobs[idx][1]) {
                    pq.add(jobs[idx]);
                    idx++;
                }
            
            if (!pq.isEmpty()) {
                int[] front = pq.poll();
                curTime += front[2];
                answer += (curTime - front[1]);
            } else {
                curTime = jobs[idx][1];
            }
        }
        
        return answer / jobs.length;
    }
}