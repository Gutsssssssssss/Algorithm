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
		long[] arr = new long[N+1];
		long[] psum = new long[N+1];
		arr[1] = 1;
		psum[1] = psum[0] + arr[1];
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + i;
			psum[i] = psum[i-1] + arr[i];
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		for (int j = 1; j <= N; j++) {
			int cnt = (int)psum[j];
			if (cnt < 0) break;
			for (int i = cnt; i <= N; i++) {
				if (i - cnt < 0 || i - cnt > N) break;
				dp[i] = Math.min(dp[i-cnt] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
//		for (int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
	} // main
}