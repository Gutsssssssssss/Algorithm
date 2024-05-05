import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] a;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		boolean[] visited = new boolean[n];
		numbers = new int[m];
		go(visited, 0);
		
	} // main 
	static void go(boolean[] visited, int cnt) {
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				System.out.print(a[numbers[i]] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			go(visited, cnt+1);
			visited[i] = false;
		}
	}
} // class