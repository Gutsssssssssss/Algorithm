

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Integer>> adj;
	static int N, M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList<List<Integer>>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj.get(to).add(from);
		}
		
		int[] cnt = new int[N+1];
		int mx = -1;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			
			cnt[i] = bfs(i);
			mx = Math.max(mx, cnt[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (mx == cnt[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	} // main
	
	static int bfs(int here) {
		visited[here] = true;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(here);
		int cnt = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : adj.get(cur)) {
				if (visited[next]) continue;
				visited[next] = true;
				q.add(next);
				cnt++;
			}
		}
		
		
		return cnt;
	}
}
