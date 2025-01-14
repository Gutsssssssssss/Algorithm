import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[1001][1001];
		
		dp[1][1] = 1;
		
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		
		for (int i = 4; i <= 1000; i++) {
			for (int j = 1; j <=i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1_000_000_009;
			}
		}
		
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long sum = 0;
			for (int i = 1; i <= M; i++) {
				sum += (dp[N][i]) % 1_000_000_009;
				sum %= 1_000_000_009;
			}
			System.out.println(sum);
		} // TC
	}
}