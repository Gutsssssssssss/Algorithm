import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] dp = new int[M+1][N+1];
			int ans = recur(M, N, dp);
			System.out.println(ans);
		} // TC
	} // main
	static int recur(int M, int N, int[][] dp) {
		if (dp[M][N] != 0) return dp[M][N];
		if (M == N) {
			return dp[M][N] = 1;
		}
		if (N == 0) {
			return dp[M][N] = 1;
		}
		if (N == 1) {
			return dp[M][N] = M;
		}
		return dp[M][N] = recur(M - 1, N, dp) + recur(M - 1, N - 1, dp);
	}
}