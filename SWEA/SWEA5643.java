package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {

	static int TC, n, m, ret;
	static int[][] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());
		for(int T=1; T<=TC; T++) {
			ret = 0;
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			a = new int[n+1][n+1];
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				a[from][to] = 1;
			}
			for(int i=1; i<=n; i++) {
				int cnt1=0; int cnt2=0;
				cnt1 = bfs_b(i);
				cnt2 = bfs_s(i);
				if(cnt1 + cnt2 == n-1) {
					ret++;
				}
			}
			sb.append("#"+T + " ").append(ret);
		}
		System.out.println(sb);
	} // main
	static int bfs_s(int here) {
		int cnt = 0;
		boolean visited[] = new boolean[n+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(here);
		while(!q.isEmpty()) {
			here = q.poll();
			for(int i=1; i<=n; i++) {
				if(i==here) continue;
				if(visited[i]) continue;
				if(a[i][here] == 1) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	static int bfs_b(int here) {
		int cnt = 0;
		boolean visited[] = new boolean[n+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(here);
		while(!q.isEmpty()) {
			here = q.poll();
			for(int i=1; i<=n; i++) {
				if(i==here) continue;
				if(visited[i]) continue;
				if(a[here][i] == 1) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
} // class
