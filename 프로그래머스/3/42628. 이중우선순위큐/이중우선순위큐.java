import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (op.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
            } else {
                if (minPq.isEmpty() && maxPq.isEmpty()) continue;
                if (num == 1) {
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
            }
        }
        if (minPq.isEmpty() && maxPq.isEmpty()) return new int[] {0, 0};
        int[] answer = {maxPq.peek(), minPq.peek()};
        return answer;
    }
}