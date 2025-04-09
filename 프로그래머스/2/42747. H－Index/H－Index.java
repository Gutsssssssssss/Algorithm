import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int N = citations.length;
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < N; i++) {
            hi = Math.max(hi, citations[i]);
        }
        int answer = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (check(mid, N, citations)) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean check(int mid, int N, int[] citations) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (mid <= citations[i]) cnt++;
        }
        return cnt >= mid;
    }
}