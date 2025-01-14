import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[100001][3];
		
		dp[1][1] = 1;
		
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		dp[3][1] = 2;
		dp[3][2] = 2;
		
		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-2][2] + dp[i-3][2]) % 1_000_000_009;
			dp[i][2] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1_000_000_009;
		}
		
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(dp[N][1] + " " + dp[N][2]);
		}
	} // main
}