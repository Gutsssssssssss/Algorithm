class Solution {
    int N;
    int[] numbers;
    int target;
    int answer;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        
        return answer;
    }
    
    void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(idx + 1, sum + numbers[idx]);
        dfs(idx + 1, sum - numbers[idx]);
    }
}