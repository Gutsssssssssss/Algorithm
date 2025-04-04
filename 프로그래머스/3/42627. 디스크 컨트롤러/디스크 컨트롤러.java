import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1) jobs 배열을 [요청 시각, 소요 시간, 작업 번호]로 확장
        int n = jobs.length;
        int[][] extendedJobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            extendedJobs[i][0] = jobs[i][0]; // 요청 시각
            extendedJobs[i][1] = jobs[i][1]; // 소요 시간
            extendedJobs[i][2] = i;          // 작업 번호 (인덱스)
        }

        // 2) 요청 시각 기준 오름차순 정렬
        Arrays.sort(extendedJobs, (a, b) -> a[0] - b[0]);

        // 3) 우선순위 큐 구성
        //    소요 시간(짧은 게 우선), 요청 시각(빠른 게 우선), 작업 번호(작은 게 우선)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];        // 소요시간 비교
            } else if (a[0] != b[0]) {
                return a[0] - b[0];        // 요청시각 비교
            } else {
                return a[2] - b[2];        // 작업 번호 비교
            }
        });

        int currentTime = 0;        // 현재 시각
        int index = 0;             // 아직 큐에 넣지 않은 작업의 인덱스
        int totalTurnaround = 0;   // 모든 작업의 반환 시간 합

        // 4) 모든 작업을 처리할 때까지 반복
        while (index < n || !pq.isEmpty()) {
            // 현재 시각 이하로 요청이 들어온 모든 작업을 우선순위 큐에 넣기
            while (index < n && extendedJobs[index][0] <= currentTime) {
                pq.offer(extendedJobs[index]);
                index++;
            }

            // 우선순위 큐에 작업이 있으면 처리
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                int requestTime = currentJob[0];
                int duration = currentJob[1];
                // currentTime 갱신 (해당 작업 처리 완료 시점)
                currentTime += duration;
                // 반환 시간 = (처리 완료 시각 - 요청 시각)
                totalTurnaround += (currentTime - requestTime);
            } else {
                // 우선순위 큐가 비어 있고 아직 남은 작업이 있으면
                // 다음 작업의 요청 시각으로 currentTime을 이동
                currentTime = extendedJobs[index][0];
            }
        }

        // 5) 평균 반환 시간 (정수 부분) 계산
        return totalTurnaround / n;
    }
}
