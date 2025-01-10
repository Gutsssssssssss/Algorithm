import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 1;
			while (st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp = new long[N+1][N+1];
		dp[1][1] = arr[1][1];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				if (j+1 > N) continue;
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + arr[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + arr[i+1][j+1]);
			}
		}
		long ret = 0;
		for (int i = 1; i <= N; i++) {
			ret = Math.max(ret, dp[N][i]);
		}
		System.out.println(ret);
	} // main
}