import java.util.*;
// O(n)으로 줄이기

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬 -> 아스키 순서 -> 길이 순서
        // 1부터 n-1까지 순회하면서 이전과 비교 후 startsWith()
        Arrays.sort(phone_book, (a, b) -> {
            if (a.equals(b)) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        boolean answer = true;
        return answer;
    }
}