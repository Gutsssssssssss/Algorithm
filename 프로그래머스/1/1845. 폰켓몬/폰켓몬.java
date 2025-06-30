import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 뽑아야 하는 수 == r
        // 전체 종류의 수 == n
        // r >= n -> n
        // r < n -> r
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int temp = map.getOrDefault(i, 0);
            map.put(i, ++temp);
        }
        int n = map.keySet().size();
        int r = nums.length / 2;
        return Math.min(n, r);
    }
}