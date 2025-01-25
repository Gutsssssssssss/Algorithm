import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	static final int INF = Integer.MAX_VALUE / 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, INF);
		System.out.println(go(N));
		go2(N);
	} // main
	static void go2(int N) {
		if (N == 0) return;
		System.out.print(N + " ");
		if (N % 3 == 0 && (dp[N] == dp[N/3] + 1)) go2(N / 3);
		else if (N % 2 == 0 && (dp[N] == dp[N/2] + 1)) go2(N / 2);
		else if ((N - 1 >= 0) && (dp[N] == dp[N-1] + 1)) go2(N - 1);
	}
	
	static int go(int N) {
		if (N == 1) {
			return dp[N] = 0;
		}
		
		if (dp[N] != INF) return dp[N];
		
		if (N % 3 == 0) dp[N] = Math.min(dp[N], go(N / 3) + 1);
		if (N % 2 == 0) dp[N] = Math.min(dp[N], go(N / 2) + 1);
		dp[N] = Math.min(dp[N], go(N - 1) + 1);
		return dp[N];
	}
}