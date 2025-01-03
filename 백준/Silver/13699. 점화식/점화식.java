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
		System.out.println(go(N));
	} // main
	
	static long go(int n) {
		if (n == 0) {
			return dp[n] = 1;
		}
		
		if (dp[n] != 0) {
			return dp[n];
		}
		
		long ret = 0;
		for (int i = 0; i <= n - 1; i++) {
			ret += (go(i) * go(n - 1 - i));
		}
		return dp[n] = ret;
	}
}