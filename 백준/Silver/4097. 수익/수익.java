import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			long[] dp = new long[N+1];
			int[] arr = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.fill(dp, -10000L * 250000L);
			for (int i = 1; i <= N; i++) {
				dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			}
			System.out.println(Arrays.stream(dp).max().getAsLong());
		} // w
	} // main
}