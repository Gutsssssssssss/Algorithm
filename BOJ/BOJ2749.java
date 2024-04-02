package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2749 {

	static int n;
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = 1500000;
		n = (int)(Long.parseLong(br.readLine()) % m);
		dp = new int[n+1];
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 1000000;
		}
		System.out.println(dp[n]);
	}
}
