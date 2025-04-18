class Solution {
    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int lo = 0; int hi = 0;
        int sum = sequence[0];
        int mnLength = 1000001;
        int[] answer = new int[2];
        
        while (lo <= hi && hi < N) {
            if (sum == k) {
                if (hi - lo < mnLength) {
                    mnLength = hi - lo;
                    answer[0] = lo;
                    answer[1] = hi;
                }
                sum -= sequence[lo];
                lo++;
            } else if (sum < k) {
                hi++;
                if (hi < N) sum += sequence[hi];
            } else {
                sum -= sequence[lo];
                lo++;
            }
        }
        
        return answer;
    }
}