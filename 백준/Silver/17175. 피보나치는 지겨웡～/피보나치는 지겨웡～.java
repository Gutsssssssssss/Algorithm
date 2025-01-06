import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		System.out.println(fibo(N));
	} // main
	static long fibo(int n) {
		if (dp[n] != 0) {
			return dp[n];
		}
		if (n < 2) {
			return dp[n] = 1;
		}
		return dp[n] = (fibo(n-2) + fibo(n-1) + 1) % 1_000_000_007;
	}
}