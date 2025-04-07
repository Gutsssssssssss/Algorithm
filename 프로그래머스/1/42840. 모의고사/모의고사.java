import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int idx = 0;
        // 1
        int cnt1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[idx]) {
                cnt1++;
            }
            idx = (idx + 1) % arr1.length;
        }
        idx = 0;
        
        // 2
        int cnt2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr2[idx]) {
                cnt2++;
            }
            idx = (idx + 1) % arr2.length;
        }
        idx = 0;
        
        // 3
        int cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr3[idx]) {
                cnt3++;
            }
            idx = (idx + 1) % arr3.length;
        }
        idx = 0;
        
        int mx = Math.max(cnt1, cnt2);
        mx = Math.max(mx, cnt3);
        
        
        List<Integer> ans = new ArrayList<>();
        if (cnt1 == mx) ans.add(1);
        if (cnt2 == mx) ans.add(2);
        if (cnt3 == mx) ans.add(3);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}