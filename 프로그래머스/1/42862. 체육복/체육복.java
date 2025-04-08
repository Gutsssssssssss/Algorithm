import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i]++;
        }
        for (int i : lost) {
            ans[i]--;
        }
        
        for (int i : reserve) {
            ans[i]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i] == 2) {
                if (i - 1 >= 1 && ans[i-1] == 0) {
                    ans[i]--;
                    ans[i-1]++;
                } else if (i + 1 <= n && ans[i+1] == 0) {
                    ans[i]--;
                    ans[i+1]++;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
            if (ans[i] >= 1) answer++;
        }
        return answer;
    }
}