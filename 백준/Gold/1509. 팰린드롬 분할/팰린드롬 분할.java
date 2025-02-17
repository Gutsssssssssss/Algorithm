import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp2;
	static int N;
	static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        char[] arr = s.toCharArray();
        
        N = arr.length;
        
        dp = new int[N][N];
        dp2 = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		dp2[i][j] = -1;
        	}
        }
        
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
        System.out.println(go(0, 0));
    } // main
    
    static int go(int here, int size) {
    	if (here == N) {
    		return 0;
    	}
    	
    	if (dp2[here][size] != -1) {
    		return dp2[here][size];
    	}
    	
    	int ret = Integer.MAX_VALUE / 2;
    	for (int i = 0; i < N; i++) {
    		if (dp[here][i] == 1) {
    			ret = Math.min(ret, go(here + i + 1, 0) + 1);
    		}
    	}
    	return dp2[here][size] = ret;
    } // go
   
}