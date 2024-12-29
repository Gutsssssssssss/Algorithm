import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long[][] dp, arr;
	static int dy[] = {0, 1};
	static int dx[] = {1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N+1][N+1];
		dp = new long[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 1);
		System.out.println(dp[1][1]);
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j] + " ");
//			} System.out.println();
//		}
	} // main
	
	static long dfs(int y, int x) {
		int val = (int) arr[y][x];
		long ret = 0;
//		System.out.println(y + " : " + x);
		
		if (dp[y][x] != 0) {
			return dp[y][x];
		}
		
		if (y == N && x == N) {
			return dp[N][N] = ++ret;
		}
		
		if (val == 0) {
			return 0;
		}
		
		for (int i = 0; i < 2; i++) {
			int ny = y + val * dy[i];
			int nx = x + val * dx[i];
			if (ny <= 0 || ny >= N+1 || nx <= 0 || nx >= N+1) continue;
			ret += dfs(ny, nx);
		}
//		System.out.println(y + " : " + x);
		dp[y][x] = ret;
		return dp[y][x];
	}
}