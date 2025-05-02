

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[51][51][51];
		for (int i = 0; i <= 50; i++) {
			for (int j = 0; j <= 50; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) break;
			sb.append("w(" + a +", " + b + ", " + c + ") = ").append(go(a, b, c)).append("\n");
		}
		System.out.println(sb);
	} // main
	
	static int go(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		
		if (dp[a][b][c] != -1) return dp[a][b][c];
		
		if (a > 20 || b > 20 || c > 20) return dp[a][b][c] = go(20, 20, 20);
		
		if (a < b && b < c) return dp[a][b][c] =  go(a, b, c - 1) + go(a, b - 1, c - 1) - go(a, b - 1, c);
		
		return dp[a][b][c] =  go(a - 1, b, c) + go(a - 1, b - 1, c) + go(a - 1, b, c - 1) - go(a - 1, b - 1, c - 1);
	}
}
