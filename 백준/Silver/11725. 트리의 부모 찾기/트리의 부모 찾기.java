import java.io.*;
import java.util.*;

public class Main {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i <= N; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < N - 1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	list.get(A).add(B);
        	list.get(B).add(A);
        }
        
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        int[] parent = new int[N+1];
        
        visited[1] = true;
        q.add(1);
        
        while (!q.isEmpty()) {
        	int here = q.poll();
        	for (int next : list.get(here)) {
        		if (visited[next]) continue;
        		visited[next] = true;
        		parent[next] = here;
        		q.add(next);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
        	sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    } // main
    
}
