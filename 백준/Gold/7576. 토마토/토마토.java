import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		Queue<int[]> q1 = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q1.add(new int[] {i, j});
					visited[i][j] = true;
				} else if (arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		int time = 0;
		while (true) {
			// bfs 전파
			Queue<int[]> q2 = new ArrayDeque<>();
			boolean flag = true;
			
			while (!q1.isEmpty()) {
				int[] cur = q1.poll();
				int cy = cur[0];
				int cx = cur[1];
				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M || arr[ny][nx] != 0 || visited[ny][nx]) continue;
					visited[ny][nx] = true;
					q2.add(new int[] {ny, nx});
				}
			}
			
			// 다 익었는지 체크
			
			if (q2.isEmpty()) {
				break;
			}
			time++;
			q1 = q2;
		}
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) flag = true; 
			}
		}
		if (flag) {
			System.out.println(-1);
		} else 
		System.out.println(time);
	} // main
}