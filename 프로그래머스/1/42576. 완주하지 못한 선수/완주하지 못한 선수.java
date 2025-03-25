import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        String answer = "";
        return answer;
    }
}