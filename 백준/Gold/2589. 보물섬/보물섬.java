
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 최단 거리로 이동하면서, 가장 먼 두 곳 찾기
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == 'W') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);
	} // main
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int bfs(int y, int x) {
		int[][] visited = new int[N][M];
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		visited[y][x] = 1;
		q.add(new int[] {y, x});
		int ret = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] != 0 || map[ny][nx] == 0) continue;
				visited[ny][nx] = visited[cy][cx] + 1;
				ret = Math.max(ret, visited[ny][nx]);
				q.add(new int[] {ny, nx});
			}
		}
		return ret - 1;
	}
}
