import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int MOD = 1_000_007;
	static int N, M, C;
	static int[][] map;
	static int[][][][] dp;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M][C+1][C+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k <= C; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		for (int i = 1; i <= C; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= C; i++) {
			int ans = 0;
			if (map[0][0] != 0) {
				ans = go(0, 0, map[0][0], i - 1);
			} else {
				ans = go(0, 0, 0, i);
			}
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	} // main
	static int go(int y, int x, int prev, int cnt) {
		if (cnt < 0) return 0;
		
		if (y == (N - 1) && x == (M - 1) && cnt == 0) {
			return 1;
		}
		if (dp[y][x][prev][cnt] != -1) return dp[y][x][prev][cnt];
		int ret = 0;
		for (int i = 0; i < 2; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (map[ny][nx] != 0) {
				if (map[ny][nx] > prev) {
					ret += (go(ny, nx, map[ny][nx], cnt - 1) % MOD);
				}
			} else {
				ret += (go(ny, nx, prev, cnt) % MOD);
			}
		}
		return dp[y][x][prev][cnt] = (ret % MOD);
	}
} // class