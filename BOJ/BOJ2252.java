package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {

	static int n, m;
	static int[] cnt;
	static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		cnt = new int[n+1];
		adj = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj.get(A).add(B);
			cnt[B]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			if(cnt[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<adj.get(cur).size(); i++) {
				cnt[adj.get(cur).get(i)]--;
				if(cnt[adj.get(cur).get(i)] == 0) q.add(adj.get(cur).get(i));
			}
			sb.append(cur + " ");
		}
		System.out.println(sb);
	}
}
