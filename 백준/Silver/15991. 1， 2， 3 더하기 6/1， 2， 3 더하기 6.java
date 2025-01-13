import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[100001][4];
		
		dp[0][1] = 1;
		
		dp[1][1] = 1;
		
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][3] = 1;
		
		dp[4][1] = dp[2][1] + dp[2][2] + dp[2][3];
		dp[4][2] = dp[0][1];
		
		dp[5][1] = dp[3][1] + dp[3][2] + dp[3][3];
		dp[5][2] = dp[1][1];
		
		for (int i = 6; i <= 100000; i++) {
			dp[i][1] = (dp[i-2][1] + dp[i-2][2] + dp[i-2][3]) % 1_000_000_009;
			dp[i][2] = (dp[i-4][1] + dp[i-4][2] + dp[i-4][3]) % 1_000_000_009;
			dp[i][3] = (dp[i-6][1] + dp[i-6][2] + dp[i-6][3]) % 1_000_000_009;
		}
		
		
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println((dp[N][1] + dp[N][2] + dp[N][3]) % 1_000_000_009);
		}
	} // main
}