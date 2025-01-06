import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] coin = {1, 2, 5, 7};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = coin[i]; j <= N; j++) {
				dp[j] = Math.min(dp[j-coin[i]] + 1, dp[j]); 
			}
		}
//		for (int i = 1; i <= N; i++) System.out.print(dp[i] + " ");
		System.out.println(dp[N]);
	} // main
}