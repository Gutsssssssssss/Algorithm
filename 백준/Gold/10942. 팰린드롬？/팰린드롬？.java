import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		
		for (int i = 1; i <= N - 1; i++) {
			if (arr[i] == arr[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		for (int size = 2; size <= N; size++) {
			for (int i = 1; i <= N-size; i++) {
				if (arr[i] == arr[i+size] && dp[i+1][i+size-1] == 1) {
					dp[i][i+size] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp[S][E]).append("\n");
		}
		System.out.println(sb);
	} // main
	
	
}