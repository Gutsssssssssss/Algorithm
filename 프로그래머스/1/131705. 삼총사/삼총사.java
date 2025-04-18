class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int N = number.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}