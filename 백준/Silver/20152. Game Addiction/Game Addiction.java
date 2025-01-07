import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int H, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		if (H == N) {
			System.out.println(1);
			return;
		}
		
		if (H > N) {
			int temp = H;
			H = N;
			N = temp;
		}
		
		N = N - H;
		H = 0;
		
		long[][] dp = new long[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 0) {
					dp[i][j] = 1;
				} else if (i > j) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		System.out.println(dp[N][N]);
	} // main
	
}