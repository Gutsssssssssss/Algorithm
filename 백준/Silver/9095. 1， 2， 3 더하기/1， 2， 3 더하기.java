import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
			
		} // TC
		System.out.println(sb);
	} // main
}