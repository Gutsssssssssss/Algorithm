import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!sum.containsKey(genres[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(genres[i], list);
                sum.put(genres[i], plays[i]);
            } else {
                sum.put(genres[i], sum.get(genres[i]) + plays[i]);
                map.get(genres[i]).add(i);
            }
        }
        
        List<String> keySet = new ArrayList<>(sum.keySet());
        Collections.sort(keySet, (a, b) -> sum.get(b) - sum.get(a));
        
        List<Integer> ans = new ArrayList<>();
        for (String s : keySet) {
            List<Integer> l = map.get(s);
            if (l.size() == 1) {
                ans.add(l.get(0));
                continue;
            }
            Collections.sort(l, (a, b) -> plays[b] - plays[a]);
            ans.add(l.get(0));
            ans.add(l.get(1));
        }
        
        int[] answer = ans.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}