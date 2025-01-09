import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		if (N == 1 || N == 2) {
			System.out.println(N);
			return;
		}
		dp[1] = 1;
		dp[2] = 2;
		if (N == 3) {
			System.out.println(4);
			return;
		}
		dp[3] = 4;
		dp[4] = 7;
		
		for (int i = 5; i <= N; i++) {
			dp[i] = dp[i-1] * 2;
			if (i % 2 == 0) {
				dp[i] -= (dp[i-4] + dp[i-5]);
			}
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
		System.out.println(dp[N]);
	} // main
}