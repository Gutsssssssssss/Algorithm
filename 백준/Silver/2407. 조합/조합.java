import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static BigInteger[][] dp;
	static final BigInteger ONE = new BigInteger("1");
	static final BigInteger ZERO = new BigInteger("0");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dp = new BigInteger[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = BigInteger.valueOf(0);
			}
		}
		System.out.println(go(N, M));
	}
	static BigInteger go(int N, int M) {
		if (N < M) return ZERO;
		if (N < 0 || M < 0) return ZERO;
		if (M == 0) {
			return dp[N][M] = dp[N][N - M] = ONE;
		}
		if (M == 1) {
			return dp[N][M] = dp[N][N - M] = new BigInteger("" + N);
		}
		if (dp[N][M].compareTo(ZERO) != 0) {
			return dp[N][M];
		}
		return dp[N][M] = dp[N][N - M] = go(N - 1, M).add(go(N - 1, M - 1));
	}
}