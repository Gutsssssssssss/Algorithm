import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1]; 
		System.out.println(go(N, K));
	} // main
	
	static int go(int N, int K) {
		if (N < K) return 0;
		if (K == 0 || K == N) {
			return  dp[N][0] = 1;
		}
		
		if (K == 1) {
			return dp[N][1] = N;
		}
		
		if (dp[N][K] != 0) {
			return dp[N][K];
		}
		
		return dp[N][K] = (go(N - 1, K) + go(N - 1, K - 1)) % 10007;
	}
}