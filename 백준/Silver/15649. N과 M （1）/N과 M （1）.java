import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[n+1];
		numbers = new int[m];
		go(visited, 0);
	}
	static void go(boolean[] visited, int cnt) {
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=n; i++) {
			if(visited[i] != true) {
				numbers[cnt] = i;
				visited[i] = true;
				go(visited, cnt+1);
				visited[i] = false;
			}
		}
	}
}