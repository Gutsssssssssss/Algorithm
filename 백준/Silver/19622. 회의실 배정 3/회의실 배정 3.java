import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][2];
		int[] arr = new int[N+1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			arr[i] = cnt;
		}
		
		dp[1][1] = arr[1];
		dp[1][0] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]);
			dp[i][1] = Math.max(dp[i-2][1], dp[i-1][0]) + arr[i];
		}
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	} // main
}