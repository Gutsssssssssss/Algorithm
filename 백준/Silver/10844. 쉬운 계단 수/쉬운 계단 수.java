import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final long MOD = 1_000_000_000L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10]; // dp i j -> j로 시작하는 길이 i 인 계단수
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		int cnt = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1] % MOD;
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD;
				dp[i][j] %= MOD;
			}
			dp[i][9] = dp[i-1][8] % MOD;
		}
		long sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += dp[N][i];
			sum %= MOD;
		}
//		for (int i = 1; i <= 9; i++) {
//			System.out.print(dp[2][i] + " ");
//		}
		System.out.println(sum);
	} // main
}