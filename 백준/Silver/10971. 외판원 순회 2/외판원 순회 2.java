import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ret=Integer.MAX_VALUE;
	static int[][] dist;
	static int[] visited, a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dist = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new int[n];
		a = new int[n];
		perm(0, visited);
		System.out.println(ret);
	} // end of main
	
	static void calc() {
		int temp = 0;
		for(int i=1; i<n; i++) {
			if(dist[a[i-1]][a[i]] == 0) return;
			temp += dist[a[i-1]][a[i]];
		}
		if(dist[a[n-1]][a[0]] == 0) return;
		temp += dist[a[n-1]][a[0]];
//		System.out.println(temp);
		ret = Math.min(ret, temp);
	}
	
	static void perm(int idx, int[] visited) {
		if(idx == n) {
			calc();
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i] != 0) continue;
			visited[i] = 1;
			a[idx] = i;
			perm(idx+1, visited);
			visited[i] = 0;
		}
	}
} // end of class