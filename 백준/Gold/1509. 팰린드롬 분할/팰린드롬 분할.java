import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE / 2;
	static int N;
	static int[][] dp;
	static int[] dp2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        N = s.length();
        char[] arr = s.toCharArray();
        
        dp = new int[N][N];
        dp2 = new int[N];
        Arrays.fill(dp2, -1);
        for (int i = 0; i < N; i++) {
        	dp[i][0] = 1;
        }
        
        for (int i = 0; i < N - 1; i++) {
        	if (arr[i] == arr[i+1]) {
        		dp[i][1] = 1;
        	}
        }
        
        for (int size = 2; size < N; size++) {
        	
        	for (int i = 0; i < N - size; i++) {
        		if (arr[i] == arr[i+size] && dp[i+1][size-2] == 1) {
        			dp[i][size] = 1;
        		}
        	}
        }
        System.out.println(go(0));
    } // main
    
    static int go(int here) {
    	if (here == N) {
    		return 0;
    	}
    	
    	if (here > N) {
    		return INF;
    	}
    	
    	if (dp2[here] != -1) {
    		return dp2[here];
    	}
    	
    	int ret = INF;
    	for (int i = 0; i < N; i++) {
    		if (dp[here][i] == 1) {
    			ret = Math.min(ret, go(here + i + 1) + 1);
    		}
    	}
    	return dp2[here] = ret;
    }
    
}