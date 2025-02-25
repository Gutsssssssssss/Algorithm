import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
        	dp[i][i] = 1;
        }
        
        for (int i = 0; i < N - 1; i++) {
        	if (arr[i] == arr[i+1]) {
        		dp[i][i+1] = 1;
        	}
        }
        
        for (int size = 2; size < N; size++) {
        	
        	for (int i = 0; i < N - size; i++) {
        		if (arr[i] == arr[i+size] && dp[i+1][i+size-1] == 1) {
        			dp[i][i+size] = 1;
        		}
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	sb.append(dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]).append("\n");
        }
        System.out.println(sb);
    } // main
    
}