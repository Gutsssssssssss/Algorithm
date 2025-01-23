import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE / 2;
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static int[][] dp;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int ans = dfs(0, 0);
		System.out.println(ans >= INF ? -1 : ans);
	} // main
	static int dfs(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M || arr[y][x] == 'H') {
			return 0;
		}
		
		if (visited[y][x]) {
			return INF;
		}
		
		if (dp[y][x] != 0) {
			return dp[y][x];
		}
		
		visited[y][x] = true;
		int num = arr[y][x] - '0';
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			dp[y][x] = Math.max(dp[y][x], dfs(y + num * dy[d], x + num * dx[d]) + 1);
		}
		visited[y][x] = false;
		return dp[y][x];
	}
}