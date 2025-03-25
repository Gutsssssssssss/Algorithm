class Solution {
    int N;
    int[] numbers;
    int target;
    int cnt;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        this.target = target;
        this.numbers = numbers;
        go(0, 0);
        int answer = cnt;
        return answer;
    } // main
    
    void go(int idx, int sum) {
        if (idx == N) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        go(idx + 1, sum + numbers[idx]);
        go(idx + 1, sum - numbers[idx]);
    }
} // class