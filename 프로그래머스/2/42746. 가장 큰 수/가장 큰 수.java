import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        
        String[] list = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(list, (a, b) -> (b+a).compareTo(a+b));
        if (list[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}