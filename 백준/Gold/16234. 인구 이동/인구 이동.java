
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static List<List<int[]>> unionList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while (true) {
			unionList = new ArrayList<>();
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					bfs(i, j);
				}
			}
			
			int size = unionList.size();
			if (size == 0) break;
			
			for (int i = 0; i < size; i++) {
				int sum = 0;
				for (int[] cur : unionList.get(i)) {
					sum += map[cur[0]][cur[1]];
				}
				
				int temp = sum / unionList.get(i).size();
				for (int[] cur : unionList.get(i)) {
					map[cur[0]][cur[1]] = temp;
				}
			}
			
			
			time++;
		}
		System.out.println(time);
	} // main
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static void bfs(int y, int x) {
		
		visited[y][x] = true;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {y, x});
		List<int[]> ret = new ArrayList<int[]>();
		ret.add(new int[] {y, x});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
				int sub = Math.abs(map[cy][cx] - map[ny][nx]);
				if (L <= sub && sub <= R) {
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
					ret.add(new int[] {ny, nx});
				}
			}
		}
		
		if (ret.size() > 1) {
			unionList.add(ret);
		}
	}
}
