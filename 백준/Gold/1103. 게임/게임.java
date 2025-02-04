import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
	static int N, M;
	static int[][] dp;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				dp[i][j] = -1;
			}
		}
		int ans = go(0, 0);
		System.out.println(ans >= Integer.MAX_VALUE / 2 ? - 1 : ans);
	} // main
	
	static int go(int y, int x) {
		if ((y < 0 || y >= N || x < 0 || x >= M) ||  map[y][x] == 'H') {
			return 0;
		}
		
		int ret = 0;
		int val = map[y][x] - '0';
		
		if (dp[y][x] != -1) return dp[y][x];

		if (visited[y][x]) {
			return Integer.MAX_VALUE / 2;
		}
		visited[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d] * val;
			int nx = x + dx[d] * val;
			ret = Math.max(ret, go(ny, nx) + 1);
		}
		visited[y][x] = false;
		return dp[y][x] = ret;
	}
}