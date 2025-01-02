import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] days = new int[N+1];
		int[] pays = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pays[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			if (i + days[i] <= N + 1) {
				dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + pays[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
		}
//		for (int i = 1; i <= N + 1; i++) {
//			System.out.print(dp[i] + " ");
//		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	} // main
}