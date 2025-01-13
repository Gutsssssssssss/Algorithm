import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			int[] arr = new int[] {1, 2, 3};
			
			dp[0] = 1;
			for (int i = 0; i < 3; i++) {
				for (int j = arr[i]; j <= N; j++) {
					dp[j] += dp[j-arr[i]];
				}
			}
			System.out.println(dp[N]);
		} // TC
	} // main
}