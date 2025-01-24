import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[][][] dp = new int[N+1][3][W+1];
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		dp[1][1][0] = arr[1] == 1 ? 1 : 0;
		dp[1][2][1] = arr[2] == 2 ? 1 : 0;
		
		for (int i = 2; i <= N; i++) {
			
			for (int j = 0; j <= W; j++) {
				if (j == 0) {
					dp[i][1][0] = dp[i-1][1][0];
					dp[i][2][0] = dp[i-1][2][0];
				} else {
					dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]);
					dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]);
				}
				dp[i][arr[i]][j] += 1;
			}
		}
		int mx1 = -1;
		int mx2 = -1;
		for (int i = 0; i <= W; i++) {
			mx1 = Math.max(mx1, dp[N][1][i]);
			mx2 = Math.max(mx2, dp[N][2][i]);
		}
		System.out.println(Math.max(mx1, mx2));
	} // main
}