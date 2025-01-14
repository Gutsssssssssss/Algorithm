import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N, M;
	static int ret = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][M+1];
		
		dp[0][S] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i-1][j] != 0) {
					if (j + arr[i] <= M) {
						dp[i][j+arr[i]] = 1;
					}
					
					if (j - arr[i] >= 0) {
						dp[i][j-arr[i]] = 1;
					}
				}
			}
		}
		
//		go(S, 1);
//		System.out.println(ret);
		
		for (int i = M; i >= 0; i--) {
			if (dp[N][i] == 1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	} // main
	
	static void go(int cur, int idx) {
		if (cur > M || cur < 0) {
			return;
		}
		
		if (idx == N + 1) {
			ret = Math.max(ret, cur);
			return;
		}
		
		go(cur + arr[idx], idx + 1);
		go(cur - arr[idx], idx + 1);
	}
}