class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        // 0이 가로, 1이 세로
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            wMax = Math.max(wMax, sizes[i][0]);
            hMax = Math.max(hMax, sizes[i][1]);
        }
        int answer = wMax * hMax;
        return answer;
    }
}