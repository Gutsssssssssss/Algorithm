import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int M, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[M][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[X][Y] = 1;
			}
			
			boolean[][] visited = new boolean[M][N];
			int ans = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j, visited, arr);
						ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		} // TC
		System.out.println(sb);
	} // main
	static void dfs(int x, int y, boolean[][] visited, int[][] arr) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;
			dfs(nx, ny, visited, arr);
		}
	}
}