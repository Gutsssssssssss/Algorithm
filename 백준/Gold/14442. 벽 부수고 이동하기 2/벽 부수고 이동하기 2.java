import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		boolean[][][] visited = new boolean[N][M][K+1];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 1, K));
		
		int ans = -1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cy = cur.y;
			int cx = cur.x;
			int cDist = cur.dist;
			int cCnt = cur.cnt;
			if (cy == N - 1 && cx == M - 1) {
				ans = cDist;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (map[ny][nx] == 0) {
					if (!visited[ny][nx][cCnt]) {
						visited[ny][nx][cCnt] = true;
						q.add(new Node(ny, nx, cDist + 1, cCnt));
					}
				} else {
					if (cCnt > 0 && !visited[ny][nx][cCnt]) {
						visited[ny][nx][cCnt] = true;
						q.add(new Node(ny, nx, cDist + 1, cCnt - 1));
					}
				}
			}
		}
		System.out.println(ans);
	} // main
	
	static class Node {
		int y;
		int x;
		int dist;
		int cnt;
		Node(int y, int x, int dist, int cnt) {
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.cnt = cnt;
		}
	}
}