import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		long[] dp2 = new long[N+1];
		
		dp[0] = 1;
		dp[1] = 2;
		if (N == 1) {
			System.out.println(2);
			return;
		}
		dp[2] = 7;
		dp2[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (2 * dp[i-1] + 3 * dp[i-2] + dp2[i-1]) % 1_000_000_007;
			dp2[i] = (dp2[i-1] +  2 * dp[i-2]) % 1_000_000_007;
		}
		System.out.println(dp[N]);
	} // main
}