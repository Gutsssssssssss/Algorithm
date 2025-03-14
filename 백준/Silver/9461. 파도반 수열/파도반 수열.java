import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			if (N == 1 || N == 2 || N == 3) {
				System.out.println(1);
				continue;
			}
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for (int i = 4; i <= N; i++) {
				dp[i] = dp[i-2] + dp[i-3];
			}
			System.out.println(dp[N]);
		} // TC
	} // main
}