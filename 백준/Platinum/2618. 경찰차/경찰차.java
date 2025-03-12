

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] dp;
	static int[][] arr;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[2 + M][2];
		ans = new int[M];
		dp = new int[M+2][M+2];
		for (int i = 0; i <= M+1; i++) {
			Arrays.fill(dp[i], -1);
			
		}
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[1][0] = N;
		arr[1][1] = N;
		for (int i = 2; i < 2 + M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(go(0, 1));
		int a = 0, b = 1;
		for (int i = 2; i < M + 2; i++) {
			if (dp[i][b] + calc(a, i) < dp[a][i] + calc(b, i)) {
				System.out.println(1);
				a = i;
			}
			else {
				System.out.println(2);
				b = i;
			}
		}
	} // main
	static final int INF = Integer.MAX_VALUE / 2;
	static int go(int aPos, int bPos) {
		if (aPos == M + 1 || bPos == M + 1) return 0;
		if (dp[aPos][bPos] != -1) return dp[aPos][bPos];
		int ret = INF;
		int mx = Math.max(aPos, bPos) + 1;
		ret = Math.min(go(mx, bPos) + calc(aPos, mx), go(aPos, mx) + calc(bPos, mx));
		return dp[aPos][bPos] = ret;
	}
	
	static int calc(int aPos, int bPos) {
		return Math.abs(arr[aPos][0] - arr[bPos][0]) + Math.abs(arr[aPos][1] - arr[bPos][1]);
	}
}
