import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, W, ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[31][31];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for (int i = 2; i <= 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 < 0 || j > i - 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
		}
		
		int sum = 0;
		int cnt = C - 1;
		for (int i = R - 1; i <= R - 2 + W; i++) {
			for (int j = C - 1; j <= cnt; j++) {
				sum += dp[i][j];
			}
			cnt++;
		}
		System.out.println(sum);
	} // main
	
}