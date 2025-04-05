import java.util.*;
class Solution {
    int[] citations;
    int N;
    public int solution(int[] citations) {
        this.citations = citations;
        this.N = citations.length;
        int lo = 0; int hi = -1;
        for (int i = 0; i < N; i++) {
            
            hi = Math.max(hi, citations[i]);
        }
        Arrays.sort(citations);
        int answer = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (check(mid)) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }
        return answer;
    }
    
    boolean check(int mid) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (mid <= citations[i]) {
                cnt++;
            }
        }
        return cnt >= mid;
    }
}