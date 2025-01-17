import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					dp[i][j][1] = 1;
				}
			}
		}
		
	
		
		for (int j = 2; j <= N; j++) {
			
			for (int k = 0; k <= 2; k++) {
				dp[1][j][k] = Math.max(dp[1][j-1][k], dp[1][j][k]);
			}
			
			int cur = arr[1][j];
			dp[1][j][(cur + 1) % 3] = Math.max(dp[1][j][(cur + 1) % 3], dp[1][j][cur] == 0 ? 0 : dp[1][j][cur] + 1);
		}
		
		for (int i = 2; i <= N; i++) {
			
			for (int k = 0; k <= 2; k++) {
				dp[i][1][k] = Math.max(dp[i-1][1][k], dp[i][1][k]);
			}
			
			int cur = arr[i][1];
			dp[i][1][(cur + 1) % 3] = Math.max(dp[i][1][(cur + 1) % 3], dp[i][1][cur] == 0 ? 0 : dp[i][1][cur] + 1);
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				
				for (int k = 0; k <= 2; k++) {
					dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k]));
				}
				
				int cur = arr[i][j];
				dp[i][j][(cur + 1) % 3] = Math.max(dp[i][j][(cur + 1) % 3], dp[i][j][cur] == 0 ? 0 : dp[i][j][cur] + 1);
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j][1] + " ");
//			}System.out.println();
//		}
		System.out.println(Math.max(dp[N][N][0], Math.max(dp[N][N][1], dp[N][N][2])));
	} // main
}