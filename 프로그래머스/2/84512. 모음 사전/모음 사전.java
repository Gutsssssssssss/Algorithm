import java.util.*;
class Solution {
    int answer = 0;
    int cnt = 0;
    String aeiou = "AEIOU";
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    void dfs(String cur, String target) {
        if (cur.length() > 5) return;
        if (!cur.equals("")) cnt++;
        if (cur.equals(target)) {
            answer = cnt;
            return;
        }
        
        
        for (int i = 0; i < 5; i++) {
            dfs(cur + "AEIOU".charAt(i), target);
        }
    }
}