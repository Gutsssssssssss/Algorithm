import java.io.*;
import java.util.*;

public class Main {

	static int N, M, C;
	static int[] arr;
	static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dp = new int[M+1][C+1][1 << (N + 1)];
        for (int i = 0; i <= M; i++) {
        	for (int ii = 0; ii <= C; ii++) {
        		Arrays.fill(dp[i][ii], -1);
        	}
        }
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(go(0, 0, C));
    } // main
    
    static int go(int visited, int idx, int capacity) {
    	if (capacity < 0) return -1;
    	if (idx == M) return 0;
    	if (dp[idx][capacity][visited] != -1) {
    		return dp[idx][capacity][visited];
    	}
    	int ret = go(visited, idx + 1, C);
    	
    	for (int i = 1; i <= N; i++) {
    		if ((visited & (1 << i)) != 0) continue;
    		ret = Math.max(ret, go(visited | (1 << i), idx, capacity - arr[i]) + 1);
    	}
    	return dp[idx][capacity][visited] = ret;
    }
    
}