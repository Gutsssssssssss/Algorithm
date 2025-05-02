import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] cnt;
	static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		cnt = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj.get(from).add(to);
			cnt[to]++;
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : adj.get(cur)) {
				cnt[next]--;
				if(cnt[next]==0) {q.add(next);
					
				}
			}
			sb.append(cur + " ");
		}
		
		System.out.println(sb);
	}
}