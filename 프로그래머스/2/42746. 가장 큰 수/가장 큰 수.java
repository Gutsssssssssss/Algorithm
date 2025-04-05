import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            list.add("" + numbers[i]);
        }
        Collections.sort(list, (a, b) -> (b+a).compareTo(a+b));
        if (list.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}