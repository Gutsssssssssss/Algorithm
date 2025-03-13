
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1001][1001];
		for (int i = 0; i <= 1000; i++) {
			Arrays.fill(dp[i], -1);
		}
		arr = new int[N][3];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			int pnt = Integer.parseInt(st.nextToken());
			arr[i][0] = str; arr[i][1] = in; arr[i][2] = pnt;
		}
		
		System.out.println(go(1, 1));
	} // main
	
	static int go(int STR, int INT) {
		if (dp[STR][INT] != -1) return dp[STR][INT];
		int pnt = 0;
		int ret = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (STR >= arr[i][0] || INT >= arr[i][1]) {
				ret++;
				if (!visited[i]) {
					visited[i] = true;
					pnt += arr[i][2];
					list.add(i);
				}
				
			}
		}
		dp[STR][INT] = ret;
		
		
		for (int p = 0; p <= pnt; p++) {
			int nSTR = Math.min(1000, STR + p);
			int nINT = Math.min(1000, INT + pnt - p);
			dp[STR][INT] = Math.max(dp[STR][INT], go(nSTR, nINT));
		}
		
		for (int i : list) {
			visited[i] = false;
		}
		return dp[STR][INT];
	}
}
