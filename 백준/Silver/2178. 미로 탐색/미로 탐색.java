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
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		int[][] visited = new int[N][M];
		visited[0][0] = 1;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int ci = cur[0];
			int cj = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = ci + dy[d];
				int nj = cj + dx[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj] != 0 || arr[ni][nj] == 0) continue;
				visited[ni][nj] = visited[ci][cj] + 1;
				q.add(new int[] {ni, nj});
			}
		}
		
		System.out.println(visited[N-1][M-1]);
	} // main
}