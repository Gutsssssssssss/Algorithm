import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] a, visited;
	// bfs로 다리 만들기, 모든 섬 다 돌기
	// 다리 최소값 갱신, 최소값보다 커지면 멈추기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1 && visited[i][j] == 0) {
					dfs(i, j, num);
					num++;
				}
			}
		}
		int ret = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] != 0) {
					int temp = a[i][j];
					visited = new int[n][n];
					visited[i][j] = 1;
					Queue<Pair> q = new ArrayDeque<Pair>();
					q.add(new Pair(i, j));
					while(!q.isEmpty()) {
						Pair p = q.poll();
						for(int k=0; k<4; k++) {
							int ny = p.y + dy[k];
							int nx = p.x + dx[k];
							if(ny<0 || ny>=n || nx<0 || nx>=n || visited[ny][nx] != 0) continue;
							if(a[ny][nx] == temp) continue;
							if(a[ny][nx] != 0) {
								ret = Math.min(ret, visited[p.y][p.x]);
								if(ret>visited[p.y][p.x]) {
									ret = visited[p.y][p.x];
									break;
								}
							}
							if(ret<=visited[p.y][p.x]) continue;
							visited[ny][nx] = visited[p.y][p.x] + 1;
							q.add(new Pair(ny, nx));
						}
					}
				}
			}
		}
		System.out.println(ret-1);
	} // main
	static void dfs(int y, int x, int num) {
		visited[y][x] = 1;
		a[y][x] = num;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || ny>=n || nx<0 || nx>=n || visited[ny][nx] != 0 || a[ny][nx] == 0) continue;
			dfs(ny, nx, num);
		}
	}
	static class Pair {
		int y, x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
} // class