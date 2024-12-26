import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		long ans = fibo(N, dp);
		System.out.println(ans);
	} // main
	
	static long fibo(int n, long[] dp) {
		if (dp[n] != 0) return dp[n];
		if (n == 0) return dp[n] = 0;
		if (n == 1 || n == 2) return dp[n] = 1;
		return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
	}
}