import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		int mx = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, arr[i][j]);
			}
		}
		int ret = -1;
		for (int depth = 0; depth < mx; depth++) {
			boolean[][] visited = new boolean[N][N];
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && arr[i][j] > depth) {
						dfs(i, j, visited, arr, depth);
						cnt++;
					}
				}
			}
			ret = Math.max(cnt, ret);
		}
		System.out.println(ret);
	} // main
	static void dfs(int y, int x, boolean[][] visited, int[][] arr, int depth) {
		visited[y][x] = true;
		
		for (int d = 0; d < 4; d++) { 
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || arr[ny][nx] <= depth) continue;
			dfs(ny, nx, visited, arr, depth);
		}
	}
}