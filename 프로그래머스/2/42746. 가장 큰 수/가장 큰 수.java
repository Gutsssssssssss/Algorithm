import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i] + "";
        }
        Arrays.sort(arr, (a, b) -> {
            String s1 = "" + a + b;
            String s2 = "" + b + a;
            return s2.compareTo(s1);
        });
        String answer = "";
        if (arr[0].equals("0")) return "0";
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }
}