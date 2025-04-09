import java.util.*;

class Solution {
    String[] moem = {"A", "E", "I", "O", "U"};
    Set<String> list = new HashSet<>();
    public int solution(String word) {
        go(0, "");
        List<String> setList = new ArrayList<>(list);
        Collections.sort(setList);
        int answer = 0;
        for (int i = 0; i < setList.size(); i++) {
            if (setList.get(i).equals(word)) answer = i;
        }
        
        return answer + 1;
    }
    void go(int idx, String cur) {
        if (idx > 4) return;
        
        for (int i = 0; i < 5; i++) {
            go(idx + 1, cur + moem[i]);
            if (!list.contains(cur + moem[i])) list.add(cur + moem[i]);
            // System.out.println(cur);
            go(idx + 1, cur);
            if (!cur.equals("") && !list.contains(cur)) list.add(cur);
        }
    }
}