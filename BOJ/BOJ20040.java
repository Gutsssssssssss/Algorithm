package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20040 {
	
	static int n, m;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}
		Queue<Pair> q = new ArrayDeque<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			q.add(new Pair(from, to));
		}
		int ret = 0;
		boolean flag = false;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			ret++;
			if(union(cur.from, cur.to)) {
				flag = true;
				break;
			}
		
		}
//		System.out.println(ret);
//		System.out.println(ret==m?0:ret);
		if(flag) System.out.println(ret);
		else System.out.println(0);
//		System.out.println(flag);
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB) return true;
		parents[parentB] = parentA;
		return false;
	}
	static class Pair {
		int from, to;

		public Pair(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
	}
}
