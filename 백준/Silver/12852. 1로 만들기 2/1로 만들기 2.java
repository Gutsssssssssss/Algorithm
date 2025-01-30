import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			dp[i] = Math.min(dp[i-1] + 1, dp[i]);
		}
		System.out.println(dp[N]);
		go(N);
	} // main
	static void go(int N) {
		System.out.print(N + " ");
		if (N == 1) {
			return;
		}
		if ((N % 3 == 0) && (dp[N] == dp[N/3] + 1)) go(N/3);
		else if ((N % 2 == 0) && (dp[N] == dp[N/2] + 1)) go(N/2);
		else if ((N - 1 > 0) && (dp[N] == dp[N-1] + 1)) go(N-1);
	}
} // class