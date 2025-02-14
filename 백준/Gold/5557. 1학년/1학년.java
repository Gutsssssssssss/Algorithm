import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N+1];
		dp = new long[N+1][21];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(go(1, arr[1]));
	} // main
	
	static long go(int here, int cur) {
		if (cur < 0 || cur > 20) {
			return 0;
		}
		
		if (here == N - 1) {
			return cur == arr[here + 1] ? 1 : 0;
		}
		
		if (dp[here][cur] != -1) {
			return dp[here][cur];
		}
		
		long ret = 0;
		ret += go(here + 1, cur + arr[here + 1]);
		ret += go(here + 1, cur - arr[here + 1]);
		
		return dp[here][cur] = ret;
	}
}