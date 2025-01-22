import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] W;
	static int N;
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE / 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		dp = new int[1 << N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < (1 << N); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(tsp(1, 0));
	} // main
	
	static int tsp(int visited, int now) {
		if (visited == (1 << N) - 1) {
			return W[now][0] == 0 ? INF : W[now][0];
		}
		
		if (dp[visited][now] != -1) return dp[visited][now];
		dp[visited][now] = INF;
		
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) continue;
			if (W[now][i] == 0) continue;
			dp[visited][now] = Math.min(dp[visited][now], tsp(visited | (1 << i), i) + W[now][i]);
		}
		return dp[visited][now];
	}
}