import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		if (M == 1) {
			System.out.println(N % arr[1] == 0 ? N / arr[1] : -1);
			return;
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j < i; j++) {
				int a = arr[i] + arr[j];
				int b = arr[i];
				int c = arr[j];
				for (int k = 0; k <= N; k++) {
					if (dp[k] != Integer.MAX_VALUE / 2) {
						if (k + a <= N) {
							dp[k+a] = Math.min(dp[k] + 1, dp[k+a]);
						}
						if (k + b <= N) {
							dp[k+b] = Math.min(dp[k] + 1, dp[k+b]);
						}
						if (k + c <= N) {
							dp[k+c] =  Math.min(dp[k] + 1, dp[k+c]);
						}
					}
				}
			}
		}
		System.out.println(dp[N] == Integer.MAX_VALUE / 2 ? -1 : dp[N]);
	} // main
}