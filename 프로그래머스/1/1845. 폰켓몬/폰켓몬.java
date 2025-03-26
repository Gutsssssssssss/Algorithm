import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int K = N / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        int answer = 0;
        if (keySet.size() <= K) {
            answer = keySet.size();
        } else {
            answer = K;
        }
        return answer;
    }
}