import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, List<Integer>> listMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!listMap.containsKey(genres[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                listMap.put(genres[i], list);
                sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
            } else {
                listMap.get(genres[i]).add(i);
                sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList<>(sumMap.keySet());
        Collections.sort(keySet, (a, b) -> sumMap.get(b) - sumMap.get(a));
        
        // 장르 앞에서부터 차례로 
        // 장르 안에 노래 2개 뽑기
        // 1개면 1개만 뽑기
        List<Integer> ans = new ArrayList<>();
        for (String s : keySet) {
            List<Integer> llist = listMap.get(s);
            Collections.sort(llist, (a, b) -> plays[b] - plays[a]);
            if (llist.size() == 1) {
                ans.add(llist.get(0));
            } else {
                ans.add(llist.get(0));
                ans.add(llist.get(1));
                if (llist.size() > 2) System.out.println(llist.get(2));
            }
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

}