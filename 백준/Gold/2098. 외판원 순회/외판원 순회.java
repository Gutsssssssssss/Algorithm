import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 16_000_001;
	static int N;
	static int[][] W, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		dp = new int[(1<<N)][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(1, 0));
	} // main
	
	static int tsp(int visited, int here) {
		if (visited == (1 << N) - 1) {
			return W[here][0] == 0 ? INF : W[here][0];
 		}
		
		if (dp[visited][here] != 0) {
			return dp[visited][here];
		}
		
		dp[visited][here] = INF;
		
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) continue;
			if (W[here][i] == 0) continue;
			dp[visited][here] = Math.min(dp[visited][here], tsp(visited | (1 << i), i) + W[here][i]);
		}
		return dp[visited][here];
	}
} // class