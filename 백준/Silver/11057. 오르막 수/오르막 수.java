import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
	
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[11][N+1];
		if (N == 1) {
			System.out.println(10);
			return;
		}
		for (int i = 1; i <= 10; i++) {
			dp[i][2] = dp[i-1][2] + i;
		}
		for (int i = 1; i <= 10; i++) {
			for (int j = 3; j <= N; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
			}
		}
		System.out.println(dp[10][N]);
	} // main
}