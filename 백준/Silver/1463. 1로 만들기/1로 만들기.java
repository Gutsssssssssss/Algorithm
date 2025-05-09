import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}
		int[] dp = new int[N+1];
		Arrays.fill(dp, 1000001);
		
		dp[1] = 0;
		dp[2] = 1;
		
		for (int i = 3; i <= N; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			dp[i] = Math.min(dp[i], dp[i-1] + 1);
		}
		System.out.println(dp[N]);
	} // main
}