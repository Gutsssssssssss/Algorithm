import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TC; T++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N+1][2]; // 0 1
			dp[0][0] = 1;
			dp[0][1] = 0;
			if (N >= 1) {
				dp[1][0] = 0;
				dp[1][1] = 1;
				for (int i = 2; i <= N; i++) {
					dp[i][0] = dp[i-1][0] + dp[i-2][0];
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
				}
			}
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	} // main
	static int fibo(int n, int[] dp, int[] ans) {
//		if (dp[n] != -1) {
//			if (n == 0) {
//				ans[0]++;
//			} else if (n == 1) {
//				ans[1]++;
//			}
//			return dp[n];
//		}
		if (n == 0) {
			ans[0]++;
			return dp[n] = 0;
		} else if (n == 1) {
			ans[1]++;
			return dp[n] = 1;
		} else {
			return dp[n] = fibo(n-1, dp, ans) + fibo(n-2, dp, ans);
		}
	}
}