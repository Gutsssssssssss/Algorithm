

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] damage = {
			{9, 3, 1},
			{9, 1, 3},
			{3, 9, 1},
			{3, 1, 9},
			{1, 3, 9},
			{1, 9, 3}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] visited = new int[arr[0] + 1][arr[1] + 1][arr[2] + 1];
		
		visited[arr[0]][arr[1]][arr[2]] = 1;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {arr[0], arr[1], arr[2]});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
			for (int d = 0; d < 6; d++) {
				int na = Math.max(0, a - damage[d][0]);
				int nb = Math.max(0, b - damage[d][1]);
				int nc = Math.max(0, c - damage[d][2]);
				if (visited[na][nb][nc] != 0) continue;
				visited[na][nb][nc] = visited[a][b][c] + 1;
				q.add(new int[] {na, nb, nc});
			}
		}
		
		System.out.println(visited[0][0][0] - 1);
	} // main
}
