

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		int root = -1;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			adj.get(parent).add(i);
		}
		int K = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		if (K == root) {
			System.out.println(0);
			return;
		}
		visited[K] = true;
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		visited[root] = true;
		q.add(root);
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			int child = 0;
			for (int next : adj.get(cur)) {
				if (visited[next]) continue;
				visited[next] = true;
				q.add(next);
				child++;
			}
			if (child == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	} // main
}
