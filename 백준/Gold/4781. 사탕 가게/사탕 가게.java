import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	String[] s = st.nextToken().split("\\.");
        	int M = Integer.parseInt(s[0]) * 100 + Integer.parseInt(s[1]);
        	if (N == 0 && M == 0) break;
        	
        	int[] dp = new int[M+1];
        	for (int i = 1; i <= N; i++) {
        		st = new StringTokenizer(br.readLine());
            	int W = Integer.parseInt(st.nextToken());
            	String[] s2 = st.nextToken().split("\\.");
            	int v = Integer.parseInt(s2[0]) * 100 + Integer.parseInt(s2[1]);
            	for (int j = v; j <= M; j++) {
            		dp[j] = Math.max(dp[j], dp[j-v] + W);
            	}
        	}
        	System.out.println(dp[M]);
        }
    } // main
    
}