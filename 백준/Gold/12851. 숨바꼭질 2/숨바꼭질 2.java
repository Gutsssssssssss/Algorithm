

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[200001];
        visited[N] = 1;
        q.add(N);
        int[] cnt = new int[200001];
        cnt[N] = 1;
        
        while (!q.isEmpty()) {
        	int now = q.poll();
        	for (int next : List.of(now + 1, now - 1, now * 2) ) {
        		if (next < 0 || next > 200000) continue;
        		if (visited[next] == 0) {
        			visited[next] = visited[now] + 1;
        			q.add(next);
        			cnt[next] += cnt[now];
        		} else if (visited[next] == visited[now] + 1) {
        			cnt[next] += cnt[now];
        		}
        	}
        }
        System.out.println(visited[M] - 1);
        System.out.println(cnt[M]);
    } // main
}
