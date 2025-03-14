

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] visited = new int[200001];
		long[] cnt = new long[200001];
		
		visited[N] = 1;
		cnt[N] = 1;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(N);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : List.of(cur - 1, cur + 1, cur * 2)) {
				if (next < 0 || next > 200000) continue;
				if (visited[next] == 0) {
					visited[next] = visited[cur] + 1;
					q.add(next);
					cnt[next] += cnt[cur];
				} else if (visited[next] == visited[cur] + 1){
					cnt[next] += cnt[cur];
				}
			}
		}
		System.out.println(visited[K] - 1);
		System.out.println(cnt[K]);
	} // main
}
