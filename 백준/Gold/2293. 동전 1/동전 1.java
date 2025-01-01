import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for (int j = 1; j <= N; j++) {
			int cur = arr[j];
			for (int i = cur; i <= K; i++) {
				dp[i] = dp[i] + dp[i-cur];
			}
		}
		
		System.out.println(dp[K]);
	} // main
}