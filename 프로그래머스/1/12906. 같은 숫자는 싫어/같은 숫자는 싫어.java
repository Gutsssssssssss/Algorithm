import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stk.isEmpty() && stk.peek() == arr[i]) {
                continue;
            } else {
                stk.add(arr[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : stk) {
            ans.add(i);
        }
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}