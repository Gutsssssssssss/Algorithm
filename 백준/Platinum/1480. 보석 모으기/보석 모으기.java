import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = -Integer.MAX_VALUE / 2;
	static int N, M, C;
	static int[] arr;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[M+1][C+1][1 << N+1];
		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= C; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(go(0, C, 0));
	} // main
	
	static int go(int here, int capacity, int visited) {
		if (here == M) {
			return 0;
		}
		
		if (dp[here][capacity][visited] != -1) {
			return dp[here][capacity][visited];
		}
		
		int ret = INF;
		ret = Math.max(ret, go(here + 1, C, visited));
		
		for (int i = 1; i <= N; i++) {
			int isBefore = (1 << i) & visited;
			boolean flag = (capacity - arr[i]) >= 0;
			if (isBefore == 0 && flag) ret = Math.max(ret, go(here, capacity - arr[i], visited | (1 << i)) + 1);
		}
		
		return dp[here][capacity][visited] = ret;
	}
}