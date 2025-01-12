import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][M+1];
		
		if (K == 0) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (i == 1 || j == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		} else {
			int ei = K / M + 1;
			int ej = K % M;
			if (K % M == 0) {
				ei = K / M;
				ej = M;
			}
			
			for (int i = 1; i <= ei; i++) {
				for (int j = 1; j <= ej; j++) {
					if (i == 1 || j == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
			
			long val = dp[ei][ej];
			
			for (int i = ei; i <= N; i++) {
				for (int j = ej; j <= M; j++) {
					if (i == ei || j == ej) {
						dp[i][j] = val;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		}
		System.out.println(dp[N][M]);
	} // main
}