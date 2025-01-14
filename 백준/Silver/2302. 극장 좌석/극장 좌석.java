import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int[] arr = new int[M+1];
		int start = 0;
		long sum = 1;
		for (int i = 1; i <= M; i++) {
			int end = Integer.parseInt(br.readLine());
			sum *= (dp[end - 1 - start]);
			start = end;
		}
		sum *= (dp[N - start]);
		System.out.println(sum == 0 ? 1 : sum);
	} // main
}