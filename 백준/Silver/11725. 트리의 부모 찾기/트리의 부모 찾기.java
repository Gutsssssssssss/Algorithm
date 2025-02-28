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
		
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		boolean[] visited = new boolean[N+1];
		int[] parent = new int[N+1];
		
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : adj[cur]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.add(next);
				parent[next] = cur;
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	} // main
	
}