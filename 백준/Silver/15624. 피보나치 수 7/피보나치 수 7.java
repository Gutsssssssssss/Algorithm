import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		if (N == 0) {
			System.out.println(0);
			return;
		}
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
		}
		System.out.println(dp[N]);
	} // main
	
	static long fibo(int n) {
		if (dp[n] != -1) {
			return dp[n];
		} else if (n == 0) {
			return dp[n] = 0;
		} else if (n == 1) {
			return dp[n] = 1;
		} else {
			return dp[n] = (fibo(n-1) + fibo(n-2)) % 1_000_000_007;
		}
	}
}