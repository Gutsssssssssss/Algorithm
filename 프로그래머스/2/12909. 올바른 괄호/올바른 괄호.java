import java.util.*;
class Solution {
    boolean solution(String s) {

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.add(s.charAt(i));
            } else if (!stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else {
                stk.add(s.charAt(i));
            }
        }
        System.out.println(stk.size());
        boolean answer = stk.isEmpty() == true ? true : false;;

        return answer;
    }
}