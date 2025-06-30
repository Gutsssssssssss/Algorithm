import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            int num = map.getOrDefault(s, 0);
            map.put(s, ++num);
        }
        
        for (String s : completion) {
            int num = map.get(s);
            map.put(s, --num);
        }
        
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            if (map.get(s) != 0) {
                return s;
            }
        }
        
        String answer = "";
        return answer;
    }
}