import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0];
            int e = commands[i][1];
            int k = commands[i][2];
            List<Integer> temp = new ArrayList<>();
            for (int j = s - 1; j <= e - 1; j++) {
                temp.add(array[j]);
            }
            Collections.sort(temp);
            ans.add(temp.get(k-1));
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}