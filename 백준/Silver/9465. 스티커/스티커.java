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
			int[][] arr = new int[2][N+1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[N+1][3];
			for (int j = 1; j <= N; j++) {
				dp[j][0] = Math.max(Math.max(dp[j-1][0], dp[j-1][1]), dp[j-1][2]);
				dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + arr[0][j];
				dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + arr[1][j];
			}
			System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
		} // TC
	} // main
}