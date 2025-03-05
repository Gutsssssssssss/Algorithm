

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		int prev = 0;
		while (true) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				break;
			} else {
				prev = cnt;
			}
			time++;
			
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> q = new ArrayDeque<int[]>();
			
			visited[0][0] = true;
			q.add(new int[] {0, 0});
			
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
					if (arr[ny][nx] == 1) {
						visited[ny][nx] = true;
						arr[ny][nx] = 0;
					} else {
						visited[ny][nx] = true;
						q.add(new int[] {ny, nx});
					}
				}
			}
			
		}
		System.out.println(time);
		System.out.println(prev);
	} // main
}
