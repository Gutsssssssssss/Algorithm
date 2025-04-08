import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                if (i >= yellow / i)
                list.add(new int[] {i, yellow / i});
            }
        }
        
        for (int[] pair : list) {
            int w = pair[0] + 2;
            int h = pair[1] + 2;
            System.out.println(pair[0] + " : " + pair[1]);
            if ((w * h) - yellow == brown) return new int[] {w, h};
        }
        
        int[] answer = {};
        return answer;
    }
}