package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623 {

	static int n, m;
	static int[] cnt;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		cnt = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j=1; j<c; j++) {
				int temp = Integer.parseInt(st.nextToken());
				list.get(prev).add(temp);
				cnt[temp]++;
				prev = temp;
			}
		}
	
		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(cnt[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			ret.add(cur);
			for(int next : list.get(cur)) {
				cnt[next]--;
				if(cnt[next]==0) {
					q.add(next);
				}
			}
		}
		if(ret.size() != n) System.out.println(0);
		else {
			for(int it : ret) System.out.println(it);
		}
	} // main
} // class
