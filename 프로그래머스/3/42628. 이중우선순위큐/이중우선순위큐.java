import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            StringTokenizer st = new StringTokenizer(s);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (op.equals("I")) {
                list.add(num);
            } else {
                if (list.size() == 0) continue;
                if (num == -1) {
                    Collections.sort(list);
                    list.remove(0);
                } else {
                    Collections.sort(list, Collections.reverseOrder());
                    list.remove(0);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        if (list.size() == 0) {
            int[] answer = {0, 0};
            return answer;
        }
        
        int[] answer = {list.get(list.size()-1), list.get(0)};
        
        return answer;
    }
}