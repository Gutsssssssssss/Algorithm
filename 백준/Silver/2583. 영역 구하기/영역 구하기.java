import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		visited = new boolean[N][M];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && !visited[i][j]) {
					int cnt = bfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.print(list.get(i) + " ");
		}
	} // main
	
	static int bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[y][x] = true;
		q.add(new int[] {y, x});
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[1] + dy[d];
				int ny = cur[0] + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || arr[ny][nx] == 1) continue;
				visited[ny][nx] = true;
				cnt++;
				
				q.add(new int[] {ny, nx});
			}
		}
		return cnt;
	}
}