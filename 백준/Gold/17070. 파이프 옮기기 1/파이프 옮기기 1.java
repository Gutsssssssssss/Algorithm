import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		int[][][] dp = new int[N+1][N+1][4];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][1] = 1;
		for (int j = 3; j <= N; j++) {
			if (arr[1][j] == 1) continue;
			dp[1][j][1] = dp[1][j-1][1];
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if (arr[i-1][j] == 0 && arr[i][j-1] == 0 && arr[i][j] == 0) {
					dp[i][j][3] = dp[i-1][j-1][1] + dp[i-1][j-1][2] + dp[i-1][j-1][3];
				}
				if (arr[i][j] == 0) {
					dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][3];
					dp[i][j][1] = dp[i][j-1][1] + dp[i][j-1][3];
				}
			}
		}
		System.out.println(dp[N][N][1] + dp[N][N][2] + dp[N][N][3]);
	} // main
}