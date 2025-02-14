import java.io.*;
import java.util.*;

public class Main {
    // 강연 요청 정보를 담을 클래스
    static class Lecture {
        int fee;    // 강연료
        int deadline;  // 마감일
        
        Lecture(int fee, int deadline) {
            this.fee = fee;
            this.deadline = deadline;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fee = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(fee, deadline);
        }
        
        // 마감일 오름차순, 마감일이 같다면 강연료 내림차순으로 정렬
        Arrays.sort(lectures, new Comparator<Lecture>() {
            public int compare(Lecture a, Lecture b) {
                if(a.deadline == b.deadline) {
                    return b.fee - a.fee;
                }
                return a.deadline - b.deadline;
            }
        });
        
        // 최소 힙: 현재까지 예약한 강연들의 강연료를 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Lecture lec : lectures) {
            // 강연 요청의 마감일이 예약 가능한 일 수보다 많으면 예약
            if (minHeap.size() < lec.deadline) {
                minHeap.offer(lec.fee);
            } 
            // 예약 가능한 슬롯이 가득 찬 경우
            else if (!minHeap.isEmpty() && minHeap.peek() < lec.fee) {
                minHeap.poll();
                minHeap.offer(lec.fee);
            }
        }
        
        // 최소 힙에 남은 강연료들의 합이 최대 수익
        int totalFee = 0;
        while (!minHeap.isEmpty()) {
            totalFee += minHeap.poll();
        }
        
        System.out.println(totalFee);
    }
}
