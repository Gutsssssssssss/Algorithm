
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE / 2;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int N, M;
	static int[][] wall, jihoon, fire;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new int[N][M];
		jihoon = new int[N][M];
		fire = new int[N][M];
		for (int i = 0; i < N; i++) Arrays.fill(fire[i], INF);
		int jy = 0, jx = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '#') {
					wall[i][j] = 1;
				} else if (s.charAt(j) == 'J') {
					jihoon[i][j] = 1;
					jy = i;
					jx = j;
				} else if (s.charAt(j) == 'F') {
					fire[i][j] = 1;
					q.add(new int[] {i, j});
				}
			}
		}
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || wall[ny][nx] == 1 || fire[ny][nx] != INF) continue;
				fire[ny][nx] = fire[cy][cx] + 1;
				q.add(new int[] {ny, nx});
			}
		}
		
		q.add(new int[] {jy, jx});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			if (cy == 0 || cy == N - 1 || cx == 0 || cx == M - 1) {
				System.out.println(jihoon[cy][cx]);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || wall[ny][nx] == 1 || jihoon[ny][nx] != 0) continue;
				if (fire[ny][nx] > jihoon[cy][cx] + 1) {
					jihoon[ny][nx] = jihoon[cy][cx] + 1;
					q.add(new int[] {ny, nx});
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	} // main
}
