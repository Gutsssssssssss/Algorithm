import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			if ((long)i * (long)i <= N) {
				dp[i*i] = 1;
			}
			
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[j*j] + dp[i-j*j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	} // main
}