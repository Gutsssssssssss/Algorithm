import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        dp = new long[N][21];
        for (int i = 0; i < N; i++) {
        	Arrays.fill(dp[i], -1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long ans = go(1, arr[0]);
        System.out.println(ans);
    } // main
    
    // 0 이상 20 이하
    static long go(int idx, int cur) {
    	if (cur < 0 || cur > 20) {
    		return 0;
    	}
    	if (idx == N - 1) {
    		if (cur == arr[N-1])
    			return 1;
    		else return 0;
    	}
    	if (dp[idx][cur] != -1) {
    		return dp[idx][cur];
    	}
    	long ret = 0;
    	ret += go(idx + 1, cur + arr[idx]);
    	ret += go(idx + 1, cur - arr[idx]);
    	
    	return dp[idx][cur] =  ret;
    }
}